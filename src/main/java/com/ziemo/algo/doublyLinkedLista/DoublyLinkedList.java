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
		if (isEmpty() || index < 0) {
			throw new IndexOutOfBoundsException("Index " + index);
		}

		DNode<E> current = first;

		while (index > 0) {
			if (current == null) {
				throw new IndexOutOfBoundsException("Idex " + index);
			}
			current = current.nextNode;
			index--;
		}
		return current.element;
	}

	public boolean add(int index, E element) {
		if (isEmpty() && index == 0) {
			first = new DNode<>(element);
			last = first;
			return true;
		}

		//adding at the end of the list
		if (index == getSize()) {
			DNode<E> newNode = new DNode<>(element);
			last.nextNode = newNode;
			newNode.previousNode = last;
			last = newNode;
			return true;
		}

		DNode<E> newNode = new DNode<>(element);
		DNode<E> current = first;
		DNode<E> previous;
		DNode<E> next;
		int counter = index;
		while (counter > 0) {
			current = current.nextNode;
			counter--;
		}

		//adding at the beginning of the list
		if (index == 0) {
			newNode.nextNode = first;
			first.previousNode = newNode;
			first = newNode;
			return true;
		}

		previous = current.previousNode;
		next = current;

		newNode.nextNode = next;
		newNode.previousNode = previous;
		previous.nextNode = newNode;
		next.previousNode = newNode;

		return true;
	}

	public boolean remove(int index) {

		if (index == 0) {
			first = first.nextNode;
			first.previousNode = null;
			return true;
		}

		DNode<E> current = first;
		while (index > 0) {
			current = current.nextNode;
			index--;
		}

		if (current.nextNode == null) {
			last = current.previousNode;
			last.nextNode = null;
			return true;
		}

		DNode<E> previous = current.previousNode;
		DNode<E> next = current.nextNode;
		current.previousNode = null;
		current.nextNode = null;
		previous.nextNode = next;
		next.previousNode = previous;

		return true;
	}

	public void iterate() {
		DNode<E> current = first;
		while (current != null) {
			System.out.println(current.element);
			current = current.nextNode;
		}
		System.out.println();
	}




	public static void main(String[] args) {

		DoublyLinkedList<String> list = new DoublyLinkedList<>();
		list.add(0, "ania");
		list.add(0, "nina");
		list.add(2, "ziemo");
		list.add(3, "mama");
		list.add(1, "tata");
		list.iterate();

		list.remove(0);
		list.iterate();
	}
}
