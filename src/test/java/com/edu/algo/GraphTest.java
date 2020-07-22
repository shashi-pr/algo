package com.edu.algo;

import org.junit.Before;
import org.junit.Test;

import com.edu.algo.graph.Graph;

public class GraphTest{
	
	
	@Before
	public void setUp() {
		
	}
	
	@Test
	public void graphTest() {
		
		 Graph graph = new Graph(3);
		 graph.addEdge(0, 1);
		 graph.addEdge(0, 2);
		 graph.addEdge(1, 2);
		 
		 System.out.println(graph);
	}

}
