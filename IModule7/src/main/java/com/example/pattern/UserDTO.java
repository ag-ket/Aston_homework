package com.example.pattern;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserDTO {
	private Long id;
	@NotBlank
	private String name;
	@NotBlank
	@Min(14)
	private int age;
	@NotBlank
	@Email
	@Size(min=1, max=250)
	private String email;
	
	UserDTO()
	{
		
	}
	
	UserDTO(String name, int age, String email)
	{
		this.name=name;
		this.age=age;
		this.email = email;
	}
	
	UserDTO(long id, String name, int age, String email)
	{
		this.id = id;
		this.name = name;
		this.age = age;
		this.email = email;
	}
	
	long getId()
	{
		return id;
	}
	
	String getName()
	{
		return name;
	}
	
	int getAge()
	{
		return age;
	}
	
	String getEmail()
	{
		return email;
	}
	
	void setId(long id)
	{
		this.id = id;
	}
	
	void setName(String name)
	{
		this.name = name;
	}
	void setAge(int age)
	{
		this.age = age;
	}
	void setEmail(String email)
	{
		this.email = email;
	}
	
	public String toString()
	{
		return "Пользователь\nID: "+ id + "\nИмя: " + name + "\nВозраст: " + age + "\nАдрес электронной почты: " + email;
	}

}
