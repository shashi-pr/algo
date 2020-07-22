import java.util.LinkedList;
import java.util.List;

public class Graph {
	
	private final int v;
	private List<Integer>[] adj;
	private int edge;
	
	public Graph(int v) {
		this.v = v;	
		adj = (LinkedList<Integer>[]) new LinkedList[v];	
		for (int i = 0; i < v; i++) {
			adj[i] = new LinkedList<Integer>();
		}
	}
	
	public void addEdge(int v, int w) {
		edge++;
		adj[v].add(w);
		adj[w].add(v);
	}
	
	public Iterable<Integer> adj(int v) {
		return adj[v];
	}
	
	public int v() {
		return v;
	}
	
	public int edge() {
		return edge;
	}

}
