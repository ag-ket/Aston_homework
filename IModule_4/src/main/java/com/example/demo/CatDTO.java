package com.example.demo;


import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class CatDTO {
	
	int id;
	@NotNull
	String name;
	@NotNull
	String nickname;
	@Min(1)
	@Max(10)
	@NotNull
	double malice;
	@NotNull
	double danger;
	@NotNull
	int crimeLevel;
	public CatDTO()
	{}
	
	public CatDTO(int id, String name, String nickname, double malice)
	{
		this.id = id;
		this.name = name;
		this.nickname = nickname;
		this.malice = malice;
		this.danger = setDanger(malice);
		this.crimeLevel = setCrimeLevel(danger);
 	}

	public int getId()
	{	
		return id;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getNickname()
	{
		return nickname;
	}
	
	public double getMalice()
	{
		return malice;
	}
	
	public double getDanger()
	{
		return danger;
	}
	
	public int getCrimeLevel()
	{
		return crimeLevel;
	}
	
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setNickname(String nickname)
	{
		this.nickname = nickname;
	}
	
	public void setMalice(double malice)
	{
		this.malice = malice;
	}
	
	public double setDanger(double malice)
	{
		return 3 + 0.3 * malice;
	}
	
	public int setCrimeLevel(double danger)
	{
		if (danger < 5)
			return 1;
		else if(danger >= 5 && danger < 7)
			return 2;
		else
			return 3;
	}
	
	public String toString()
	{
		return "id: " + id + "\nИмя: " + name + "\nПрозвище: " + nickname + "\nЗлоба: " + malice + "\nОпасность: " + danger + "\nУровень: " + crimeLevel;
	}
	

}
