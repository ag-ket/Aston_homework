package animal;

public class Bear extends Mammal implements Furable{
	
	String furType;

	@Override
	public boolean hasFur() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public String getFurType() {
		// TODO Auto-generated method stub
		return furType;
	}

	@Override
	public void setFurType(String furType) {
		// TODO Auto-generated method stub
		this.furType = furType;
	}

	@Override
	public void speak() {
		// TODO Auto-generated method stub
		System.out.println("Roar");
		
	}

}
