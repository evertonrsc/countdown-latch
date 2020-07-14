import java.util.concurrent.CountDownLatch;

public class ThreadAction extends Thread {
	private CountDownLatch counter;
	
	public ThreadAction(String name, CountDownLatch counter) {
		super(name);
		this.counter = counter;
	}
	
	@Override
	public void run() {
		System.out.println("Waiting...");
		try {
			counter.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Running");
	}

}
