package com.ziemo.algo.doublyLinkedLista;

public class DNode<E> {

	E element;
	DNode<E> previousNode;
	DNode<E> nextNode;

	public DNode(E element) {
		this.element = element;
	}
}
