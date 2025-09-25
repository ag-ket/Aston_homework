package map;

public class Main {

	public static void main(String[] args) {
		TheHashMap map = new TheHashMap();
		
		Object test = new Object();
		
		map.put(1, "one");
		map.put(2, "two");
		map.put(1, "three");
		map.put(true, false);
		map.put(test, "test");
		
		System.out.println(map);
		System.out.println(map.get(2));
		
		map.remove(1);
		map.remove(true);
		
		System.out.println(map);
		


	}

}
