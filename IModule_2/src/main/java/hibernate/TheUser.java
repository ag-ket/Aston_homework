package hibernate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.*;

@Entity
@Table(name = "TheUser")
public class TheUser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="name")
	private String name;
	@Column(name="email")
	private String email;
	@Column(name="age")
	private int age;
	@Column(name="createdate")
	@CreationTimestamp
	private LocalDateTime created_at;
	
	int getid() {
		return id;
	}
	void setName(String name) {
		this.name = name;
	}
		
	String getName() {
		return name;
	}
	
	void setEmail(String email) {
		this.email = email;
	}
	
	String getEmail() {
		return email;
	}
		
	void setAge(int age) {
		this.age = age;
	}
	
	int getAge() {
		return age;
	}
		
	String getCreatedDate() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy - hh:mm");
        return created_at.format(formatter);
	}

}
