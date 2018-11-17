/*
 * BoundedQueueTest.java
 * JUnit based test
 *
 * Created on December 27, 2005, 11:15 PM
 */

package queue;

import junit.framework.*;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author Maurice Herlihy
 */
public class QueueTest extends TestCase {
	private static int THREADS = 0;
	private static int duration = 0;
	private static int n = 1;
	
	public static void main(String[] args) throws Exception {
		if (args.length != 3 && args.length != 4)
		{
			System.out.println("java QueueTest <qname> <threads> <duration> [<n>]");
			return;
		}
		THREADS = Integer.parseInt(args[1]);
		duration = Integer.parseInt(args[2]);
		if (args.length == 4)
			n = Integer.parseInt(args[3]);
		else
			n = 5;

		int ENQ_THREADS = THREADS/2;
		int DEQ_THREADS = THREADS - ENQ_THREADS;

		final TestThread[] threads = new TestThread[THREADS];

		for (int t = 0; t < ENQ_THREADS; t++) {
			threads[t] = new TestThread(args[0], duration, 0, n);
		}

		for (int t = 0; t < DEQ_THREADS; t++) {
			threads[ENQ_THREADS + t] = new TestThread(args[0], duration, 1, n);
		}

		for (int t = 0; t < THREADS; t++) {
			threads[t].start();
		}
		
		long totalCount = 0;
		for (int t = 0; t < THREADS; t++) {
			threads[t].join();
			totalCount += threads[t].getCount();
		}
		System.out.println(totalCount/duration);
	}
}
