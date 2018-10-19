package spin;

import edu.vt.ece.bench.*;
import edu.vt.ece.locks.*;

import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class PriorityCLHLock implements Lock {
	public AtomicBoolean locked;
	PriorityBlockingQueue<Qnode2> priorityQueue = new PriorityBlockingQueue<Qnode2>();
	private ThreadLocal<Qnode2> myNode;

	public PriorityCLHLock() {
		locked = new AtomicBoolean();
		this.myNode = new ThreadLocal<Qnode2>() {
			protected Qnode2 initialValue() {
				return new Qnode2(5);
			}
		};
	}

	public void lock() {
		Qnode2 qnode = this.myNode.get();
		qnode.prior = Thread.currentThread().getPriority();
		priorityQueue.add(qnode);

		while (true) {
			while (priorityQueue.peek() != qnode);
			while (!locked.compareAndSet(false, true));
			if (priorityQueue.peek() == qnode)
				break;
			locked.set(false);
		}
	}

	public void unlock() {
		Qnode2 qnode = this.myNode.get();
		priorityQueue.remove(qnode);
		locked.set(false);
	}
}
