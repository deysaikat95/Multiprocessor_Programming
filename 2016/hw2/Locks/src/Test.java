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

	private static final int THREAD_COUNT = 2;

	// Thread count for Peterson Tree
	private static final int THREAD_COUNT_PETERSON_TREE = 16;

	private static final String LOCK_ONE = "LockOne";
	private static final String LOCK_TWO = "LockTwo";
	private static final String PETERSON = "Peterson";
	private static final String FILTER = "Filter";

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		String lockClass = (args.length==0 ? PETERSON : args[0]);
		final Counter counter;

		// Test Peterson Tree
		if (lockClass.equals("PetersonTree")) {
			PetersonTree tree = new PetersonTree(THREAD_COUNT_PETERSON_TREE);
			counter = new SharedCounter(0, (Lock)tree);
			for(int t=0; t<THREAD_COUNT_PETERSON_TREE; t++)
				new TestThread(counter).start();

		// Test other locks
		} else {
			counter = new SharedCounter(0, (Lock)Class.forName("edu.vt.ece.locks." + lockClass).newInstance());			
			for(int t=0; t<THREAD_COUNT; t++)
				new TestThread(counter).start();
		}

		
	}
}
