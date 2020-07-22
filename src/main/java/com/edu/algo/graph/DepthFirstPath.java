package com.edu.algo.graph;

import java.util.LinkedList;

public class DepthFirstPath {
	private boolean[] marked;
	private int[] edgeTo;
	private int s;

	public DepthFirstPath(Graph graph, int s) {
		marked = new boolean[graph.V()];
		edgeTo = new int[graph.V()];
		dfs(graph, s);
	}

	private void dfs(Graph graph, int v) {
		marked[v] = true;
		for (int w : graph.adj(v)) {
			if (!marked[w]) {
				edgeTo[w] = v; // This was wrong in video
				dfs(graph, w);				
			}
		}
	}

	public boolean hasPathTo(int v) {
		return marked[v];
	}

	public Iterable<Integer> pathTo(int v) {
		if (!hasPathTo(v))
			return null;
		LinkedList<Integer> path = new LinkedList<Integer>();
		for (int x = v; x != s; x = edgeTo[x]) {
			path.push(x);			
		}
		path.push(s);
		return path;
	}
}
