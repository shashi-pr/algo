package com.edu.algo.graph;

import java.util.LinkedList;

public class BreadthFirstPath {
	
	private boolean[] marked;
	private int[] edgeTo;
	private int s;
	
	public BreadthFirstPath(Graph graph, int s) {
		marked = new boolean[graph.V()];
		edgeTo = new int[graph.V()];
		
		bfs(graph, s);
	}
	
	private void bfs(Graph graph, int s) {
		LinkedList<Integer> queue = new LinkedList<Integer>();
		queue.offer(s);
		marked[s] = true;
		
		while(!queue.isEmpty()) {
			int v = queue.poll();
			for(int w : graph.adj(v)) {
				if(!marked[v]) {
					queue.offer(w);
					marked[w] = true;
					edgeTo[w] = v;
				}
			}
		}
	}

}
