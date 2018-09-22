import edu.vt.ece.bench.Counter;
import edu.vt.ece.bench.SharedCounter;
import edu.vt.ece.bench.TestThread;
import edu.vt.ece.bench.TestThread2;
import edu.vt.ece.locks.*;

/**
 *
 * @author Balaji Arun
 * @author Mincheol Sung
 */
public class Test2 {

	private static int THREAD_COUNT = 2;
	private static final int TOTAL_ITERS = 64000;
	private static final int ITERS = TOTAL_ITERS/THREAD_COUNT;

	private static final String LOCK_ONE = "LockOne";
	private static final String LOCK_TWO = "LockTwo";
	private static final String PETERSON = "Peterson";
	private static final String FILTER = "Filter";
	private static final String BAKERY = "Bakery";
	private static final String PTREE = "PetersonTree";

	public static void main(String[] args) 
	{
		try {
			Lock lock;
			String lockClass = (args.length==0 ? BAKERY : args[0]);
			if (args.length > 1) {
				THREAD_COUNT = Integer.parseInt(args[1]);
				if (THREAD_COUNT <= 0)
				{
					System.out.println("THREAD_COUNT is set to 2\n");
					THREAD_COUNT = 2;
				}
			}

			switch (lockClass) {
			case LOCK_ONE:
				lock = new LockOne();
				THREAD_COUNT = 2;
				break;

			case LOCK_TWO:
				lock = new LockTwo();
				THREAD_COUNT = 2;
				break;

			case PETERSON:
				lock = new Peterson();
				THREAD_COUNT = 2;
				break;

			case FILTER:
				lock = new Filter(THREAD_COUNT);
				break;

			case BAKERY:
				lock = new Bakery(THREAD_COUNT);
				break;

			case PTREE:
				lock = new PetersonTree(THREAD_COUNT);
				break;

			default:
				System.out.println(lockClass + "is not supported, set to Bakery.");
				lock = new Bakery(THREAD_COUNT);
			}

			System.out.println(THREAD_COUNT + " threads are running with " + lockClass + " lock.\n");
	
			final Counter counter = new SharedCounter(0, lock);

			final TestThread2[] threads = new TestThread2[THREAD_COUNT];

			for(int t=0; t<THREAD_COUNT; t++) {
				threads[t] = new TestThread2(counter, ITERS);
			}

			for(int t=0; t<THREAD_COUNT; t++) {
				threads[t].start();
			}

			long totalTime = 0;
			for(int t=0; t<THREAD_COUNT; t++) {
				threads[t].join();
				totalTime += threads[t].getElapsedTime();
			}

			System.out.println("Average time per thread is " + totalTime/THREAD_COUNT + "ms");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
