package com.rabbitmq.test.rabbitmqtest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class MessageTestController {

    @Autowired
    SenderTest sender;

    @PostMapping("/messages")
    public String sendMessage(final @RequestBody Map<String,String> req ) {
        String message = req.get("message");
        try {
            sender.send(message);
            return "send message success";
        }
        catch (Exception e ){
            System.out.println(e.getMessage());
            return "send message fail";
        }
    }
}