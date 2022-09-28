package com.rabbitmq.test.rabbitmqtest;

import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.amqp.core.Queue;

@Component
class SenderTest {
    @Autowired
    RabbitMessagingTemplate template;

    @Bean
    Queue queue() {
        return new Queue("TestQ", false);
    }

    public void send(String message) {
        template.convertAndSend("TestQ", message);
    }
}