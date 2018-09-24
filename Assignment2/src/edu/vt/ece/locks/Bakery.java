package edu.vt.ece.locks;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import edu.vt.ece.bench.ThreadId;

public class Bakery implements Lock
{
	private AtomicBoolean flag[];
	private AtomicInteger label[];

	public Bakery()
	{
		this(2);
	}

	public Bakery(int n)
	{
		this.flag = new AtomicBoolean[n];
		this.label = new AtomicInteger[n];
		for (int i = 0; i < n; i++)
		{
			flag[i] = new AtomicBoolean();
			label[i] = new AtomicInteger();
		}
	}

	private boolean lexicographic(int a, int i, int b, int j)
	{
		if (a > b)
			return true;

		else if (a == b && i > j)
			return true;

		else
			return false;
	}

	@Override
	public void lock() {
		int me = ((ThreadId)Thread.currentThread()).getThreadId();
		int maxLabel = 0;
		int meLabel = 0;
		int kLabel = 0;
		boolean found = false;
		for (int i = 0; i < label.length; i++)
		{
			maxLabel = Math.max(maxLabel, label[i].get());
		}
		flag[me].set(true);
		label[me].set(maxLabel + 1);
		meLabel = maxLabel + 1;
		do {
			for (int k = 0; k < label.length; k++)
			{
				if (k!=me)
				{
					kLabel = label[k].get();
					if (found = (flag[k].get() && (meLabel > kLabel || (meLabel == kLabel && me > k))))
						break;
				}
			}
		} while(found);
	}

	@Override
	public void unlock() {
		int i = ((ThreadId)Thread.currentThread()).getThreadId();
		flag[i].set(false);
	}

}
