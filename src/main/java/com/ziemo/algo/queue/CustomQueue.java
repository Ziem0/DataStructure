package com.ziemo.algo.queue;

import com.ziemo.algo.stack.StackUnderFlow;

public class CustomQueue {

	private QNode head;
	private QNode tail;
	private int size;

	public CustomQueue() {
		this.size = 0;
	}

	public void enqueue(String value, Integer priority) {
		QNode newNode = new QNode(value, priority);
		if (head == null) {
			head = newNode;
			tail = newNode;
		} else {
			if (priority == null) {
				tail.setNextNode(newNode);
				tail = newNode;
			} else if (priority == 1) {
				newNode.setNextNode(head);
				head = newNode;
			} else {
				enqueueWithPriority(newNode);
			}
		}
		size++;
	}

	private void enqueueWithPriority(QNode newNode) {
		QNode current = head;
		int priority = newNode.getPriority();

		for (int i = 1; i < priority; i++) {
			if (current.getNextNode() == null) {
				current.setNextNode(newNode);
				tail = newNode;
			} else if (i == priority - 1) {
				newNode.setNextNode(current.getNextNode());
				current.setNextNode(newNode);
			} else {
				current = current.getNextNode();
			}
		}
	}

	//return first element
	public String peek() throws StackUnderFlow {
		if (head == null) {
			throw new StackUnderFlow("Queue is empty!");
		}
		return head.getValue();
	}

	//return first and remove it by assigning new node
	public String dequeue() throws StackUnderFlow {
		if (head == null) {
			throw new StackUnderFlow("Queue is empty!");
		} else {
			String value = head.getValue();
			head = head.getNextNode();
			size--;
			return value;
		}
	}


	public int queueSize() {
		return size;
	}

	public boolean isEmpty() {
		return head == null;
	}

}
