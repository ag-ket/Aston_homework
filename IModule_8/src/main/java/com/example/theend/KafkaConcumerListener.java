package com.example.theend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


@Component
public class KafkaConcumerListener {
	@Autowired
	KafkaMessageService service;
    @KafkaListener(topics = "create", groupId = "group-user")
    public void createListen(String message) {
    	service.newMail(message, "Здравствуйте! Ваш аккаунт на сайте ваш сайт был успешно создан.");
    }
    
    @KafkaListener(topics = "delete", groupId = "group-user")
    public void deleteListen(String message) {
    	service.newMail(message, "Здравствуйте! Ваш аккаунт был удалён.");
    }
}
