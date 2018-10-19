package edu.vt.ece.bench;

public class Qnode2 implements Comparable<Qnode2>{
	public volatile int prior;

	public Qnode2(int prior) {
		this.prior = prior;
	}

	public int getPrior(){
		return prior;
	}
	
	public boolean equals(Qnode2 other){
		return this.getPrior() == other.getPrior();
	}

	@Override
	public int compareTo(Qnode2 other) {
		if (other == null){
			return -1;
		}
		if (getPrior() >= other.getPrior()){
			return 1;
		}
		else {
			return -1;
		}
	}

	public String toString(){
		return "Priority is " + getPrior();
	}
}
