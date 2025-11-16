package com.example.theend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class KafkaMessageService {
	@Autowired
    private JavaMailSender sender;
	
	void newMail(String emailTo, String text)
	{
		final SimpleMailMessage simpleMail = new SimpleMailMessage();
		simpleMail.setFrom("boss@cd.com");
		simpleMail.setTo(emailTo);
		simpleMail.setSubject("Изменения в базе данных");
		simpleMail.setText(text);
		sender.send(simpleMail);
		System.out.println("Сообщение отправлено");
	}

	
	

}
