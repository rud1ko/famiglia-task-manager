package Task.management.project.in.famiglia.app.controller;

import Task.management.project.in.famiglia.app.kafka.KafkaProducer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    private final KafkaProducer kafkaProducer;

    public Controller(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/kafka/send")
    public String send(@RequestBody String message) {
        kafkaProducer.sendMessage(message);

        return "Success";
    }
}
