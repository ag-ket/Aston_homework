package map;

import java.util.Arrays;

public class TheHashMap <K, V>{

	private Cell [] map = new Cell[16];
	private int count = 0;
	private int hash;
	
	void put(K key, V value)
	{
		
		if (key == null)
			hash = 0;
		else hash = key.hashCode();
		Cell cell = new Cell (hash, key, value);
		int up = 1;
		int hashfun = hash1(hash, map.length);
		
		while (map[hashfun]!=null)
		{
			if (map[hashfun].getHash() == hash)
			{
				map[hashfun].setValue(value);
				break;
			}
			else
			{
				
				hashfun = (hash1(hash, map.length) + up * hash2(hash, map.length)) % map.length;
				up++;
			}
		}
		map[hashfun] = cell;
		count++;
		
		if(count >= map.length * 0.75)
			grow();	
	}
	
	
	public V get(K key)
	{
		if (key == null)
			hash = 0;
		else
			hash = key.hashCode();
		
		int up = 1;
		
		int hashfun = hash1(hash, map.length);
		
		while (map[hashfun].getHash() != hash)
		{
			hashfun = (hash1(hash, map.length) + up * hash2(hash, map.length)) % map.length;
			up++;
		}
		
		return (V) map[hashfun].getValue();
	}
	
	void remove(K key)
	{
		if (key == null)
			hash = 0;
		else
			hash = key.hashCode();
		
		int up = 1;
		int hashfun = hash1(hash, map.length);
		
		while (map[hashfun].getHash()!=hash)
		{
			hashfun = (hash1(hash, map.length) + up * hash2(hash, map.length)) % map.length;
			up++;
		}
		
		map[hashfun] = null;
	}
	
	void grow()
	{
		map = Arrays.copyOf(map, map.length * 2);
		//System.out.println("I'm grow!!");
	}
	
	int hash1(int hash, int size)
	{
		return (int) Math.round((0.720299327688797*Math.abs(hash)%1)*size);
	}
	
	int hash2(int hash, int size)
	{
		return Math.abs(hash) % (size - 1) + 1;
	}
	
	@Override
	public String toString()
	{
		return Arrays.toString(map);
		
	}
	
	
	
	
	
	
	
	private class Cell <K, V>
	{
		private int hash;
		private K key;
		private V value;
		
		Cell(int hash, K key, V value)
		{
			this.hash = hash;
			this.key = key;
			this.value = value;
		}
		
		private int getHash()
		{
			return hash;
		}
		
		private V getValue()
		{
			return value;
		}
		
		private void setValue(V value)
		{
			this.value = value;
		}
		
		@Override
		public String toString()
		{
			return key + " : " + value;
			
		}
	}

}
