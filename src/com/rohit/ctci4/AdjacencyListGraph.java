package com.rohit.ctci4;

import java.util.ArrayList;
import java.util.List;

public class AdjacencyListGraph {
	List<Vertex> vertexList;
	
	public AdjacencyListGraph() {
		vertexList = new ArrayList<>();
	}
	
	public void addVertex(char label) {
		if (vertexIndex(label) == -1) {
			Vertex v = new Vertex(label);
			vertexList.add(v);
		}
	}
	
	public int vertexIndex(char label) {
		int i = 0;
		for(Vertex v: vertexList) {
			if(v.label == label) return i;
			i++;
		}
		return -1;
	}
	
	public void removeVertex(char label) {
		if(vertexIndex(label) != -1) {
			for(Edge e: vertexList.get(vertexIndex(label)).neighbours) {
				vertexList.get(vertexIndex(e.to)).neighbours.remove(edgeIndex(e.to, label));
			}
			vertexList.remove(vertexIndex(label));
		}
	}
	
	public void addEdge(char from, char to, int weight) {
		if(edgeIndex(from, to) == -1) {
			Edge e1 = new Edge(to, weight);
			vertexList.get(vertexIndex(from)).neighbours.add(e1);
			
			Edge e2 = new Edge(from, weight);
			vertexList.get(vertexIndex(to)).neighbours.add(e2);
		}
	}
	
	public void removeEdge(char from, char to) {
		if(edgeIndex(from, to) != -1) {
			vertexList.get(vertexIndex(from)).neighbours.remove(edgeIndex(from, to));
			vertexList.get(vertexIndex(to)).neighbours.remove(edgeIndex(to, from));
		}
	}
	
	public int edgeIndex(char from, char to) {
		if(vertexIndex(from) != -1 && vertexIndex(to) != -1) {
			int i = 0;
			for(Edge e: vertexList.get(vertexIndex(from)).neighbours) {
				if(e.to == to) return i;
				i++;
			}
		}
		return -1;
	}
	
	public List<Edge> getNeighbours(char label){
		return vertexList.get(vertexIndex(label)).neighbours;
	}
	
	public static void main(String[] args) {
		AdjacencyListGraph alg = new AdjacencyListGraph();
		alg.addVertex('A');
		alg.addVertex('B');
		alg.addVertex('C');
		alg.addVertex('D');
		
		alg.addEdge('A', 'B', 1);
		alg.addEdge('B', 'D', 3);
		alg.addEdge('B', 'C', 2);		
		System.out.println(alg.edgeIndex('A', 'B') >= 0);
		
		alg.removeEdge('A', 'B');		
		System.out.println(alg.edgeIndex('A', 'B') >= 0);
		
		alg.addEdge('B', 'D', 3);
		alg.removeVertex('D');
		System.out.println(alg.vertexIndex('D') >= 0);
		
		for(Edge e: alg.getNeighbours('B')) {
			System.out.println(e.to + ", " + e.edgeWeight);
		}
		
	}
}

class Vertex{
	char label;
	List<Edge> neighbours;
	
	public Vertex(char label) {
		this.label = label;
		neighbours = new ArrayList<>();
	}
}

class Edge{
	char to;
	int edgeWeight;
	
	public Edge(char to, int edgeWeight) {
		this.to = to;
		this.edgeWeight = edgeWeight;
	}
}