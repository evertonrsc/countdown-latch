import java.util.concurrent.CountDownLatch;

public class CountDown extends Thread {
	private CountDownLatch counter;
	private int calls;
	
	public CountDown(CountDownLatch counter, int calls) {
		this.counter = counter;
		this.calls = calls;
	}
	
	@Override
	public void run() {
		try {
			for (int i = 0; i < calls; i++) {
				int duration = (int) (Math.random() * 5) + 1;
				Thread.sleep(duration * 1000);
				System.out.printf("Call %d (duration %d seconds)\n", 
					i+1, duration);
				counter.countDown();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
