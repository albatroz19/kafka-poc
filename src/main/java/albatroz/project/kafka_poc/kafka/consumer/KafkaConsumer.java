package albatroz.project.kafka_poc.kafka.consumer;

import albatroz.project.kafka_poc.entity.User;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = "my-new-topic", groupId = "my-group-id")
    public void consume(String message) {
        System.out.println(String.format("Message received -> %s", message));
    }

    @KafkaListener(topics = "json-topic", groupId = "my-group-id")
    public void consume(User user) {
        System.out.printf("Message received -> %s%n", user.toString());
    }

}
