package com.ziemo.algo.graph.simple;

import java.util.Iterator;
import java.util.LinkedList;

public class BFSsimple {

	private int size;
	private LinkedList<Integer>[] nodes;

	public BFSsimple(int size) {
		this.size = size;
		this.nodes = new LinkedList[size];
		for (int i = 0; i < size; i++) {
			nodes[i] = new LinkedList<>();
		}
	}

	public void addEdge(int source, int goal) {
		nodes[source].add(goal);
	}

	public void BFS(int source) {
		boolean[] visited = new boolean[size];
		LinkedList<Integer> queue = new LinkedList<>();

		queue.add(source);
		visited[source] = true;

		while (queue.size() != 0) {

			source = queue.poll();
			System.out.println(source + " ");

			Iterator<Integer> i = nodes[source].listIterator();
			while (i.hasNext()) {
				int next = i.next();
				if (!visited[next]) {
					visited[next] = true;
					queue.add(next);
				}
			}
		}
	}


	public static void main(String[] args) {
		BFSsimple bfs = new BFSsimple(4);
		bfs.addEdge(0, 3);
		bfs.addEdge(0, 2);
		bfs.addEdge(1, 2);
		bfs.addEdge(1, 0);
		bfs.addEdge(2, 1);
		bfs.addEdge(2, 3);
		bfs.addEdge(3, 2);

		bfs.BFS(0);
	}
}
