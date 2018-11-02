package lists;

import java.util.*;

public class Main {
	static int ADD_THREAD_COUNT = 5;
	static int REMOVE_THREAD_COUNT = 5;
	static int CONTAINS_THREAD_COUNT = 15;
	static int TOTAL_ITERS;
	static int ITER = 1000;

	volatile static Set<Integer> myList;
	//static Set<Integer> myFineList;
	//static Set<Integer> myLazyList;
	//static Set<Integer> myOptimisticList;
	//static Set<Integer> myLockFreeList;

	public static void main(String[] args) throws Exception {
		
		if (args.length != 5)
		{
			System.out.println("java Main CoarseList 5 5 15 10000");
			return;
		}

		String listType = args[0];
		ADD_THREAD_COUNT = Integer.parseInt(args[1]);
		REMOVE_THREAD_COUNT = Integer.parseInt(args[2]);
		CONTAINS_THREAD_COUNT = Integer.parseInt(args[3]);
		ITER = Integer.parseInt(args[4]);

		if (listType.equals("CoarseList"))
			myList = new CoarseList<Integer>();

		else if (listType.equals("FineList"))
			myList = new FineList<Integer>();

		else if (listType.equals("LazyList"))
			myList = new LazyList<Integer>();

		else if (listType.equals("OptimisticList"))
			myList = new OptimisticList<Integer>();

		else if (listType.equals("LockFreeList"))
			myList = new LockFreeList<Integer>();

		else {
			System.out.println("incorrect list type");
			return;
		}

		int TOTAL_THREAD_COUNT = ADD_THREAD_COUNT + REMOVE_THREAD_COUNT
							  + CONTAINS_THREAD_COUNT;
		TOTAL_ITERS = ITER * TOTAL_THREAD_COUNT;
		
		final TestThread[] threads = new TestThread[TOTAL_THREAD_COUNT];

		for (int i = 0; i < ADD_THREAD_COUNT; i++) {
			threads[i] = new TestThread(myList, 0, ITER);
		}
		for (int j = 0; j < REMOVE_THREAD_COUNT; j++) {
			threads[j + ADD_THREAD_COUNT] = new TestThread(myList, 1, ITER);
		}
		for (int k = 0; k < CONTAINS_THREAD_COUNT; k++) {
			threads[k + ADD_THREAD_COUNT + REMOVE_THREAD_COUNT] = new TestThread(myList, 2, ITER);
		}
		
		for (int t = 0; t < TOTAL_THREAD_COUNT; t++) {
			threads[t].start();
		}

		long totalTime = 0;
		for (int t = 0; t < TOTAL_THREAD_COUNT; t++) {
			threads[t].join();
			totalTime += threads[t].getElapsedTime();
		}
		
		System.out.print(TOTAL_THREAD_COUNT+ " ");
		System.out.println(TOTAL_ITERS/totalTime);
	}
}
