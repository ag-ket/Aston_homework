
package animal;

public class Whale extends Mammal implements Liwable{
	
	

	@Override
	public boolean liveInWater() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean breatheUnderwater() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void speak() {
		// TODO Auto-generated method stub
		System.out.println("Whistl");
	}

}
