package com.ziemo.algo.linkedLista;

public class NodePair <T>{

	Node<T> currentNode;
	Node<T> previousNode;

	public NodePair(Node<T> currentNode, Node<T> previousNode) {
		this.currentNode = currentNode;
		this.previousNode = previousNode;
	}
}
