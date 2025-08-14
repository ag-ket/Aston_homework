package threads;

public class LiveLock {
	
	static class TheCat
	{
		private boolean fightDesire;
		private boolean hiss;
		private String catName;
		
		TheCat(String catName, boolean fightDesire, boolean hiss)
		{
			this.catName = catName;
			this.fightDesire = fightDesire;
			this.hiss = hiss;
			
		}
		
		boolean wantsFigth()
		{
			return fightDesire;
		}
		
		boolean isHissing()
		{
			return hiss;
		}
		
		void toHiss()
		{
			hiss = true;
			System.out.println(catName + " злобно шипит");
		}
		
		void toAttack()
		{
			System.out.println(catName + " смело сражается");
			System.out.println("Враг молит о пощаде");
			System.out.println(catName + " побеждает жалкого врага и уходит вдаль, гордо задрав хвост");
			fightDesire = false;
		}
	}
	
	public static void fight(TheCat theCat, TheCat enemyCat)
	{
		while(theCat.wantsFigth())
		{
			if (enemyCat.isHissing())
				theCat.toHiss();
			else
				theCat.toAttack();
			
		}
	}

	public static void main(String[] args) {
		
		TheCat firstCat = new TheCat("Черныш", true, true);
		TheCat secondCat = new TheCat("Рыжик", true, true);
		
		Thread firstFight = new Thread(()->fight(firstCat, secondCat));
		Thread secondFight = new Thread(()->fight(secondCat, firstCat));
		
		firstFight.start();
		secondFight.start();
		

	}

}
