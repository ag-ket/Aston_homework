package threads;

public class DeadLock {
	
	static class Prey
	{
		
	}

	public static void main(String[] args) {
		
		Prey mouse = new Prey();
		Prey bird = new Prey();
		Prey fish = new Prey();
		
		Thread blackCat = new Thread(()->{
			synchronized (mouse)
			{
				System.out.println(Thread.currentThread().getName() + " съел мышь");
			
				synchronized (bird)
				{
					System.out.println(Thread.currentThread().getName() + " съел птицу");
				}
				synchronized (fish)
				{
					System.out.println(Thread.currentThread().getName() + " съел рыбу");
				}
			}
			
		}, "Барсик");
		
		Thread whiteCat = new Thread(()->{
			synchronized (bird)
			{
				System.out.println(Thread.currentThread().getName() + " съел птицу");
			
				synchronized (mouse)
				{
					System.out.println(Thread.currentThread().getName() + " съел мышь");
				}
				synchronized (fish)
				{
					System.out.println(Thread.currentThread().getName() + " съел рыбу");
				}
			}
			
		}, "Беляш");
		
		Thread tabbyCat = new Thread(()->{
			synchronized (fish)
			{
				System.out.println(Thread.currentThread().getName() + " съел рыбу");
			
				synchronized (bird)
				{
					System.out.println(Thread.currentThread().getName() + " съел птицу");
				}
				synchronized (mouse)
				{
					System.out.println(Thread.currentThread().getName() + " съел мышь");
				}
			}
			
		}, "Мурзик");
		
		blackCat.start();
		whiteCat.start();
		tabbyCat.start();
		

	}

}
