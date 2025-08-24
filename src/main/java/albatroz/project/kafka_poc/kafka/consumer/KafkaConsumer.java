package albatroz.project.kafka_poc.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = "my-new-topic", groupId = "my-group-id")
    public void consume(String message) {
        System.out.println(String.format("Message received -> %s", message));
    }

}
