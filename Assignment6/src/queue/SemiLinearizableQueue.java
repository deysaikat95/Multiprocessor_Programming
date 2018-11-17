package queue;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class SemiLinearizableQueue<T>  {
	private AtomicInteger size;
	private AtomicReference<Node> head;
	private AtomicReference<Node> tail;
	private static int n;
	private ThreadLocalRandom threadLocalRandom;

	public SemiLinearizableQueue(int n) {
		Node sentinel = new Node(null);
		this.head = new AtomicReference<Node>(sentinel);
		this.tail = new AtomicReference<Node>(sentinel);
		this.threadLocalRandom = ThreadLocalRandom.current();
		this.n = n;
	}

	private T pick(int index, Node next) throws EmptyException {
		for (int i = 0; i < index; i++)
		{
			if (next.next.get() == null)
				break;
			next = next.next.get();
		}

		if (next.marked.compareAndSet(false, true))
			return next.value;
		else
			return null;
	}

	public void enq(T item) {
		if (item == null) throw new NullPointerException();
		Node node = new Node(item); 
		while (true) {
			Node last = tail.get();
			Node next = last.next.get();
			if (last == tail.get()) {
				if (next == null) {
					if (last.next.compareAndSet(next, node)) {
						tail.compareAndSet(last, node);
						return;
					}
				} else {
					tail.compareAndSet(last, next);
				}
			}
		}
	}

	public T deq() throws EmptyException {	
		int cnt = 0;
		while (true) {
			Node first = head.get();
			Node last = tail.get();
			Node next = first.next.get();
			if (first == head.get()) {
				if (first == last) {
					if (next == null)
						throw new EmptyException();

					tail.compareAndSet(last, next);
				} else {
					if (n > 1) {
						if (cnt < n) {
							int randomIdx = ThreadLocalRandom.current().nextInt(0,n);

							T value = pick(randomIdx, next);
							if (value != null)
								return value;

							if (next != null && next.marked.get() == true) {
								if (next != last && head.compareAndSet(first, next)) {
									first = next;
									next = next.next.get();
								}

								if (next == null) {
									return null;
								}

								if (next.marked.compareAndSet(false, true))
									return next.value;
							}
							cnt++;
						} else {
							T value = next.value;
							if (head.compareAndSet(first, next))
								return value;
						}
					} else { // Regular FIFO queue
						T value = next.value;
						if (head.compareAndSet(first, next))
							return value;
					}
				}
			}
		}
	}

	protected class Node {
		public T value;
		public AtomicReference<Node> next;
		AtomicBoolean marked = new AtomicBoolean();
		public Node(T value) {
			this.value = value;
			this.next  = new AtomicReference<Node>(null);
			marked.set(false);
		}
	}
}
