package com.github.marlonflorencio.kafka.stream;

import io.confluent.kafka.schemaregistry.avro.AvroSchema;
import io.confluent.kafka.schemaregistry.avro.AvroSchemaUtils;
import io.confluent.kafka.serializers.KafkaAvroSerializer;
import io.confluent.kafka.serializers.KafkaAvroSerializerConfig;
import org.apache.avro.Schema;
import org.apache.avro.util.Utf8;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.ExecutionException;

public class GenericProducer {

    private static final Logger log = LoggerFactory.getLogger(GenericProducer.class);
    private static final String TOPIC = "criacao-entrega-v5-topic";

    private static final  String SCHEMA = "{\n" +
            "  \"fields\": [\n" +
            "    {\n" +
            "      \"name\": \"endereco\",\n" +
            "      \"type\": \"string\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"numero\",\n" +
            "      \"type\": \"string\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"cidade\",\n" +
            "      \"type\": \"string\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"status\",\n" +
            "      \"type\": \"string\"\n" +
            "    }\n" +
            "  ],\n" +
            "  \"name\": \"Entrega\",\n" +
            "  \"namespace\": \"com.github.marlonflorencio.kafka.model\",\n" +
            "  \"type\": \"record\"\n" +
            "}\n";

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        String json = "{\"endereco\": \"Av 18 do Forte\", \"numero\": \"6\", \"cidade\": \"Rio de Janeiro\", \"status\": \"NEW\"}";

        KafkaProducer<Object, Object> producer = createProducer();

        //GenericData.Record o = (GenericData.Record) readFrom(json, SCHEMA);

        ProducerRecord<Object, Object> record = new ProducerRecord<>(TOPIC,  readFrom(json, SCHEMA));

        try {
            producer.send(record);
        } catch(SerializationException e) {
            e.printStackTrace();
        }

        finally {
            producer.flush();
            producer.close();
        }
    }

    private static KafkaProducer<Object, Object> createProducer() {
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class.getName());
        props.put(KafkaAvroSerializerConfig.SCHEMA_REGISTRY_URL_CONFIG, "http://localhost:8081");

        KafkaProducer<Object, Object> producer = new KafkaProducer<>(props);
        Runtime.getRuntime().addShutdownHook(new Thread(producer::close));
        return producer;
    }

    protected static Object readFrom(String jsonString, String schemaAsString) {

        Schema.Parser parser = new Schema.Parser();
        AvroSchema avroSchema = new AvroSchema(parser.parse(schemaAsString));

        Schema schema = avroSchema.rawSchema();
        try {
            Object object = AvroSchemaUtils.toObject(jsonString, avroSchema);
            if (schema.getType().equals(Schema.Type.STRING)) {
                object = ((Utf8) object).toString();
            }
            return object;
        } catch (IOException e) {
            throw new SerializationException(
                    String.format("Error deserializing json %s to Avro of schema %s", jsonString, schema), e
            );
        }
    }
}
