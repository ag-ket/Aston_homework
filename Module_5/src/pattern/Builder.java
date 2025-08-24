package pattern;

public class Builder {

	public static void main(String[] args) {
		ZombieShelter shelter = new ZombieShelter();
		CivilEngineer engineer = new CivilEngineer(shelter);
		engineer.buildIt();
		
		System.out.println(shelter.makeShelter());

	}
	
	static class BaseShelter
	{
		private String wallMaterial;
		private String defence;
		private int enemyNumber;
		
		BaseShelter(String wallMaterial, String defence, int enemyNumber)
		{
			this.wallMaterial = wallMaterial;
			this.defence = defence;
			this.enemyNumber = enemyNumber;
		}
		
		public String toString()
		{
			return "Материал стен: " + wallMaterial + ".\nЗащита: " + defence + ".\nКоличество зомби, которое способно отразить убежище: " + enemyNumber;
			
		}
		
		
	}
	
	static interface ShelterBuilder
	{
		void setWallMaterial(String wallMaterial);
		void setDefence(String defence);
		void setEnemyNumber(int enemyNumber);
		BaseShelter makeShelter();
	}
	
	static class ZombieShelter implements ShelterBuilder
	{
		private String wallMaterial;
		private String defence;
		private int enemyNumber;

		@Override
		public void setWallMaterial(String wallMaterial) {
			this.wallMaterial = wallMaterial;
			
			
		}

		@Override
		public void setDefence(String defence) {
			this.defence = defence;
			
			
		}

		@Override
		public void setEnemyNumber(int enemyNumber) {
			this.enemyNumber = enemyNumber;
			
		}

		@Override
		public BaseShelter makeShelter() {
			
			return new BaseShelter(wallMaterial, defence, enemyNumber);
		}
		
	}
	
	static class CivilEngineer
	{
		private ShelterBuilder builder;
		
		CivilEngineer (ShelterBuilder builder)
		{
			this.builder = builder;
		}
		
		void buildIt()
		{
			builder.setWallMaterial("Укреплённый бетон");
			builder.setDefence("Колючая проволока и сигнализация");
			builder.setEnemyNumber(150);
		}
	}

}
