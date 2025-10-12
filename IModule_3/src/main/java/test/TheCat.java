package test;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "thecat")
public class TheCat {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="name")
	private String name;
	@Column(name="age")
	private int age;
	@Column(name="sly")
	private double sly;
	@Column(name="impudent")
	private double impudent;
	
	TheCat(){}
	
	public TheCat(String name, int age)
	{
		this.name = name;
		this.age = age;
		sly = setSly(age);
		impudent = setImpudent(sly);
	}

	public int getId() {
		return id;
	}
	
	void setName(String name) {
		this.name = name;
	}
		
	public String getName() {
		return name;
	}
	
	void setAge(int age) {
		if (age > 0)
			this.age = age;
		else
			System.out.println("Возраст не может быть отрицательным");
	}
	
	int getAge() {
		return age;
	}
		
	double setSly(int age) {
		double ageK = 0;
		if (age <= 5)
			ageK = 0.3;
		else if (age > 5 && age <=10)
			ageK = 0.5;
		else if (age > 10 && age <=15)
			ageK = 0.7;
		else if (age > 15)
			ageK = 0.9;
		
		return age * ageK + 100.0; 
	}
	
	double getSly() {
		return sly;
	}
		
	double setImpudent(double sly) {
		double impudentConst = 0.93;
		return Math.round((sly * impudentConst + 100.0) * 100.0) / 100.0;
	}
	
	double getImpudent() {
		return impudent;
	}
	
	public String toString()
	{
		return "Имя кота: " + name + "\nВозраст кота: " + age + "\nХитрость кота: " + sly + "\nНаглость кота: " + impudent;
	}
	

}

