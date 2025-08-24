package albatroz.project.kafka_poc.controller;

import albatroz.project.kafka_poc.entity.User;
import albatroz.project.kafka_poc.kafka.producer.KafkaJsonProducer;
import albatroz.project.kafka_poc.kafka.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/kafka")
public class MessageController {

    @Autowired
    private KafkaProducer kafkaProducer;

    @Autowired
    private KafkaJsonProducer kafkaJsonProducer;

    @PostMapping("/publish")
    public ResponseEntity<String> sendMessageToKafkaTopic(@RequestParam String message) {
        this.kafkaProducer.sendMessage(message);
        return ResponseEntity.ok("Message sent to Kafka Topic");
    }

    @PostMapping("/publish/json")
    public ResponseEntity<String> sendMessageToKafkaTopic(@RequestBody User user) {
        kafkaJsonProducer.sendMessage(user);
        return ResponseEntity.ok("Message sent to Kafka Topic");
    }

}
