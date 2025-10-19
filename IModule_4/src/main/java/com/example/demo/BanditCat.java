package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

@Entity
@Table(name="banditcat")
public class BanditCat {

	@Id
	@Column(name="id")
	int id;

	@Column(name="name")
	String name;

	@Column (name="nickname")
	String nickname;
	
	@Min(1)
	@Max(10)
	@Column (name="malice")
	double malice;

	@Column (name="danger")
	double danger;

	@Column (name="crimelevel")
	int crimeLevel;
	
	BanditCat()
	{}
	
	BanditCat(int id, String name, String nickname, double malice)
	{
		this.id = id;
		this.name = name;
		this.nickname = nickname;
		this.malice = malice;
		this.danger = setDanger(malice);
		this.crimeLevel = setCrimeLevel(danger);
 	}

	int getId()
	{	
		return id;
	}
	
	String getName()
	{
		return name;
	}
	
	String getNickname()
	{
		return nickname;
	}
	
	double getMalice()
	{
		return malice;
	}
	
	double getDanger()
	{
		return danger;
	}
	
	int getCrimeLevel()
	{
		return crimeLevel;
	}
	
	void setId(int id)
	{
		this.id = id;
	}
	
	
	void setName(String name)
	{
		this.name = name;
	}
	
	void setNickname(String nickname)
	{
		this.nickname = nickname;
	}
	
	void setMalice(double malice)
	{
		this.malice = malice;
	}
	
	double setDanger(double malice)
	{
		return 3 + 0.3 * malice;
	}
	
	int setCrimeLevel(double danger)
	{
		if (danger < 5)
			return 1;
		else if(danger >= 5 && danger < 7)
			return 2;
		else
			return 3;
	}
	
	
	
	
	
	
	






}
