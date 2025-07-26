package vehicle;

public class Boat extends Vehicle implements Propellerable, CargoTransportation {

	@Override
	public boolean transportCargo() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean hasPropeller() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public String workplace() {
		// TODO Auto-generated method stub
		return "Water";
	}

}
