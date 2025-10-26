package com.example.swagger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

public class Console implements CommandLineRunner {
	@Autowired
	UserController controller;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
