package student;

import java.util.HashSet;
import java.util.*;


public class CollectionTest {

	

	public static void main(String[] args) {
		TheSet <String> testSet1 = new TheSet<>();
		TheSet <Integer> testSet2 = new TheSet<>();
		
		testSet1.add("One");
		testSet1.add("Two");
		testSet1.add("Two");
		testSet1.add("Three");
		
		System.out.println(testSet1);
		
		for (String s : testSet1)
			System.out.println(s);
		
		testSet2.add(0);
		testSet2.add(1);
		testSet2.add(2);
		testSet2.add(3);
		
		
		
		Iterator iter = testSet2.iterator();
		
		while (iter.hasNext())
			System.out.println(iter.next());
		
		TheList <Integer> testList = new TheList<>();
		
		testList.add(1);
		testList.add(2);
		testList.add(4);
		testList.add(5);
		testList.add(7);
		
		
		System.out.println(testList);
		
		List <Integer> testList2 = new ArrayList<>();
		
		testList2.add(0);
		testList2.add(10);
		testList2.add(100);
		
		
		
		testList.addAll(testList2);
		
		testList.remove(7);
		
		
		System.out.println(testList);
		
		System.out.println(testList.get(3));
		
		Iterator iter2 = testList.iterator();
		
//		while (iter2.hasNext())
//			System.out.println(iter2.next());
		
		for (int i : testList)
		{
			System.out.println(i);
		}
		
		
		
		
		

	}

}
