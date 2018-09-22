import edu.vt.ece.bench.Counter;
import edu.vt.ece.bench.SharedCounter;
import edu.vt.ece.bench.TestThread;
import edu.vt.ece.locks.*;

/**
 *
 * @author Mohamed M. Saad
 * @author Mincheol Sung
 */
public class Test {

	private static int THREAD_COUNT = 2;

	private static final String LOCK_ONE = "LockOne";
	private static final String LOCK_TWO = "LockTwo";
	private static final String PETERSON = "Peterson";
	private static final String FILTER = "Filter";
	private static final String BAKERY = "Bakery";
	private static final String PTREE = "PetersonTree";

	public static void main(String[] args) //throws InstantiationException, IllegalAccessException, ClassNotFoundException {
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
				System.out.println(lockClass + "is not supported, set to Bakery.\n");
				lock = new Bakery(THREAD_COUNT);
			}

			Counter counter = new SharedCounter(0, lock);

			System.out.println(THREAD_COUNT + " threads are running with " + lockClass + " lock.\n");
			for(int t=0; t<THREAD_COUNT; t++)
				new TestThread(counter).start();

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
