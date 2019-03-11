package com.ziemo.algo.linkedLista;

public class SinglyLinedList <T>{

	private Node first;

	public boolean isEmpty() {
		return first == null;
	}

	public int size() {
		int size = 0;
		Node currentNode = first;
		while (currentNode != null) {
			size++;
			currentNode = currentNode.getNextNode();
		}
		return size;
	}

	public T get(int index) {
		if (isEmpty() || index < 0) {
			throw new IndexOutOfBoundsException("Index " + index);
		}

		Node currentNode = first;
		while (index > 0) {
			if (currentNode == null) {
				throw new IndexOutOfBoundsException("Index " + index);
			}
			currentNode = currentNode.getNextNode();
			index--;

		}
		return (T) currentNode.getElement();
	}

	//metoda pomocnicza dla klasy NodePair
	public NodePair<T> getNodeWithPrevious(int index) {
		if (isEmpty() || index < 0) {
			throw new IndexOutOfBoundsException("Index " + index);
		}

		Node previousNode = null;
		Node currentNode = first;

		while (index > 0) {
			if (currentNode == null) {
				throw new IndexOutOfBoundsException("Index " + index);
			}
			previousNode = currentNode;
			currentNode = currentNode.getNextNode();
			index--;
		}

		return new NodePair<T>(currentNode, previousNode);

	}

	public boolean add(int index, T element) {
		//empty list
		if (index == 0 && first == null) {
			first = new Node<>(element);
			return true;
		}

		NodePair pair = getNodeWithPrevious(index);
		Node currentNode = pair.currentNode;
		Node previousNode = pair.previousNode;

		//adding at beginning of the list
		if (previousNode == null) {
			first = new Node<>(element);
			first.setNextNode(currentNode);
			return true;
		}

		Node<T> newNode = new Node<>(element);
		newNode.setNextNode(currentNode);
		previousNode.setNextNode(newNode);
		return true;
	}

	public void remove(int index) {
		if (first == null) {
			throw new IndexOutOfBoundsException("Index " + index);
		}

		NodePair pair = getNodeWithPrevious(index);
		Node currentNode = pair.currentNode;
		Node previousNode = pair.previousNode;

		if (previousNode == null) {
			first = currentNode.getNextNode();
			currentNode.setNextNode(null);

		} else {
			previousNode.setNextNode(currentNode.getNextNode());
			currentNode.setNextNode(null);
		}
	}

	public void iterate() {
		Node current = first;
		while (current != null) {
			System.out.println(current.getElement());
			current = current.getNextNode();
		}
		System.out.println();
	}


	public static void main(String[] args) {

		SinglyLinedList<String> list = new SinglyLinedList<>();
		list.add(0, "ania");
		list.add(0, "nina");
		list.add(0, "ziemo");

		list.iterate();

		list.remove(1);

		list.iterate();


	}
}
