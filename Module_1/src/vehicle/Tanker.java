package vehicle;

public class Tanker extends Vehicle implements Propellerable, CargoTransportation {

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
