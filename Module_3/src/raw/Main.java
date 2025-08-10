package raw;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
	
public static void main(String[] args) {
	
		
		ReadAndWrite raw = new ReadAndWrite();
		try {
			raw.createFile("test");
		} catch (TheException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			raw.write();
		} catch (TheException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			raw.read("test");
		} catch (TheException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}


}
