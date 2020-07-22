package interview.hackerrank;

import java.util.LinkedList;

import com.edu.algo.graph.Graph;

public class BreadthFirstPath {

	private boolean[] marked;
	private int[] pathTo;

	public BreadthFirstPath(Graph graph, int s) {
		marked = new boolean[graph.V()];
		pathTo = new int[graph.V()];

		dfs(graph, s);
	}

	private void dfs(Graph graph, int s) {
		LinkedList<Integer> list = new LinkedList<>();
		list.offer(s);
		marked[s] = true;

		while (!list.isEmpty()) {
			int v = list.poll();
			for(int w : graph.adj(v)) {
				if(!marked[v]) {
					list.offer(w);
					marked[w] = true;
					pathTo[w] = v;
				}
			}

		}

	}

}
