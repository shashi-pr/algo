package com.edu.algo.graph;

import java.util.LinkedList;

public class DiGraph {

	private int V;
	private final LinkedList<Integer>[] adj;

	public DiGraph(int V) {
		this.V = V;
		adj = (LinkedList<Integer>[]) new LinkedList[V];
		for (int i = 0; i < V; i++) {
			adj[i] = new LinkedList<Integer>();
		}
	}

	public void addEdge(int v, int w) {
		adj[v].add(w);
	}

	public Iterable<Integer> adj(int v) {
		return adj[v];
	}

}
