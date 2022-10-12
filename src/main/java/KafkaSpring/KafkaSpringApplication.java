package KafkaSpring;

import KafkaSpring.model.UserDTO;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.*;
import org.springframework.kafka.annotation.*;

@EnableKafka
@SpringBootApplication
public class KafkaSpringApplication {

    @KafkaListener(topics = "msg")
    public void orderListener(ConsumerRecord<Long, UserDTO> record) {
        System.out.printf("partition:%s, key:%s, value:%s\n",
                record.partition(), record.key(), record.value());
    }

    public static void main(String[] args) {
        SpringApplication.run(KafkaSpringApplication.class, args);
    }

}