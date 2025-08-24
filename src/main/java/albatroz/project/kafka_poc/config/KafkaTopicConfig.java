package albatroz.project.kafka_poc.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic createTopic(){
        return new NewTopic("my-new-topic",10,(short)1);
    }

    @Bean
    public NewTopic createJsonTopic(){
        return new NewTopic("json-topic",10,(short)1);
    }

}
