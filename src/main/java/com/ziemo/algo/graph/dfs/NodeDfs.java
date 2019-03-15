package com.ziemo.algo.graph.dfs;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class NodeDfs {

	String label;
	Map<NodeDfs, Integer> adjacents;

	public NodeDfs(String label) {
		this.label = label;
		this.adjacents = new HashMap<>();
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Map<NodeDfs, Integer> getAdjacents() {
		return adjacents;
	}

	public void setAdjacents(Map<NodeDfs, Integer> adjacents) {
		this.adjacents = adjacents;
	}

	public void addNode(NodeDfs newNode, Integer distance) {

		try {
			if (isContainNode(newNode)) {
				throw new IllegalArgumentException();
			}
		} catch (IllegalArgumentException e) {
			System.err.println("This node is present already");
		}
		adjacents.put(newNode, distance);
	}

	public boolean isContainNode(NodeDfs node) {
		return adjacents.keySet().contains(node);
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		NodeDfs nodeDfs = (NodeDfs) o;
		return Objects.equals(label, nodeDfs.label);
	}

	@Override
	public int hashCode() {

		return Objects.hash(label);
	}


}
