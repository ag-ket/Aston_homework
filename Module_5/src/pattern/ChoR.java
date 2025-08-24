package pattern;



public class ChoR {
	
	static int problemLevel = 30;

	public static void main(String[] args) {
		FirstHunter hunter1 = new FirstHunter();
		HunterCommander hunter2 = new HunterCommander(hunter1);
		SimpleHunter hunter3 = new SimpleHunter(hunter2);
		
		hunter3.makeDecision();

	}
	
	static void problemDescription()
	{
		if (problemLevel < 6)
			System.out.println("Приближается зомби-одиночка");
		else if (problemLevel > 5 && problemLevel < 16)
			System.out.println("Приближается группа зомби");
		else if (problemLevel > 15 && problemLevel < 31)
			System.out.println("Приближаются несколько хорошо организованных групп зомби");
		else
			System.out.println("Надвигается орда зомби, уничтожающая всё на своём пути");
		
	}
	
	static interface Decision
	{
		void makeDecision(); 
	}
	

	static class SimpleHunter implements Decision
	{
		private int hunterDecisionLevel = 5;
		private Decision next;
		
		SimpleHunter(Decision next)
		{
			this.next = next;
		}

		@Override
		public void makeDecision() {
			
			problemDescription();
			
			if (problemLevel <= hunterDecisionLevel)
				System.out.println("Покойтесь с миром, зомби");
			else
			{
				System.out.println("О-они слишком сильны. Призываю помощь");
				next.makeDecision();
			}
			
		}

		
		
	}
	
	static class HunterCommander implements Decision
	{
		private int hunterDecisionLevel = 15;
		private Decision next;
		
		HunterCommander(Decision next)
		{
			this.next = next;
		}

		@Override
		public void makeDecision() {
			
			problemDescription();
			
			if (problemLevel <= hunterDecisionLevel)
				System.out.println("Умрите, проклятые твари!");
			
			else
			{
				System.out.println("Вызываю подкрепление");
				next.makeDecision();
			}
			
				
		}

		
		
	}
	
	static class FirstHunter implements Decision
	{
		int hunterDecisionLevel = 30;
		
	

		@Override
		public void makeDecision() {
			problemDescription();
			
			if (problemLevel <= hunterDecisionLevel)
			{
				System.out.println("Смерть зомби!");
				
			}
			else
			{
				System.out.println("Это конец, да спасёт Господь наши души");
				
			}
		}

		
	}
	
	
	

}
