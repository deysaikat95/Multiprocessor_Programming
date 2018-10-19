package Q1;

public class Test {
	public static int THREAD_COUNT = 16;
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, InterruptedException {

		final TestThread[] threads = new TestThread[THREAD_COUNT];
		for (int t = 0; t < THREAD_COUNT; t++)
			threads[t] = new TestThread(t);

		for (int t = 0; t < THREAD_COUNT; t++)
			threads[t].start();

		long totalTime = 0;
		for (int t = 0; t < THREAD_COUNT; t++) {
			threads[t].join();
			totalTime += threads[t].getElapsedTime();
		}

		System.out.println("Average time per thread is " + totalTime/THREAD_COUNT + "ms");
	}

} 
