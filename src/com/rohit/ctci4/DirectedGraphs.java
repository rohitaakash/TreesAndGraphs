package com.rohit.ctci4;

import java.util.Collections;
import java.util.Comparator;

public class DirectedGraphs extends AdjacencyListGraph{

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
		}
	}
}
