package threads;

public class Loop {
	
	static int trigger = 1;
	static Object lock = new Object();
	
	static void printNumber(int threadNumber, int triggerCheck)
	{
		while(true)
		{
			synchronized(lock)
			{
				if (trigger == triggerCheck)
				{
					try {
						lock.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println(threadNumber);
				trigger = triggerCheck;
				lock.notifyAll();
			}
		}
	}

	public static void main(String[] args) {
		Thread thread1 = new Thread(()->printNumber(1,2));
		Thread thread2 = new Thread(()->printNumber(2,1));
		thread1.setPriority(Thread.MAX_PRIORITY);
		
		thread1.start();
		thread2.start();

	}

}
