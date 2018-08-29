import edu.vt.ece.bench.Counter;
import edu.vt.ece.bench.SharedCounter;
import edu.vt.ece.bench.TestThread;
import edu.vt.ece.locks.*;

public class TestPetersonTree {

	public static int THREAD_COUNT = 16;

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {

		PetersonTree tree = new PetersonTree(THREAD_COUNT);
		final Counter counter = new SharedCounter(0, (Lock)tree);
		for(int t=0; t<THREAD_COUNT; t++)
			new TestThread(counter).start();

	}
}