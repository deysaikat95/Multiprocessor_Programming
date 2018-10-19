package Q2;

import edu.vt.ece.bench.*;
import edu.vt.ece.locks.*;
import spin.*;
/**
 * 
 * @author Mohamed M. Saad
 */
public class Test {
	private static final int THREAD_COUNT = 16;
	private static final String TASLock = "TASLock";
	private static final String TTASLock = "TTASLock";
	private static final String CLHLock = "CLHLock";
	private static final String MCSLock = "MCSLock";

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		String lockClass = (args.length == 0 ? TASLock : args[0]);
		final CriticalSection CS = new CriticalSection((Lock)Class.forName("spin." + lockClass).newInstance());

		final TestThread3[] threads = new TestThread3[THREAD_COUNT];
		for (int t = 0; t < THREAD_COUNT; t++)
			threads[t] = new TestThread3(CS);
		
		for(int t=0; t < THREAD_COUNT; t++)
			threads[t].start();

		long start = System.currentTimeMillis();
		while (System.currentTimeMillis() < start + 2000);

		TestThread3.running = false;

		System.out.println("Throughput: " + CriticalSection.count);
	}
}

