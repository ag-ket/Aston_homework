
package animal;

public class Fish extends Animal implements Liwable {

	@Override
	public boolean liveInWater() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean breatheUnderwater() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void speak() {
		// TODO Auto-generated method stub
		System.out.println("Fish doesn't talk");
		
	}

}
