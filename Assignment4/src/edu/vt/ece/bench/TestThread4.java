package edu.vt.ece.bench;

import java.util.concurrent.ThreadLocalRandom;

public class TestThread4 extends Thread implements ThreadId{
	private static int ID_GEN = 0;
	private CriticalSection CS;
	private int id;
	private long elapsed;
	private long multipliedElapsed;
	private int iter;

	public TestThread4(CriticalSection CS, int iter) {
		id = ID_GEN++;
		this.CS = CS;
		this.iter = iter;
	}
	
	@Override
	public void run() {
		Thread.currentThread().setPriority(ThreadLocalRandom.current().nextInt(1, 5 + 1));
		long start = System.currentTimeMillis();
		for (int i = 0; i < iter; i++)
			CS.cs();
		long end = System.currentTimeMillis();
		elapsed = end - start;
		multipliedElapsed = elapsed * Thread.currentThread().getPriority();
		System.out.println("Thread " + id + "(prior: " + Thread.currentThread().getPriority() + ") waiting time: "+ elapsed + "ms" + ", multiplied wait time: " + multipliedElapsed + "ms");
	}
	
	public int getThreadId(){
		return id;
	}

	public long getElapsedTime() {
		return elapsed;
	}
	public long getMultipliedElapsedTime() {
		return multipliedElapsed;
	}
}
