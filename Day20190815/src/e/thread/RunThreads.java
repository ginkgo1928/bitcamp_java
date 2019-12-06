package e.thread;

public class RunThreads {
	public static void main(String[] args) {
		RunThreads threads=new RunThreads();
		//threads.runBasic();
		threads.runBasic2();
	}
	public void runBasic() {
		RunnableSample runnable=new RunnableSample();
		ThreadSample thread=new ThreadSample();
		new Thread(runnable).start(); //Runable실행방법
		thread.start(); //Thread 실행방법
		System.out.println("RunThreads.runBasic()method is ended.");
	}
	public void runBasic2() {
		RunnableSample[] runnable = new RunnableSample[5];
		ThreadSample [] thread = new ThreadSample[5];
		for(int loop=0; loop<5; loop++) {
			runnable[loop]=new RunnableSample();
			thread[loop]=new ThreadSample();
			
			new Thread(runnable[loop]).start();
			thread[loop].start();	
		}
		System.out.println("RunThreads. runBasic2() method is ended");
	}

}
