package Q1;
import edu.vt.ece.bench.ThreadId;

public class TestThread extends Thread implements ThreadId {
	private int id;
	private long elapsed;
	private static int THREAD_COUNT = Test.THREAD_COUNT;
	private static volatile int[] b = new int[THREAD_COUNT];

	public TestThread (int id) {
		this.id = id;
	}

	private void foo() {
		System.out.println(id + " enters foo()");
	}

	private void bar() {
		System.out.println(id + " enters bar()");
	}

	@Override
	public void run() {
		foo();
		long start = System.currentTimeMillis();

		if (id == 0) {
			b[id] = 1;
		} else {
			while (b[id - 1] == 0);
			b[id] = 1;
		}

		if ((id == THREAD_COUNT - 1) && (b[THREAD_COUNT - 1] == 1))
			b[THREAD_COUNT - 1] = 2;
		
		while (b[THREAD_COUNT - 1] != 2);

		long end = System.currentTimeMillis();
		bar();
		elapsed = end - start;
	}

	public int getThreadId() {
		return id;
	}

	public long getElapsedTime() {
		return elapsed;
	}
}

