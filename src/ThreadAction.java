import java.util.concurrent.CountDownLatch;

/**
 * Action to be performed by a thread to be synchronized at a countdown latch
 * @author <a href="mailto:everton.cavalcante@ufrn.br">Everton Cavalcante</a>
 */
public class ThreadAction extends Thread {
	/** Reference to the synchronization counter */
	private CountDownLatch counter;

	/**
	 * Parameterized constructor
	 * @param name Name to be assigned to the thread
	 * @param counter Reference to the synchronization counter
	 */
	public ThreadAction(String name, CountDownLatch counter) {
		super(name);
		this.counter = counter;
	}

	/** Thread's action */
	@Override
	public void run() {
		System.out.println("Thread " +
				Thread.currentThread().getName() + " is waiting...");
		try {
			counter.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Thread " +
				Thread.currentThread().getName() + " is running");
	}
}
