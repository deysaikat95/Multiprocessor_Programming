package edu.vt.ece.bench;

public class TestThread3 extends Thread implements ThreadId{
	private static int ID_GEN = 0;
	private CriticalSection CS;
	private int id;
	public volatile static boolean running = true;

	public TestThread3(CriticalSection CS) {
		id = ID_GEN++;
		this.CS = CS;
	}
	
	@Override
	public void run() {
		while(running)	
			CS.cs();

		System.out.println("Thread " + id + " ends");
	}
	
	public int getThreadId(){
		return id;
	}
}
