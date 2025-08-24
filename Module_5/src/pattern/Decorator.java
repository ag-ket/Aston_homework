package pattern;

import java.util.Random;

public class Decorator {

	static Random random = new Random();

	public static void main(String[] args) {
		SimpleHunter hunter1 = new SimpleHunter(new BaseHunter());
		HunterCommander hunter2 = new HunterCommander(new BaseHunter(false));
		FirstHunter hunter3 = new FirstHunter(new BaseHunter());
		
		makeDescription(hunter1);
		makeDescription(hunter2);
		makeDescription(hunter3);
		

	}
	
	static void makeDescription(Hunt hunt)
	{
		System.out.println(hunt.hunterCondition());
		System.out.println("Его уровень: " + hunt.hunterLevel());
		System.out.println("Его урон: " + hunt.damage());
	}
	
	static interface Hunt
	{
		String hunterCondition();
		int hunterLevel();
		int damage();
		
	}
	
	static class BaseHunter implements Hunt
	{
		private boolean rage = true;
		private int hunterLevel = random.nextInt(11 - 1) + 1;
		
		BaseHunter()
		{
			
		}
		
		BaseHunter(boolean rage)
		{
			this.rage = rage;
		}

		public boolean hasRage() {
			
			return rage;
		}
		
		@Override
		public String hunterCondition() {
			
			if (hasRage())
				return "в ярости. Он готов уничтожать зомби";
			else
				return "сдался. Он готов к смерти";
		}

		@Override
		public int hunterLevel() {
			
			return hunterLevel;
		}

		@Override
		public int damage() {
			
			if (hasRage())
				return hunterLevel;
			else
				return 0;
		
		}	
		
	}
	
	static abstract class HunterDecorator implements Hunt
	{
		private Hunt hunt;
		
		HunterDecorator(Hunt hunt)
		{
			this.hunt = hunt;
		}


		@Override
		public String hunterCondition() {
			
			return hunt.hunterCondition();
		}

		@Override
		public int hunterLevel() {
			// TODO Auto-generated method stub
			return hunt.hunterLevel();
		}

		@Override
		public int damage() {
			// TODO Auto-generated method stub
			return hunt.damage();
		}
		
	}
	
	static class SimpleHunter extends HunterDecorator
	{

		SimpleHunter(Hunt hunt) {
			super(hunt);
		}
		
		@Override
		public String hunterCondition() {
			
			return "Охотник " + super.hunterCondition();
			
		}
			

		@Override
		public int hunterLevel() {
			
			return super.hunterLevel();
		}

		@Override
		public int damage() {
			
			return super.damage() * 2;
		
		}	
		
	}
	
	static class HunterCommander extends HunterDecorator
	{

		HunterCommander(Hunt hunt) {
			super(hunt);
		}
		
		@Override
		public String hunterCondition() {
			
			return "Охотник-командир " + super.hunterCondition();
			
		}
			

		@Override
		public int hunterLevel() {
			
			return super.hunterLevel() + 15;
		}

		@Override
		public int damage() {
			
			return super.damage() * 4;
		
		}	
	
	}
	
	static class FirstHunter extends HunterDecorator
	{

		FirstHunter(Hunt hunt) {
			super(hunt);
		}
		
		@Override
		public String hunterCondition() {
			
			return "Главный охотник " + super.hunterCondition();
			
		}
			

		@Override
		public int hunterLevel() {
			
			return super.hunterLevel() + 30;
		}

		@Override
		public int damage() {
			
			return super.damage() * 8;
		
		}	
		
	}

}
