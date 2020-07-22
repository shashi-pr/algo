package com.edu.algo.graph;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

public class Graph {

	private int V;
	private int E;

	private List<Integer>[] adj;

	@SuppressWarnings("unchecked")
	public Graph(int V) {
		this.V = V;
		this.E = 0;
		adj = (List<Integer>[]) new LinkedList[V];
		for (int v = 0; v < V; v++) {
			adj[v] = new LinkedList<Integer>();
		}
	}

	public Graph(InputStream in) {
		try {
			this.V = (Integer) in.read();
			for (int v = 0; v < V; v++) {
				adj[v] = new LinkedList<Integer>();
			}

			int E = in.read();
			for (int i = 0; i < E; i++) {
				int v = in.read();
				int w = in.read();
				addEdge(v, w);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void addEdge(int v, int w) {
		E++;
		adj[v].add(w);
		adj[w].add(v);
	}

	public Iterable<Integer> adj(int v) {
		return adj[v];
	}
	
	public int degree(int v) {
		return adj[v].size();
	}

	public int V() {
		return V;
	}

	public int E() {
		return E;
	}

	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(V + " vertices " + E + " edges " + System.getProperty("line.separator"));
		for (int v = 0; v < V; v++) {
			stringBuilder.append(v + ": ");
			for (int w: adj[v]) {
				stringBuilder.append(w + " ");
			}
			 stringBuilder.append("\n");
		}
		return stringBuilder.toString();
	}

}
