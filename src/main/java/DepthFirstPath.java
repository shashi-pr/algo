import java.util.Stack;

public class DepthFirstPath {

	public boolean[] marked;
	public int[] edgeTo;
	private int s;

	public DepthFirstPath(Graph G, int s) {
		marked = new boolean[G.v()];
		edgeTo = new int[G.v()];
		dfs(G, s);
	}

	private void dfs(Graph g, int v) {
		marked[v] = true;

		for (int w : g.adj(v)) {
			if (!marked[w]) {
				edgeTo[w] = v;
				dfs(g, w);
			}
		}
	}

	public boolean hasPathTo(int v) {
		return marked[v];
	}

	public Iterable<Integer> pathTo(int v) {
		if (!hasPathTo(v))
			return null;
		Stack<Integer> path = new Stack<Integer>();
		for (int x = v; x != s; x = edgeTo[x]) {
			path.push(x);
		}
		path.push(s);
		return path;
	}
}
