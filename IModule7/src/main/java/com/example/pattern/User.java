package com.example.pattern;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="usertable")


public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	@Column(name="name")
	String name;
	@Column(name="age")
	int age;
	@Column(name="email")
	String email;
	
	User()
	{
		
	}
	
	User(String name, int age, String email)
	{
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
