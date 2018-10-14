package ru.dumsky284.kafka.tutorial1;

import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

public class ProducerDemoKeys {



    public static void main(String[] args) throws ExecutionException, InterruptedException {

        final Logger logger = LoggerFactory.getLogger(ProducerDemoKeys.class);

        // Create Producer Properties
        // the list of properties can be found on kafka site in documetation
        Properties properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"127.0.0.1:9092");
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        // Create the producer
        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(properties);

        for (int i = 0; i < 10; i++) {

            // create producer record
            String topic = "first_topic";
            String value = "Message " + i +" from JAVA producer";
            String key = "Key_"+i;

            ProducerRecord<String, String> record = new ProducerRecord<String, String>(topic, key, value);

            logger.info("Key: " + key);
            // Key_0 goes to partition 1
            // Key_1 goes to partition 2
            // Key_2 goes to partition 2
            // Key_3 goes to partition 0
            // Key_4 goes to partition 2
            // Key_5 goes to partition 2
            // Key_6 goes to partition 1
            // Key_7 goes to partition 1
            // Key_8 goes to partition 0
            // Key_9 goes to partition 0

            // Send the data - asynchronous
            producer.send(record, new Callback() {
                public void onCompletion(RecordMetadata recordMetadata, Exception e) {
                    // executes every time the message is successfully sent or exception is thrown
                    if (e == null) {
                        //message sent
                        logger.info("New metadata received: \n" +
                                "Topic: " + recordMetadata.topic() + "\n" +
                                "Partition: " + recordMetadata.partition() + "\n" +
                                "Offset: " + recordMetadata.offset()
                        );

                    } else {
                        logger.error("Error occurred", e);

                    }
                }
            })
            .get(); // block the send to make it synchronous for testing puposes - DON't DO IT IN PRODUCTION!!!
        }

        // flush the data
        producer.flush();
        // flush and close the producer
        producer.close();

    }

}
