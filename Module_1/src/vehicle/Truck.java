package vehicle;

public class Truck extends Vehicle implements Wheelable, CargoTransportation{

	@Override
	public boolean transportCargo() {
		// TODO Auto-generated method stub
		return true;
	}

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
