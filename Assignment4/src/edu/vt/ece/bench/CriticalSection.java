package edu.vt.ece.bench;

import edu.vt.ece.locks.*;

public class CriticalSection {
	private Lock lock;
	public static int count = 0;

	public CriticalSection(Lock lock) {
		this.lock = lock;
	}

	public void cs() {
		lock.lock();
		count = count + 1;
		lock.unlock();
	}
}
