package com.rohit.ctci4;

public class AdjacencyMatrixGraph {
	private boolean[][] adjMatrix;
	private int numVertices;

	public AdjacencyMatrixGraph(int numVertices) {
		this.numVertices = numVertices;
		this.adjMatrix = new boolean[numVertices][numVertices];
	}

	public void addEdge(int i, int j) {
		if (i >= 0 && i < numVertices && j >= 0 && j < numVertices) {
			adjMatrix[i][j] = true;
			adjMatrix[j][i] = true;
		}
	}
	
	public void removeEdge(int i, int j) {
		if (i >= 0 && i < numVertices && j >= 0 && j < numVertices) {
			adjMatrix[i][j] = false;
			adjMatrix[j][i] = false;
		}
	}

	public boolean checkEdge(int i, int j) {
		if (i >= 0 && i < numVertices && j >= 0 && j < numVertices) {
			return adjMatrix[i][j];
		}else {
			return false;
		}
	}
	
	public static void main(String[] args) {
		AdjacencyMatrixGraph adjMatrixGraph = new AdjacencyMatrixGraph(4);
		adjMatrixGraph.addEdge(0, 1);
		adjMatrixGraph.addEdge(1, 2);
		adjMatrixGraph.addEdge(1, 3);
		
		System.out.println(adjMatrixGraph.checkEdge(0, 2));
		System.out.println(adjMatrixGraph.checkEdge(0, 1));
		
		adjMatrixGraph.removeEdge(0, 1);
		System.out.println(adjMatrixGraph.checkEdge(0, 1));
	}
}
