package edu.vt.ece.locks;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class PetersonNode {
	public AtomicBoolean flags[];
	public AtomicInteger victim = new AtomicInteger();

	PetersonNode left;
	PetersonNode right;
	PetersonNode parent;

	public PetersonNode(PetersonNode node, int num) {
	    flags = new AtomicBoolean[num];

	    for (int i = 0; i < num; i++)
	    	flags[i] = new AtomicBoolean();
		
		parent = node;
	}

	public void lock(int i) {
		flags[i].set(true);
		victim.set(i);
		while (otherInterested(i) && (victim.get() == i)) {};
	}

	public void unlock(int i) {
		flags[i].set(false);
	}

	public boolean otherInterested(int i) {
		for (int k = 0; k < flags.length; k++) {
			if (flags[k].get() && (k != i))
				return true;
		}

		return false;
	}
}