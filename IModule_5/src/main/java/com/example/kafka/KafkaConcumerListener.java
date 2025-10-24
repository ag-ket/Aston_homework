package com.example.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


@Component
public class KafkaConcumerListener {
	@Autowired
	MessageAPI api;
    @KafkaListener(topics = "create", groupId = "group-user")
    public void createListen(String message) {
    	api.newMail(message, "Здравствуйте! Ваш аккаунт на сайте ваш сайт был успешно создан.");
    }
    
    @KafkaListener(topics = "delete", groupId = "group-user")
    public void deleteListen(String message) {
    	api.newMail(message, "Здравствуйте! Ваш аккаунт был удалён.");
    }
}