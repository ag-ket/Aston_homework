package vehicle;

public class Plane extends Vehicle implements Wheelable, Wingable, Propellerable, CargoTransportation {

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
	public boolean hasWings() {
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
