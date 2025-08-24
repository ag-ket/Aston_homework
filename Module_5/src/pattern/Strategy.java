package pattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Strategy {
	
	
	

	public static void main(String[] args) {
		
		Random random = new Random();
		
		ArrayList <String> ranged = new ArrayList<>(Arrays.asList("Самодельный арбалет", "Лук из ветки дерева", "Старый револьвер"));
		ArrayList <String> melee = new ArrayList<>(Arrays.asList("Молоток с деревянной ручкой", "Железная труба", "Заточенная арматура"));
		
		int randomWeaponLevel = random.nextInt(31);
		int randomRangedName = random.nextInt(ranged.size());
		int randomMeleeName = random.nextInt(melee.size());
				
		
		KillingWay kw = new KillingWay();
		
		kw.setKillingWay(new RangedWeapon(ranged.get(randomRangedName), randomWeaponLevel));
		kw.fightTime();
		
		kw.setKillingWay(new MeleeWeapon(melee.get(randomMeleeName), randomWeaponLevel));
		kw.fightTime();
		
		kw.setKillingWay(null);
		kw.fightTime();

	}
	
	static interface KillZombie
	{
		void kill();
	}
	
	static class RangedWeapon implements KillZombie
	{
		private String weaponName;
		private int weaponLevel;
		private final int DAMAGE = 100;
		
		RangedWeapon(String weaponName, int weaponLevel)
		{
			this.weaponName = weaponName;
			this.weaponLevel = weaponLevel; 		
			
		}
		
		double getDamage(int weaponLevel)
		{
			if (0 < weaponLevel && weaponLevel < 11)
				return DAMAGE * 0.3;
			else if (10 < weaponLevel && weaponLevel < 21)
				return DAMAGE * 0.5;
			else
				return DAMAGE * 0.7;
		}

		@Override
		public void kill() {
			System.out.println("Оружие, которым поразили зомби: " + weaponName);
			System.out.println("Нанесено урона: " + getDamage(weaponLevel));
		}
		
		
		
	}
	
	static class MeleeWeapon implements KillZombie
	{

		private String weaponName;
		private int weaponLevel;
		private final int DAMAGE = 70;
		
		MeleeWeapon(String weaponName, int weaponLevel)
		{
			this.weaponName = weaponName;
			this.weaponLevel = weaponLevel; 		
			
		}
		
		double getDamage(int weaponLevel)
		{
			if (0 < weaponLevel && weaponLevel < 11)
				return DAMAGE * 1.3;
			else if (10 < weaponLevel && weaponLevel < 21)
				return DAMAGE * 1.5;
			else
				return DAMAGE * 1.7;
		}

		@Override
		public void kill() {
			System.out.println("Оружие, которым ударили зомби: " + weaponName);
			System.out.println("Нанесено урона: " + getDamage(weaponLevel));
		}
		
	}
	
	static class KillingWay
	{
		private KillZombie killZombie;
		
		public void setKillingWay(KillZombie killZombie)
		{
			this.killZombie = killZombie;
		}
		
		public void fightTime()
		{
			if (killZombie == null)
				System.out.println("Нет оружия. Ты мёртв");
			else
				killZombie.kill();
			
		}
	}

}
