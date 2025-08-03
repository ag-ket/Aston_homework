package student;

import java.util.ArrayList;
import java.util.List;

public class Student {
	
	List <Book> books = new ArrayList<>();
	
	String firstName;
	String lastName;

	public Student(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public String getFirstName()
	{
		return firstName;
	}
	
	public String getLastName()
	{
		return lastName;
	}
	
	public String getName()
	{
		return firstName + " " + lastName;
	}
	
	List <Book> getBookList()
	{
		return books;
	}
	
	@Override
	public String toString()
	{
		return firstName + " " + lastName;
	}

}
