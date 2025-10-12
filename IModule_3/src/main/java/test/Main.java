package test;

public class Main {

	public static void main(String[] args) {
		DBConnection dbc = new DBConnection();
		
//		dbc.create(new TheCat("Мурзик", 4));
//		dbc.create(new TheCat("Васька", 9));
//		dbc.create(new TheCat ("Рыжик", 1));
		System.out.println(dbc.read());
		
		
		

	}

}
