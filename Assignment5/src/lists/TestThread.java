package lists;

import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Balaji Arun
 */

public class TestThread extends Thread implements ThreadId{
	private static int ID_GEN = 0;
	private int id;
	Set<Integer> set;
	private int  operation;
	private long elapsed;
	private int iter;
	private ThreadLocalRandom threadLocalRandom;

	public TestThread(Set<Integer> set, int operation, int iter) {
		id = ID_GEN++;
		this.set = set;
		this.operation = operation;
		this.iter = iter;
		this.threadLocalRandom = ThreadLocalRandom.current();
	}

	@Override
	public void run() {
		long start = System.currentTimeMillis();
		switch (operation) {
			case 0:
				for(int i = 0; i < iter; i++) {
					int randomInt = threadLocalRandom.nextInt(0, 100);
					set.add(randomInt);
				}
				break;
			case 1:
				for(int i = 0; i < iter; i++) {
					int randomInt = threadLocalRandom.nextInt(0, 100);
					set.remove(randomInt);
				}
				break;
			case 2:
				for(int i = 0; i < iter; i++) {
					int randomInt = threadLocalRandom.nextInt(0, 100);
					set.contains(randomInt);
				}
				break;

			default:
				System.out.println("Wrong operation");
		}
		long end = System.currentTimeMillis();
		elapsed = end - start;
	}

	public int getThreadId(){
		return id;
	}

	public long getElapsedTime() {
		return elapsed;
	}
}
