package com.github.marlonflorencio.kafka.stream;

import com.github.marlonflorencio.kafka.model.Entrega;
import io.confluent.kafka.serializers.KafkaAvroSerializer;
import io.confluent.kafka.serializers.KafkaAvroSerializerConfig;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

public class CriarEntregaProducer {

    private static final Logger log = LoggerFactory.getLogger(CriarEntregaProducer.class);
    private static final String TOPIC = "criacao-entrega-v5-topic";

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class.getName());
        props.put(KafkaAvroSerializerConfig.SCHEMA_REGISTRY_URL_CONFIG, "http://localhost:8081");

        KafkaProducer<String, Entrega> producer = new KafkaProducer<>(props);
        Runtime.getRuntime().addShutdownHook(new Thread(producer::close));

        Entrega value;

        long i = 1;

        while( i <= 1) {

            value = Entrega.newBuilder()
                    .setEndereco("Av 18 do Forte")
                    .setNumero("5")
                    .setCidade("Rio de Janeiro")
                    .setStatus("NEW")
                    .build();

            producer.send(new ProducerRecord<>(TOPIC, String.valueOf(i), value));
            i++;
        }
    }
}
