package com.ziemo.algo.linkedLista;

public class Node <T>{

	T element;
	Node nextNode;

	public Node(T element) {
		this.element = element;
	}

	public T getElement() {
		return element;
	}

	public Node getNextNode() {
		return nextNode;
	}

	public void setNextNode(Node nextNode) {
		this.nextNode = nextNode;
	}
}
