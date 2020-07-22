package com.edu.algo.graph;

public class ConnectedComponent {

	private boolean[] marked;
	private int count;
	private int[] id;

	public ConnectedComponent(Graph graph) {
		marked = new boolean[graph.V()];
		id = new int[graph.V()];
		for (int v = 0; v < graph.V(); v++) {
			if (!marked[v]) {
				dfs(graph, v);
				count++;
			}
		}
	}

	private void dfs(Graph graph, int v) {
		marked[v] = true;
		id[v] = count;
		for (int w : graph.adj(v)) {
			if (!marked[w]) {
				dfs(graph, w);
			}
		}
	}

	int count() {
		return count;
	}

	int id(int v) {
		return id[v];
	}
}
