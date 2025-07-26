package animal;

public abstract class Animal {
	
	String name;
	
	public void setName(String name)
	{
		this.name=name;
	}
	
	public String getName()
	{
		return name;
	}
	
	public abstract void speak ();
	

}
