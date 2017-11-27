package com.rohit.ctci4;

import java.util.ArrayList;
import java.util.List;

public class AdjListGraph {
	List<List<Integer>> adjList;
	
	public AdjListGraph(int numVertices) {
		adjList = new ArrayList<>();
		for (int i = 0; i < numVertices; i++) {
			adjList.add(i, new ArrayList<>());
		}
	}
	
	public void addEdge(int i, int j) {
		adjList.get(i).add(j);
		adjList.get(j).add(i);
	}
	
	public void removeEdge(int i, int j) {
		adjList.get(i).remove(adjList.get(i).indexOf(j));
		adjList.get(j).remove(adjList.get(j).indexOf(i));
	}
	
	public void addVertex() {
		adjList.add(new ArrayList<>());
	}
	
	public void removeVertex(int i) {
		for(int k: adjList.get(i)) {
			adjList.get(k).remove(adjList.get(k).indexOf(i));
		}
		adjList.remove(i);
	}
	
	public boolean hasEdge(int i, int j) {
		for(int k: adjList.get(i)) {
			if(k == j) return true;
		}
		return false;
	}
	
	
	public static void main(String[] args) {
		AdjListGraph adjListGraph = new AdjListGraph(4);
		adjListGraph.addEdge(0, 1);
		adjListGraph.addEdge(1, 2);
		adjListGraph.addEdge(1, 3);
		
		System.out.println(adjListGraph.hasEdge(0, 2));
		System.out.println(adjListGraph.hasEdge(0, 1));
		
		adjListGraph.removeEdge(0, 1);
		System.out.println(adjListGraph.hasEdge(0, 1));
		
		AdjacencyListGraph.main(null);
		
	}
	
}