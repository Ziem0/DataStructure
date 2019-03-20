package com.ziemo.algo.graph.simple;

import java.util.Iterator;
import java.util.LinkedList;

public class DFSsimple {

	private int numOfVert;

	//Adjacency List Representation
	private LinkedList<Integer>[] adj;

	public DFSsimple(int numOfVert) {
		this.numOfVert = numOfVert;
		adj = new LinkedList[numOfVert];
		for (int i = 0; i < numOfVert; i++) {
			adj[i] = new LinkedList<>();
		}
	}

	public void addEdge(int nodeIdx, int connectedNode) {
		adj[nodeIdx].add(connectedNode);
	}

	public void DFS(int nodeIdx) {
		//false by default
		boolean[] visited = new boolean[numOfVert];

		DFSUtil(nodeIdx, visited);
	}

	private void DFSUtil(int startIdx, boolean[] visited) {
		visited[startIdx] = true;
		System.out.println(startIdx + " ");

		Iterator<Integer> i = adj[startIdx].listIterator();
		while (i.hasNext()) {
			Integer next = i.next();
			if (!visited[next]) {
				DFSUtil(next, visited);
			}
		}

	}

	public static void main(String[] args) {
		DFSsimple dfs = new DFSsimple(4);
		dfs.addEdge(0,1);
		dfs.addEdge(0, 2);
		dfs.addEdge(1, 2);
		dfs.addEdge(2, 0);
		dfs.addEdge(2, 3);
		dfs.addEdge(3, 3);
		dfs.DFS(2);
	}
}
