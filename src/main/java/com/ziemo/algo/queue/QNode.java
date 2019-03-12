package com.ziemo.algo.queue;

public class QNode {

	private String value;
	private QNode nextNode;
	private Integer priority;

	public QNode(String value, Integer priority) {
		this.value = value;
		this.priority = priority;
	}

	public String getValue() {
		return value;
	}

	public QNode getNextNode() {
		return nextNode;
	}

	public void setNextNode(QNode nextNode) {
		this.nextNode = nextNode;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}
}
