package com.ziemo.algo.graph.dfs;

import java.util.HashSet;
import java.util.Set;

public class AlgDijkstra {








	public static void main(String[] args) {
		Set<NodeDfs> nodes = new HashSet<>();
		NodeDfs node1 = new NodeDfs("one");
		NodeDfs node2 = new NodeDfs("two");
		NodeDfs node3 = new NodeDfs("three");
		NodeDfs node4 = new NodeDfs("four");
		nodes.add(node1);
		nodes.add(node2);
		nodes.add(node3);
		nodes.add(node4);

		node1.addNode(node2,1);
		node2.addNode(node1,1);

		node1.addNode(node4,10);
		node4.addNode(node1,10);

		node2.addNode(node3,2);
		node3.addNode(node2, 2);

		node2.addNode(node4,4);
		node4.addNode(node2,4);

		node3.addNode(node4,3);
		node4.addNode(node3, 3);

		GraphDfs graph = new GraphDfs(nodes);



	}
}
