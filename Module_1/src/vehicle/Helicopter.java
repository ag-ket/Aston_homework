package vehicle;

public class Helicopter extends Vehicle implements Wheelable, Propellerable, CargoTransportation {

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
	public boolean hasWheels() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public String workplace() {
		// TODO Auto-generated method stub
		return "Air";
	}

}
