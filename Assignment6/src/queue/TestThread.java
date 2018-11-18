package queue;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

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
	private int enq_count = 0;
	private int deq_count = 0;
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
					enq_count++;
					if (System.currentTimeMillis() - start >= duration * 1000)
						break;

				}
				break;

			case 1:
				start = System.currentTimeMillis();
				while(true)
				{
					Integer item = LQueue.poll();
					if (item != null)
						deq_count++;

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
					enq_count++;
					if (System.currentTimeMillis() - start >= duration * 1000)
						break;

				}
				break;

			case 1:
				start = System.currentTimeMillis();
				while(true)
				{
					Integer item = null;
					try {
						item = SLQueue.deq();
					} catch (EmptyException ex)
					{}
					if (item != null)
						deq_count++;

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

	public int getCount() {
		return enq_count + deq_count;
	}
	
	public int getEnqCount() {
		return enq_count;
	}
	
	public int getDeqCount() {
		return deq_count;
	}

	public int getSizeLQueue() {
		return LQueue.size();
	}
	public int getSizeSLQueue() {
		return SLQueue.size();
	}
}
