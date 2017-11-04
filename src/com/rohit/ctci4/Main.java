package com.rohit.ctci4;

public class Main {

	public static void main(String[] args) {
		MinHeap minHeap = new MinHeap();
		minHeap.add(10);
		minHeap.printHeap();
		
		minHeap.add(20);
		minHeap.printHeap();
		
		minHeap.add(7);
		minHeap.printHeap();
		
		minHeap.add(25);
		minHeap.printHeap();
		
		minHeap.add(13);
		minHeap.printHeap();
		
		minHeap.add(3);
		minHeap.printHeap();
		
		minHeap.poll();
		minHeap.printHeap();
		
		minHeap.poll();
		minHeap.printHeap();
	}
}
