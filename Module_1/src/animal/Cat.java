
package animal;

public class Cat extends Mammal implements Furable{
	
	String furType;

	@Override
	public void speak() {
		
		System.out.println ("Meow");
		
	}

	@Override
	public boolean hasFur() {
		
		return true;
	}

	@Override
	public String getFurType() {
		
		return furType;
	}

	@Override
	public void setFurType(String furType) {
		
		this.furType = furType;
		

		
	}

}
