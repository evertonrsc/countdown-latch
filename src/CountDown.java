import java.util.concurrent.CountDownLatch;

/**
 * Implementation of a countdown manager for the calls to be made
 * @author <a href="mailto:everton.cavalcante@ufrn.br">Everton Cavalcante</a>
 */
public class CountDown extends Thread {
	/** Reference to the synchronization counter */
	private CountDownLatch counter;

	/** Number of calls to be managed */
	private int calls;

	/**
	 * Parameterized constructor
	 * @param counter Reference to the synchronization counter
	 * @param calls Number of calls
	 */
	public CountDown(CountDownLatch counter, int calls) {
		this.counter = counter;
		this.calls = calls;
	}
	
	@Override
	/** Action to decrement the counter upon successive calls */
	public void run() {
		try {
			for (int i = 0; i < calls; i++) {
				int duration = (int) (Math.random() * 5) + 1;
				Thread.sleep(duration * 1000);
				System.out.printf("- Call %d (duration: %d seconds)\n",
					i+1, duration);
				counter.countDown();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
