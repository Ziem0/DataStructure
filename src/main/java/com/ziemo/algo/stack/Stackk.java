package com.ziemo.algo.stack;

import java.util.Arrays;

public class Stackk <T>{

	private int size;
	private T[] container;
	private int top;

	public Stackk(int size) {
		this.size = size;
		this.container = (T[]) new Object[size];
		this.top = -1;
	}

	//O(1)
	public int getSize() {
		return size;
	}

	//O(1)
	public int leftSize() {
		if (top == -1) {
			return size;
		}
		return size - (top+1);
	}

	//O(1)
	public void push(T element) throws StackOverFlow {
		if (leftSize() == 0) {
			throw new StackOverFlow("Stack is over! You cannot add new element. Before do that, remove an element");
		}
		top++;
		container[top] = element;
	}

	//O(1)
	public T pop() throws StackUnderFlow {
		if (top == -1) {
			throw new StackUnderFlow("StackOverFlow exception! Stack is empty. To select an element, first add new element");
		}
		T out = container[top];
		container[top] = null;
		top--;
		return out;
	}

	//O(1)
	public T peek() throws StackUnderFlow {
		if (top == -1) {
			throw new StackUnderFlow("StackOverFlow exception! Stack is empty. To select an element, first add new element");
		}
		return container[top];
	}

	@Override
	public String toString() {
		return Arrays.toString(container).replaceAll("\\[|]|,", "");
	}

}
