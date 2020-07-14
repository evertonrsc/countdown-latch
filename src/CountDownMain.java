import java.util.concurrent.CountDownLatch;

public class CountDownMain {
	private static final int NUM_CALLS = 3;

	public static void main(String[] args) {
		CountDownLatch counter = new CountDownLatch(NUM_CALLS);
		
		ThreadAction thread = new ThreadAction("T", counter);
		CountDown countDown = new CountDown(counter, NUM_CALLS);
		
		thread.start();
		countDown.start();
		
		try {
			thread.join();
			countDown.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
