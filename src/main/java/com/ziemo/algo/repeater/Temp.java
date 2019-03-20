package com.ziemo.algo.repeater;


import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class Temp { //BFS

	int size;
	LinkedList<Integer>[] nodes;

	public Temp(int size) {
		this.size = size;
		this.nodes = new LinkedList[size];
		for (int i = 0; i < nodes.length; i++) {
			nodes[i] = new LinkedList<>();
		}
	}

	public void addEdge(int source, int dest) {
		nodes[source].add(dest);
	}

	public void BFS(int source) {
		boolean[] visisted = new boolean[size];
		ArrayDeque<Integer> queue = new ArrayDeque<>();

		visisted[source] = true;
		queue.add(source);

		while (queue.size() > 0) {
			source = queue.poll();
			System.out.println(source + " → " + nodes[source]);

			Iterator<Integer> i = nodes[source].iterator();
			while (i.hasNext()) {
				int n = i.next();
				if (!visisted[n]) {
					visisted[n] = true;
					queue.add(n);
				}
			}
		}
	}

	public static void main(String[] args) {
		Temp t = new Temp(4);
		t.addEdge(0,2);
		t.addEdge(1,2);
		t.addEdge(2,0);
		t.addEdge(0,1);
		t.addEdge(2,1);
		t.addEdge(1,3);
		t.addEdge(3, 0);
		t.BFS(0);
	}


	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//public class Temp { //DFS
//
//	int size;
//	LinkedList<Integer>[] nodes;
//
//	public Temp(int size) {
//		this.size = size;
//		this.nodes = new LinkedList[size];
//		for (int i = 0; i < nodes.length; i++) {
//			nodes[i] = new LinkedList<>();
//		}
//	}
//
//	public void addEdge(int source, int destination) {
//		nodes[source].add(destination);
//	}
//
//	public void DFS(int source) {
//		boolean[] visited = new boolean[size];
//		runDFS(source, visited);
//	}
//
//	private void runDFS(int source, boolean[] visited) {
//		visited[source] = true;
//		System.out.println(nodes[source] + " → " + source);
//		Iterator<Integer> i = nodes[source].iterator();
//
//		while (i.hasNext()) {
//			int newSource = i.next();
//			if (!visited[newSource]) {
//				runDFS(newSource, visited);
//			}
//		}
//	}
//
//
//	public static void main(String[] args) {
//		Temp t = new Temp(3);
//		t.addEdge(0,1);
//		t.addEdge(0,2);
//		t.addEdge(1,2);
//		t.addEdge(2, 0);
//		t.DFS(1);
//	}


	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//public class Temp <K,V> { //HashMap
//
//	public static class KeyValue<K, V> {
//		K key;
//		V value;
//
//		public KeyValue(K key, V value) {
//			this.key = key;
//			this.value = value;
//		}
//	}
//
//	int size;
//	LinkedList<KeyValue>[] elements;
//
//	public Temp(int size) {
//		this.size = size;
//		this.elements = new LinkedList[size];
//	}
//
//	private int getHash(K key) {
//		return Math.abs(key.hashCode() % size);
//	}
//
//	public void add(K key, V value) {
//		int position = getHash(key);
//		System.out.println(position);
//		LinkedList<KeyValue> list = elements[position];
//
//		if (list == null) {
//			list = new LinkedList<>();
//		}
//
//		for (KeyValue keyValue : list) {
//			if (keyValue.key == key) {
//				keyValue.value = value;
//				return;
//			}
//		}
//
//		list.add(new KeyValue(key, value));
//		elements[position] = list;
//	}
//
//	public void remove(K key) {
//		int position = getHash(key);
//
//		if (elements[position] != null) {
//			for (KeyValue keyValue : elements[position]) {
//				if (keyValue.key == key) {
//					elements[position].remove(keyValue);
//					return;
//				}
//			}
//		} else {
//			throw new IllegalArgumentException("There is no such key");
//		}
//	}
//
//	public V get(K key) {
//		int pos = getHash(key);
//		if (elements[pos] != null) {
//			for (KeyValue keyValue : elements[pos]) {
//				if (keyValue.key == key) {
//					return (V) keyValue.value;
//				}
//			}
//		}
//		throw new IllegalArgumentException("Ther is no such key");
//	}
//
//	public void clearAll() {
//		for (LinkedList<KeyValue> element : elements) {
//			if (element != null) {
//				element.remove();
//			}
//		}
//	}
//
//	@Override
//	public String toString() {
//		StringBuilder result = new StringBuilder();
//		for (LinkedList<KeyValue> element : elements) {
//			if (element != null) {
//				for (KeyValue keyValue : element) {
//					result.append(keyValue.key).append(" ").append(keyValue.value).append(element.size()).append("\n");
//				}
//			}
//		}
//		return result.toString();
//	}
//
//	public static void main(String[] args) {
//		Temp<String, String> map = new Temp<>(6);
//		map.add("ziemo", "andrzejewski");
//		map.add("omeiz", "andrzejewski");
//		map.add("nina", "andrzejewskaaaaa");
//		map.add("ania", "ando");
//		map.add("gabi", "majchrzak");
//		map.add("gadwbi", "majcwdhrzak");
//		map.add("krysia", "tomaszewska");
//		System.out.println(map);
//	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//public class Temp<T> {   //Queue
//
//	public static class Node <T>{
//		T data;
//		Node<T> next;
//
//		public Node(T data) {
//			this.data = data;
//		}
//	}
//
//	Node<T> head;
//	Node<T> tail;
//	int size = 0;
//
//
//	public void enqueue(T item) {
//		if (head == null) {
//			Node<T> newNode = new Node<>(item);
//			head = newNode;
//			tail = newNode;
//			size++;
//			return;
//		}
//		Node<T> newNode = new Node<>(item);
//		tail.next = newNode;
//		tail = newNode;
//		size++;
//	}
//
//	public Node<T> peek() {
//		if (head == null) {
//			throw new IndexOutOfBoundsException("Out of bound");
//		}
//		return head;
//	}
//
//	public Node<T> dequeue() {
//		if (head == null) {
//			throw new IndexOutOfBoundsException("Out of bound");
//		}
//		Node<T> removed = head;
//		head = head.next;
//		size--;
//		return removed;
//	}
//
//	public int queueSize() {
//		return size;
//	}
//
//	public boolean isEmpty() {
//		return head == null;
//	}
//
//	@Override
//	public String toString() {
//		StringBuilder result = new StringBuilder();
//		Node<T> current = head;
//		while (current != null) {
//			result.append(current.data).append(" ");
//			current = current.next;
//		}
//		return result.toString();
//	}
//
//	public static void main(String[] args) {
//		Temp<String> t = new Temp<>();
//		t.enqueue("ziemo");
//		t.enqueue("ania");
//		t.enqueue("nina");
//		System.out.println(t);
//		System.out.println(t.dequeue().data);
//		System.out.println(t.queueSize());
//	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//public class Temp<T> { //Stack
//
//	T[] content;
//	int size;
//	int top;
//
//	public Temp(int size) {
//		this.size = size;
//		this.content = (T[])new Object[size];
//		this.top = -1;
//	}
//
//
//	public int getSize() {
//		return size;
//	}
//
//	public int leftSpace() {
//		if (top == -1) {
//			return size;
//		}
//		return size - (top+1);
//	}
//
//	public void push(T item) throws StackOverFlow {
//		if (leftSpace() == 0) {
//			throw new StackOverFlow("Stack is full");
//		}
//		top++;
//		content[top] = item;
//	}
//
//	public T pop() throws StackUnderFlow {
//		if (leftSpace() == size) {
//			throw new StackUnderFlow("Stack is empty");
//		}
//		T result = content[top];
//		content[top] = null;
//		top--;
//		return result;
//	}
//
//	public T peek() throws StackUnderFlow {
//		if (leftSpace() == size) {
//			throw new StackUnderFlow("Stack is empty");
//		}
//		return content[top];
//	}
//
//	@Override
//	public String toString() {
//		StringBuilder s = new StringBuilder();
//		for (int i = 0; i < content.length; i++) {
//			if (content[i] != null) {
//				s.append(content[i]).append(" ");
//			}
//		}
//		return s.toString();
//	}
//
//	public static void main(String[] args) throws StackOverFlow, StackUnderFlow {
//		Temp<String> t = new Temp<>(5);
//		t.push("ziemo");
//		t.push("ania");
//		t.push("nina");
//		System.out.println(t);
//		System.out.println(t.leftSpace());
//		System.out.println(t.pop());
//		System.out.println(t.peek());
//		System.out.println(t.leftSpace());
//	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//public class Temp <T>{  //LinkedList
//
//	public static class Node <T>{
//		T data;
//		Node next;
//		Node previous;
//
//		public Node(T data) {
//			this.data = data;
//		}
//	}
//
//	Node<T> first;
//	Node<T> last;
//
//	public boolean  isEmpty() {
//		return first == null;
//	}
//
//	public int getSize() {
//		Node<T> current = first;
//		int size = 0;
//		while (current != null) {
//			size++;
//			current = current.next;
//		}
//		return size;
//	}
//
//	public Node<T> get(int index) {
//		if (isEmpty() || index < 0) {
//			throw new IndexOutOfBoundsException("out man!");
//		}
//
//		Node<T> current = first;
//		while (index > 0) {
//			if (current.next != null) {
//				current = current.next;
//			}
//			index--;
//		}
//		return current;
//	}
//
//	public void add(int index, T item) {
//		if (isEmpty()) {
//			first = new Node<>(item);
//			last = first;
//			return;
//		}
//		if (index == 0) {
//			Node<T> newNode = new Node<>(item);
//			newNode.next = first;
//			first.previous = newNode;
//			first = newNode;
//		} else if (index == getSize()) {
//			Node<T> newNode = new Node<>(item);
//			newNode.previous = last;
//			last.next = newNode;
//			last = newNode;
//		} else {
//			Node<T> newNode = new Node<>(item);
//			Node<T> current = get(index);
//			Node<T> back = current.previous;
//			back.next = newNode;
//			current.previous = newNode;
//			newNode.previous = back;
//			newNode.next = current;
//		}
//	}
//
//	public void remove(int index) {
//		if (isEmpty() || index < 0) {
//			throw new IndexOutOfBoundsException("out man!");
//		}
//		if (index == 0) {
//			first.next.previous = null;
//			first = first.next;
//			return;
//		}
//		if (index == getSize() - 1) {
//			last.previous.next = null;
//			last = last.previous;
//			return;
//		}
//
//		Node<T> toRemove = get(index);
//		toRemove.previous.next = toRemove.next;
//		toRemove.next.previous = toRemove.previous;
//		toRemove.next = null;
//		toRemove.previous = null;
//	}
//
//	@Override
//	public String toString() {
//		StringBuilder result = new StringBuilder();
//		Node current = first;
//		while (current != null) {
//			result.append(current.data).append(" ");
//			current = current.next;
//		}
//		return result.toString();
//	}
//
//
//	public static void main(String[] args) {
//		Temp<String> t = new Temp<>();
//		t.add(0, "ziemo");
//		t.add(1, "ania");
//		t.add(2, "nina");
//		t.add(2, "tata");
//		System.out.println(t);
//		t.remove(3);
//		System.out.println(t);
//
//	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//public class Temp <T>{   //array
//
//	private int size;
//	private T[] content;
//
//	public Temp() {
//		this.size = 0;
//		this.content = (T[]) new Object[size+1];
//	}
//
//	public void add(T item) {
//		if (size == 0) {
//			content[size] = item;
//			size++;
//			return;
//		}
//		size++;
//		T[] temp = (T[]) new Object[size];
//		System.arraycopy(content, 0, temp, 0, size - 1);
//		content = temp;
//		content[size - 1] = item;
//	}
//
//	public void insert(int index, T item) {
//		if (index == size) {
//			add(item);
//			return;
//		}
//		size++;
//		T[] temp = (T[]) new Object[size];
//		System.arraycopy(content, 0, temp, 0, index);
//		System.arraycopy(content, index, temp, index + 1, size - 1 - index);
//		content = temp;
//		content[index] = item;
//	}
//
//	public void remove(int index) {
//		size--;
//		T[] temp = (T[]) new Object[size];
//		System.arraycopy(content, 0, temp, 0, index);
//		System.arraycopy(content, index + 1, temp, index, size - index);
//		content = temp;
//	}
//
//	@Override
//	public String toString() {
//		StringBuilder result = new StringBuilder();
//		for (T t : content) {
//			result.append(t).append(" ");
//		}
//		return result.toString();
//	}
//
//	public static void main(String[] args) {
//		Temp<String> t = new Temp<>();
//		t.add("ziemo");
//		t.add("ania");
//		t.add("nina");
//		t.insert(3,"tata");
//		t.insert(2, "mama");
//		t.remove(2);
//		System.out.println(t);
//	}
}
