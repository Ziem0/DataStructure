package com.ziemo.algo.doublyLinkedLista;

public class DoublyLinkedList<E> {

	DNode<E> first;
	DNode<E> last;

	public boolean isEmpty() {
		return first == null;
	}

	public int getSize() {
		DNode<E> current = first;
		int size = 0;
		while (current != null) {
			size++;
			current = current.nextNode;
		}
		return size;
	}

	public E getElement(int index) {
		
	}

	public boolean add(int index, E element) {

	}

	public void remove(int index) {

	}

	public void iterate() {
		DNode<E> current = first;
		while (current != null) {
			System.out.println(current.element);
			current = current.nextNode;
		}
	}




	public static void main(String[] args) {

	}
}
