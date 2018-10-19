package Q3;

import edu.vt.ece.locks.*;
import edu.vt.ece.bench.*;
import spin.*;

public class Test {
	private static final int THREAD_COUNT = 16;
	private static final int TOTAL_ITERS = 3000;
	private static int ITERS;
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, InterruptedException {
		ITERS = TOTAL_ITERS/THREAD_COUNT;
		String lockClass = "PriorityCLHLock";
		final CriticalSection CS = new CriticalSection((Lock)Class.forName("spin." + lockClass).newInstance());

		final TestThread4[] threads = new TestThread4[THREAD_COUNT];

		for(int t=0; t < THREAD_COUNT; t++) {
			threads[t] = new TestThread4(CS, ITERS);
		}

		for(int t=0; t < THREAD_COUNT; t++) {
			threads[t].start();
		}

		long totalTime = 0;
		long multipliedTotalTime = 0;
		for(int t=0; t<THREAD_COUNT; t++) {
			threads[t].join();
		}
		for(int t=0; t<THREAD_COUNT; t++) {
			totalTime += threads[t].getElapsedTime();
			multipliedTotalTime += threads[t].getMultipliedElapsedTime();
		}

		System.out.println("Average waiting time per thread is " + totalTime/THREAD_COUNT + "ms");
		System.out.println("Average multiplied waiting time per thread is " + multipliedTotalTime/THREAD_COUNT + "ms");

	}
}
