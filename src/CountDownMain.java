import java.util.concurrent.CountDownLatch;

/**
 * Demonstration of the synchronization of threads at a countdown latch
 * @see java.util.concurrent.CountDownLatch
 *
 * @author <a href="mailto:everton.cavalcante@ufrn.br">Everton Cavalcante</a>
 */
public class CountDownMain {
	/** Number of calls to wait */
	private static final int NUM_CALLS = 3;

	/**
	 * Main method
	 * @param args Command line arguments
	 */
	public static void main(String[] args) {
		CountDownLatch counter = new CountDownLatch(NUM_CALLS);
		
		ThreadAction threadA = new ThreadAction("A", counter);
		ThreadAction threadB = new ThreadAction("B", counter);
		CountDown countDown = new CountDown(counter, NUM_CALLS);
		
		threadA.start();
		threadB.start();
		countDown.start();
		
		try {
			threadA.join();
			threadB.join();
			countDown.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
