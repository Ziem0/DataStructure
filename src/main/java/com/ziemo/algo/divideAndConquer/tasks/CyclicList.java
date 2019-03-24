package com.ziemo.algo.divideAndConquer.tasks;

public class CyclicList {

	public static class Node {
		Integer data;
		Node next;
		Node previous;
		boolean isHead = false;
		boolean isTail = false;

		public Node(Integer data) {
			this.data = data;
		}
	}

	Node head;
	Node tail;
	int size = 0;

	public boolean isEmpty() {
		return head == null;
	}

	public void add(Integer newData) {
		Node newNode = new Node(newData);
		if (isEmpty()) {
			head = newNode;
			newNode.isHead = true;
			tail = newNode;
			newNode.isTail = true;
			tail.next = head;//
			head.previous = tail;//
			size++;
			return;
		}
		newNode.previous = tail;
		tail.next = newNode;
		tail = newNode;
		tail.next = head;//
		head.previous = tail;//
		size++;
	}

	public Node get(int idx) {
		if (isEmpty() || idx < 0 || idx >= size) {
			throw new IndexOutOfBoundsException("out!");
		}
		Node current = head;
		while (idx > 0) {
			current = current.next;
			idx--;
		}
		return current;
	}

	public void remove(int idx) {
		if (isEmpty() || idx < 0 || idx >= size) {
			throw new IndexOutOfBoundsException("out!");
		}

		if (idx == 0) {
			head.next.previous = null;
			head = head.next;
			tail.next = head;//
			head.previous = tail;//
		} else if (idx == size - 1) {
			tail.previous.next = null;
			tail = tail.previous;
			tail.next = head;//
			head.previous = tail;//
		} else {
			Node current = head;
			while (idx > 0) {
				current = current.next;
				idx--;
			}
			current.previous.next = current.next;
			current.next.previous = current.previous;
			current.next = null;
			current.previous= null;
		}
		size--;
	}

//	public List<Integer> filter(int k) {
//		ArrayList<Integer> result = new ArrayList<>();
//
//		Node current = head;
//		while (size > 1) {
//			int counter = k;
//			while (counter > 1) {
//				current = current.next;
//				counter--;
//			}
//
//			if (current.isHead && current.next.isTail) {
//
//			}
//
//			current.previous.next = current.next;
//			current.next.previous = current.previous;
//
//			if (current.isHead) {
//				current.next.isHead = true;
//				if (current.next.isTail) {
//					current.next = current.previous;
//				}
//			}
//
//			result.add(current.data);
//			current = current.next;
//			System.out.println("now is:" + current.data);
//			System.out.println("next is:" + current.next.data);
//		}
//		return result;
//	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		Node current = head;
		int counter = size;
		while (counter > 0) {
			s.append(current.data).append(" ");
			current = current.next;
			counter--;
		}
		return s.toString();
	}

//	public static void main(String[] args) {
//		CyclicList l = new CyclicList();
//		l.add(1);
//		l.add(2);
//		l.add(3);
//
//		l.filter(2);
//
//		System.out.println(l);
//
//	}



}
