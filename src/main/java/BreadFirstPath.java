import java.util.LinkedList;
import java.util.Queue;

public class BreadFirstPath {

	private boolean[] marked;
	private int[] edgeTo;

	public BreadFirstPath(Graph graph, int s) {
		marked = new boolean[graph.v()];
		edgeTo = new int[graph.v()];
		bfs(graph, s);
	}

	private void bfs(Graph graph, int s) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(s);
		marked[s] = true;
		while (!queue.isEmpty()) {
			int v = queue.remove();

			for (int w : graph.adj(v)) {
				if (!marked[w]) {
					queue.add(w);
					marked[w] = true;
					edgeTo[w] = v;
				}

			}
		}
	}

}
