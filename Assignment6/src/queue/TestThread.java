package queue;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 *
 * @author Mincheol Sung
 */

public class TestThread extends Thread implements ThreadId{
	private static int ID_GEN = 0;
	private int id;
	private String queue;
	private int  operation;
	private long  duration;
	private long count = 0;
	private ThreadLocalRandom threadLocalRandom;
	static ConcurrentLinkedQueue<Integer> LQueue;// = new ConcurrentLinkedQueue<Integer>();
	static SemiLinearizableQueue<Integer> SLQueue;// = new SemiLinearizableQueue<Integer>();
	private int n;

	public TestThread(String queue, int duration,  int operation, int n) {
		id = ID_GEN++;
		this.queue = queue;
		this.duration = duration;
		this.operation = operation;
		this.threadLocalRandom = ThreadLocalRandom.current();
		this.n = n;
		this.LQueue = new ConcurrentLinkedQueue<Integer>();
		this.SLQueue = new SemiLinearizableQueue<Integer>(n);
	}
	
	long start = 0;
	@Override
	public void run() {
		if (queue.equals("LQueue")) {
			switch (operation) {
			case 0:
				start = System.currentTimeMillis();
				while (true)
				{

					int randomInt = threadLocalRandom.nextInt(0, Integer.MAX_VALUE);
					LQueue.add(randomInt%100);
					count++;
					if (System.currentTimeMillis() - start >= duration * 1000)
						break;

				}
				break;

			case 1:
				start = System.currentTimeMillis();
				while(true)
				{
					LQueue.poll();
					count++;
					if (System.currentTimeMillis() - start >= duration * 1000)
						break;
				}
				break;

			default:
				System.out.println("Wrong operation");
			}
		}

		else if (queue.equals("SLQueue")) {
			switch (operation) {
			case 0:
				start = System.currentTimeMillis();
				while (true)
				{
					int randomInt = threadLocalRandom.nextInt(0, Integer.MAX_VALUE);
					SLQueue.enq(randomInt%100);
					count++;
					if (System.currentTimeMillis() - start >= duration * 1000)
						break;

				}
				break;

			case 1:
				start = System.currentTimeMillis();
				while(true)
				{
					try {
					int item = SLQueue.deq();
					} catch (EmptyException ex)
					{}
					count++;
					if (System.currentTimeMillis() - start >= duration * 1000)
						break;
				}
				break;

			default:
				System.out.println("Wrong operation");

			}
		}

		else
			System.out.println("Wrong queue");

	}

	public int getThreadId(){
		return id;
	}

	public long getCount() {
		return count;
	}
}
