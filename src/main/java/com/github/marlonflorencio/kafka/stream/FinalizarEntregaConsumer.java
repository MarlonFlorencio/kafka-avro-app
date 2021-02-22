package com.github.marlonflorencio.kafka.stream;

import com.github.marlonflorencio.kafka.model.Entrega;
import io.confluent.kafka.serializers.KafkaAvroDeserializer;
import io.confluent.kafka.serializers.KafkaAvroDeserializerConfig;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

public class FinalizarEntregaConsumer {

    private static final Logger log = LoggerFactory.getLogger(FinalizarEntregaConsumer.class);
    private static final String TOPIC = "criacao-entrega-v5-topic";

    public static void main(String[] args) {

        Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, KafkaAvroDeserializer.class.getName());
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "finalizar.consumer");
        props.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        props.put(KafkaAvroDeserializerConfig.SCHEMA_REGISTRY_URL_CONFIG, "http://localhost:8081");
        props.put(KafkaAvroDeserializerConfig.SPECIFIC_AVRO_READER_CONFIG, "true");

        Consumer<String, Entrega> consumer = new KafkaConsumer<>(props);

        Thread haltedHook = new Thread(consumer::close);
        Runtime.getRuntime().addShutdownHook(haltedHook);

        consumer.subscribe(Collections.singletonList(TOPIC));

        while (true) {
            ConsumerRecords<String, Entrega> records = consumer.poll(Duration.ofMillis(100));
            records.forEach(record -> processOrder(record.value()));
        }
    }

    private static void processOrder(Entrega obj) {
        log.info("Finalizar entrega : " + obj.getEndereco() + "," + obj.getNumero() + " - " + obj.getCidade() + ". -> STATUS: " + obj.getStatus()) ;
    }

}

