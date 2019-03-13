package com.ziemo.algo.tree;

public class TNode {

	Integer data;
	TNode left;
	TNode right;

	//	TNode[] children;


	public TNode(Integer data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return data.toString();
	}

	public void remove(TNode child) {
		if (child == left) {
			left = null;
		} else if (child == right) {
			right = null;
		}

	}
}
