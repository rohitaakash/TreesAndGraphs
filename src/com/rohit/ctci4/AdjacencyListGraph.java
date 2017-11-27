package com.rohit.ctci4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class AdjacencyListGraph {
	protected List<Vertex> vertexList;
	private Stack<Character> dfsStack;
	private Queue<Character> bfsQueue;

	public AdjacencyListGraph() {
		vertexList = new ArrayList<>();
		dfsStack = new Stack<>();
		bfsQueue = new LinkedList<>();
	}

	public void addVertex(char label) {
		if (vertexIndex(label) == -1) {
			Vertex v = new Vertex(label);
			vertexList.add(v);
		}
	}

	public int vertexIndex(char label) {
		int i = 0;
		for (Vertex v : vertexList) {
			if (v.label == label)
				return i;
			i++;
		}
		return -1;
	}

	public void removeVertex(char label) {
		if (vertexIndex(label) != -1) {
			for (Edge e : vertexList.get(vertexIndex(label)).neighbours) {
				vertexList.get(vertexIndex(e.label)).neighbours.remove(edgeIndex(e.label, label));
			}
			vertexList.remove(vertexIndex(label));
		}
	}

	public void addEdge(char from, char to, int weight) {
		if (edgeIndex(from, to) == -1) {
			Edge e1 = new Edge(to, weight);
			vertexList.get(vertexIndex(from)).neighbours.add(e1);
			Collections.sort(vertexList.get(vertexIndex(from)).neighbours, new Comparator<Edge>() {

				public int compare(Edge e1, Edge e2) {
					if (e1.label < e2.label) {
						return -1;
					} else if (e1.label > e2.label) {
						return 1;
					} else {
						return 0;
					}

				}
			});

			Edge e2 = new Edge(from, weight);
			vertexList.get(vertexIndex(to)).neighbours.add(e2);
			Collections.sort(vertexList.get(vertexIndex(to)).neighbours, new Comparator<Edge>() {

				public int compare(Edge e1, Edge e2) {
					if (e1.label < e2.label) {
						return -1;
					} else if (e1.label > e2.label) {
						return 1;
					} else {
						return 0;
					}

				}
			});
		}
	}

	public void removeEdge(char from, char to) {
		if (edgeIndex(from, to) != -1) {
			vertexList.get(vertexIndex(from)).neighbours.remove(edgeIndex(from, to));
			vertexList.get(vertexIndex(to)).neighbours.remove(edgeIndex(to, from));
		}
	}

	public int edgeIndex(char from, char to) {
		if (vertexIndex(from) != -1 && vertexIndex(to) != -1) {
			int i = 0;
			for (Edge e : vertexList.get(vertexIndex(from)).neighbours) {
				if (e.label == to)
					return i;
				i++;
			}
		}
		return -1;
	}

	public List<Edge> getNeighbours(char label) {
		return vertexList.get(vertexIndex(label)).neighbours;
	}

	public void recursiveDfs(char label) {
		vertexList.get(vertexIndex(label)).visited = true;
		System.out.print(label + " ");
		for (Edge e : vertexList.get(vertexIndex(label)).neighbours) {
			if (!vertexList.get(vertexIndex(e.label)).visited) {
				recursiveDfs(e.label);
			}
		}
	}

	public void iterativeDfs(char label) {
		vertexList.get(vertexIndex(label)).visited = true;
		dfsStack.push(label);
		System.out.print(label + " ");
		while (!dfsStack.isEmpty()) {
			char v = getFirstUnivisitedNeighbour(dfsStack.peek());
			if (v == ' ') {
				dfsStack.pop();
			} else {
				vertexList.get(vertexIndex(v)).visited = true;
				System.out.print(v + " ");
				dfsStack.push(v);
			}
		}
	}

	public char getFirstUnivisitedNeighbour(char label) {
		for (Edge e : vertexList.get(vertexIndex(label)).neighbours) {
			if (!vertexList.get(vertexIndex(e.label)).visited) {
				return e.label;
			}
		}
		return ' ';
	}

	public void bfs(char label) {
		vertexList.get(vertexIndex(label)).visited = true;
		bfsQueue.add(label);
		System.out.print(label + " ");
		while (!bfsQueue.isEmpty()) {
			char v = bfsQueue.poll();
			for (Edge e : vertexList.get(vertexIndex(v)).neighbours) {
				if (!vertexList.get(vertexIndex(e.label)).visited) {
					vertexList.get(vertexIndex(e.label)).visited = true;
					bfsQueue.add(e.label);
					System.out.print(e.label + " ");
				}
			}
		}
	}
	
	public void topologicalSortHelper(char label, Stack stack) {
		vertexList.get(vertexIndex(label)).visited = true;
		
		for(Edge e: vertexList.get(vertexIndex(label)).neighbours) {
			if(!vertexList.get(vertexIndex(e.label)).visited) {
				topologicalSortHelper(e.label, stack);
			}
		}
		
		stack.push(label);
	}
	
	public void topologicalSort() {
		Stack<Character> stack = new Stack();
		for (Vertex v : vertexList) {
			if(v.visited != true) {
				topologicalSortHelper(v.label, stack);
			}
		}
		
		while(!stack.isEmpty()) {
			stack.pop();
		}
	}
	

	public static void main(String[] args) {
		AdjacencyListGraph alg = new AdjacencyListGraph();
		alg.addVertex('A');
		alg.addVertex('B');
		alg.addVertex('C');
		alg.addVertex('D');
		alg.addVertex('E');
		alg.addVertex('F');

		alg.addEdge('A', 'B', 1);
		alg.addEdge('B', 'D', 3);
		alg.addEdge('B', 'C', 2);
		alg.addEdge('B', 'E', 4);
		alg.addEdge('A', 'F', 2);
		// System.out.println(alg.edgeIndex('A', 'B') >= 0);

		// alg.removeEdge('A', 'B');
		// System.out.println(alg.edgeIndex('A', 'B') >= 0);

		// alg.addEdge('B', 'D', 3);
		// alg.removeVertex('D');
		// System.out.println(alg.vertexIndex('D') >= 0);

		// for(Edge e: alg.getNeighbours('B')) {
		// System.out.println(e.label + ", " + e.edgeWeight);
		// }

		// alg.recursiveDfs('A');
		// alg.iterativeDfs('D');
		alg.bfs('D');
	}

}

class Vertex {
	char label;
	boolean visited;
	List<Edge> neighbours;

	public Vertex(char label) {
		this.label = label;
		visited = false;
		neighbours = new ArrayList<>();
	}
}

class Edge {
	char label;
	int edgeWeight;

	public Edge(char label, int edgeWeight) {
		this.label = label;
		this.edgeWeight = edgeWeight;
	}
}