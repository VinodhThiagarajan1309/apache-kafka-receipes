package com.vinodh.kafka.producer;

import oracle.jvm.hotspot.jfr.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class KafkaProducer {

    public static void main(String[] args) {

        Properties properties = new Properties();

        // kafka bootstrap server
        properties.setProperty("bootstrap.servers", "localhost:9092");
        properties.setProperty("key.serializer", StringSerializer.class.getName());
        properties.setProperty("value.serializer", StringSerializer.class.getName());
        // producer acks
        properties.setProperty("acks", "0");
        properties.setProperty("retries", "3");
        properties.setProperty("linger.ms", "1");

        org.apache.kafka.clients.producer.Producer<String, String> producer = new org.apache.kafka.clients.producer.KafkaProducer<String, String>(properties);


        for (int key=0; key < 10; key++){
            ProducerRecord<String, String> producerRecord =
                    new ProducerRecord<String, String>("megoo", Integer.toString(key), "message that has key: " + Integer.toString(key));
            producer.send(producerRecord);
        }



        producer.close();

    }
}
