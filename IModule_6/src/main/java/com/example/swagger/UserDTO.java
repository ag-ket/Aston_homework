package com.example.swagger;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Schema(description="Сущность пользователя", accessMode = Schema.AccessMode.READ_ONLY)
public class UserDTO {
	@Schema(description="Идентификатор пользователя", example = "1", accessMode = Schema.AccessMode.READ_ONLY)
	private Long id;
	@Schema(description="ФИО пользователя", example = "Иванов Иван Иванович", accessMode = Schema.AccessMode.READ_ONLY)
	@NotBlank
	private String name;
	@Schema(description="Возраст пользователя", example = "18", minimum = "14", accessMode = Schema.AccessMode.READ_ONLY)
	@NotBlank
	@Min(14)
	private int age;
	@Schema(description="Адрес электронной почты пользователя", example = "example@example.com", format = "email", accessMode = Schema.AccessMode.READ_ONLY)
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
