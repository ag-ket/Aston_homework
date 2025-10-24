package com.example.kafka;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Console implements CommandLineRunner {
	@Autowired
	UserController controller;


	@Override
	public void run(String... args) throws Exception {
	
        
        
//        controller.create(new UserDTO("test", 20, "test@cd.com"));
//        controller.create(new UserDTO("test1", 21, "test1@cd.com"));
//        controller.create(new UserDTO("test2", 22, "test2@cd.com"));
//        controller.create(new UserDTO("test3", 23, "test3@cd.com"));
        controller.delete(1);
        

        
        
    }
}
		

