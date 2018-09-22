package edu.vt.ece.locks;
import edu.vt.ece.bench.ThreadId;

import java.util.*;

public class PetersonTree implements Lock{
	int num;
	PetersonNode root;
	ArrayList<PetersonNode> leaves;
	
	public PetersonTree() {
		this(2);
	}

	public PetersonTree(int num) {
		this.num = num;
		root = new PetersonNode(null,num);

		ArrayList<PetersonNode> temp = new ArrayList<>();
		temp.add(root);

		leaves = buildTree(temp);
	}

	@Override
	public void lock() {
		int i = ((ThreadId)Thread.currentThread()).getThreadId();
		PetersonNode node = getNode(i);
		while (node != null) {
			node.lock(i);
			node = node.parent;
		}
	}

	@Override
	public void unlock() {
		int i = ((ThreadId)Thread.currentThread()).getThreadId();
		PetersonNode node = getNode(i);
		while (node != null) {
			node.unlock(i);
			node = node.parent;
		}
	}

	public PetersonNode getNode(int i) {
		return leaves.get(i/2);
	}

	public ArrayList<PetersonNode> buildTree(ArrayList<PetersonNode> nodes) {
		if (nodes.size() == num / 2) {
			return nodes;
		}

		ArrayList<PetersonNode> result = new ArrayList<>();
		ArrayList<PetersonNode> temp = new ArrayList<PetersonNode>(nodes);
		Iterator<PetersonNode> iter = temp.iterator();
		PetersonNode node;

		while (iter.hasNext()) {
			node = iter.next();
			node.left = new PetersonNode(node,num);
			node.right = new PetersonNode(node,num);
			result.add(node.left);
			result.add(node.right);
		}

		return buildTree(result);
	}
}
