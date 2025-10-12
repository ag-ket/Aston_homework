package test;

import java.util.List;

public class WorkWithResult {
	List <TheCat> list;
	
	public WorkWithResult(List <TheCat> list)
	{
		this.list = list;
	}

	
	DBConnection connection = new DBConnection();
	public int getId (int number) 
	{
		return list.get(number - 1).getId();
	}
	
	
	public String getCatInfo (int number) 
	{
		return list.get(number - 1).toString();
	}
	
	public TheCat getCat (int number)
	{
		return list.get(number - 1);
	}

}
