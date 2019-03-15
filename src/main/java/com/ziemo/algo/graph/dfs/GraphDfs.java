package com.ziemo.algo.graph.dfs;

import java.util.Set;

public class GraphDfs {

	Set<NodeDfs> nodes;

	public GraphDfs(Set<NodeDfs> nodes) {
		this.nodes = nodes;
	}

	public NodeDfs getNode(NodeDfs newNode) {
		NodeDfs searchedNode = null;
		for (NodeDfs node : nodes) {
			if (node == newNode) {
				searchedNode = node;
			}
		}
		if (searchedNode == null) {
			nodes.add(newNode);
			searchedNode = newNode;
		}
		return searchedNode;
	}


}
