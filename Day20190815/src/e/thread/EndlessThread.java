package e.thread;

public class EndlessThread extends Thread {
	public static void main(String[] args) {
		EndlessThread end = new EndlessThread();
		end.endless();
		end.checkThreadProperty();

	}

	public void run() {
		while (true) {
			try {
				System.out.println(System.currentTimeMillis());
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void endless() {
		EndlessThread thread = new EndlessThread();
		thread.start();
	}
	public void checkThreadProperty() {
		ThreadSample thread1=new ThreadSample();
		ThreadSample thread2=new ThreadSample();
		ThreadSample demonThread=new ThreadSample();
		
		System.out.println("thread1 id="+thread1.getId());
		System.out.println("thread2 id="+thread2.getId());
		
		System.out.println("thread1 name="+thread1.getName());
		System.out.println("thread1 name="+thread2.getName());
		
		System.out.println("thread1 priorty="+thread1.getPriority());
		
		demonThread.setDaemon(true);
		System.out.println("thread1 isDaemon"+thread1.isDaemon());
		System.out.println("damonThread isDaemon"+demonThread.isDaemon());
		
	}
}
