package animal;

public class Main {

	public static void main(String[] args) {
		
		Cat cat = new Cat();
		
		cat.speak();
		
		Bear bear = new Bear();
		
		bear.setFurType("Coarse fur");
		
		System.out.println(bear.getFurType());
		
		bear.speak();
		
		if (bear.hasFur())
			System.out.println("Bear has fur");
		
		if (cat.vertebrate())
			System.out.println("How many vertebrae does cat have?");
		
		Whale whale = new Whale();
		
		System.out.println("Does a whale live in water? "+whale.liveInWater());
		
		System.out.println("Can a whale breathe underwater? "+whale.breatheUnderwater());
		
		whale.setName("Orca");
		
		System.out.println(whale.getName());
		
		Fish fish = new Fish();
		
		System.out.println("Does a fish live in water? "+fish.liveInWater());
		
		System.out.println("Can a fish breathe underwater? "+fish.breatheUnderwater());
		
		fish.speak();
	

	}

}
