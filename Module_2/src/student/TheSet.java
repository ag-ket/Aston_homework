package student;

import java.util.HashMap;
import java.util.Iterator;

public class TheSet <T> implements Iterable<T>{
	
	
	private final String VALUE = "Constant";
	
	private HashMap <T, String> map = new HashMap <>();
	
	public void add (T t)
	
	{
		map.put(t, VALUE);
	}
	
	public void remove (Object o)
	{
		map.remove(o);
	}
	
	@Override
	public Iterator <T> iterator()
	{
		return map.keySet().iterator();
	}
	
	@Override
	public String toString()
	{
		return map.keySet().toString();
	}
	



}
