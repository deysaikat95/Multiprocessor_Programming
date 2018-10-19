package Q3;

import spin.*;
import edu.vt.ece.locks.*;
import edu.vt.ece.bench.*;

public class Test2 {
	private static final String Lock = "TryPriorityCLHLock";
	private static final int THREAD_COUNT = 16;
	private static final int TOTAL_ITERS = 2520;
	private static int ITERS;
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, InterruptedException {
		ITERS = TOTAL_ITERS/THREAD_COUNT;
		String lockClass = Lock;
		final CriticalSection CS = new CriticalSection((Lock)Class.forName("spin." + lockClass).newInstance());

		final TestThread4[] threads = new TestThread4[THREAD_COUNT];
		for (int t = 0; t < THREAD_COUNT; t++) {
			threads[t] = new TestThread4(CS, ITERS);
		}

		for (int t = 0; t < THREAD_COUNT; t++) {
			threads[t].start();
		}

		for (int t = 0; t < THREAD_COUNT; t++) {
			threads[t].join();
		}

		System.out.println("Lock was abandoned " + TryPriorityCLHLock.trylock + " times as the timeout occured");
		System.out.println("Mutual Exclution is mantained. Counter value is " + CS.count);
	}
}
