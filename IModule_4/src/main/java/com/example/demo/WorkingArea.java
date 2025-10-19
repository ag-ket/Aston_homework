package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class WorkingArea implements CommandLineRunner {
	@Autowired
	private CatController controller;

	@Override
	public void run(String... args) throws Exception {
		
		
		//controller.create(new CatDTO (1, "Рыжик", "Рыжий мститель", 6.5));
		System.out.println(controller.getById(1));
		
	}

}
