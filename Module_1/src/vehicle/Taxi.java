package vehicle;

public class Taxi extends Vehicle implements Wheelable{

	@Override
	public boolean hasWheels() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public String workplace() {
		// TODO Auto-generated method stub
		return "Road";
	}


}
