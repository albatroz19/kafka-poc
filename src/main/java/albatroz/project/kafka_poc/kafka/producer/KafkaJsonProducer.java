package albatroz.project.kafka_poc.kafka.producer;

import albatroz.project.kafka_poc.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class KafkaJsonProducer {

    @Autowired
    private KafkaTemplate <String, Object> kafkaTemplate;

    private static final Logger LOGGER = Logger.getLogger(KafkaJsonProducer.class.getName());

    public void sendMessage(User user){

        LOGGER.info("Message sent -> " + user.toString());

        Message<User> message = MessageBuilder
                .withPayload(user)
                .setHeader(KafkaHeaders.TOPIC,"json-topic")
                .build();
        kafkaTemplate.send(message);
    }

}
