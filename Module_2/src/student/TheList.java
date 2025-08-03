package student;

import java.util.Collection;
import java.util.Collection.*;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class TheList <T> implements Iterable<T>{

	private T[] array = null;
	private T[] removeArray;
	private T[] addArray;
	private T[] addAllArray;
	
	public void add(int i, T t)
	
	{		
		if (array == null)
		{
			addArray = (T[]) new Object[1];
			addArray[0] = t;
		}
		
		else
		{
			addArray = (T[])new Object [array.length + 1];
			System.arraycopy(array, 0, addArray, 0, i);
			addArray[i] = t;
			System.arraycopy(array, i, addArray, i + 1, array.length - i);
		}
		
		array = addArray;
	}
	
	public void add(T t)
	
	{
		if (array == null)
		{
			addArray = (T[]) new Object[1];
			addArray[0] = t;
		}
		
		else
			add(array.length, t);
		
		array = addArray;
	}
	
	
	public void addAll(int i, Collection <?> c)
	{
		if (array == null)
			addAllArray = c.toArray((T[])new Object [c.size()]);
		
		else
		{			
			addAllArray = (T[])new Object [array.length + c.size()];
			System.arraycopy(array, 0, addAllArray, 0, i);
			System.arraycopy(c.toArray(), 0, addAllArray, i, c.size());
			System.arraycopy(array, i, addAllArray, i + c.size(), array.length - i);
		}
		
		array = addAllArray;
		
	}
	
	public void addAll(Collection <? extends T> c)
	{
		if (array == null)
			addAllArray = c.toArray((T[])new Object [c.size()]);
		
		else
			addAll(array.length, c);
	}

	
	public void remove(int index)
	
	{
		removeArray = (T[])new Object [array.length-1];
		System.arraycopy(array, 0, removeArray, 0, index);
		System.arraycopy(array, index + 1, removeArray, index, array.length - 1 - index);	
		array = removeArray;
	}
	
	public T get(int index)
	{
		return array[index];
	}
	
	public int size()
	{
		return array.length;
	}
	
	@Override
	public String toString()
	{
		return Arrays.toString(array);
		
	}


	@Override
	public Iterator <T> iterator() {

		return new TheIterator <T>();
	}
	
	
	private class TheIterator <T> implements Iterator
	{
		int index = 0;

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return index < array.length && array[index] != null;
		}

		@Override
		public Object next() {
			
			return array[index++];
			
		}
		
	}

	

	


}
