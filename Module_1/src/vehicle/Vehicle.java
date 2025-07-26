package vehicle;

public abstract class Vehicle {
	
	String name;
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name=name;
	}
	
	public abstract String workplace();

}
