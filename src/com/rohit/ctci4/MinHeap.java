package com.rohit.ctci4;

import java.util.Arrays;

public class MinHeap {
	private int capacity = 1;
	private int size = 0;

	int[] items = new int[capacity];

	public int getLeftChildIndex(int index) {
		return index * 2 + 1;
	}

	public int getRightChildIndex(int index) {
		return index * 2 + 2;
	}

	public int getParentIndex(int index) {
		return (index - 1) / 2;
	}

	public boolean hasLeftChild(int index) {
		return getLeftChildIndex(index) < size;
	}

	public boolean hasRightChild(int index) {
		return getRightChildIndex(index) < size;
	}

	public boolean hasParent(int index) {
		return getParentIndex(index) >= 0;
	}

	public int leftChild(int index) {
		return items[getLeftChildIndex(index)];
	}

	public int rightChild(int index) {
		return items[getRightChildIndex(index)];
	}

	public int parent(int index) {
		return items[getParentIndex(index)];
	}

	public void swap(int index1, int index2) {
		int temp = items[index1];
		items[index1] = items[index2];
		items[index2] = temp;
	}

	public void ensureCapactiy() {
		if (size == capacity) {
			items = Arrays.copyOf(items, capacity * 2);
			capacity = capacity * 2;
		}
	}

	public int peek() throws IllegalStateException {
		if (size == 0) {
			throw new IllegalStateException();
		}
		return items[0];
	}

	public int poll() throws IllegalStateException {
		if (size == 0) {
			throw new IllegalStateException();
		}

		int item = items[0];
		items[0] = items[size - 1];
		items[size-1] = 0;
		size = size - 1;
		heapifyDown();

		return item;
	}

	public void add(int n) {
		ensureCapactiy();
		items[size] = n;
		size++;
		heapifyUp();
	}

	private void heapifyUp() {
		int index = size - 1;
		while (hasParent(index) && parent(index) > items[index]) {
			swap(index, getParentIndex(index));
			index = getParentIndex(index);
		}
	}

	private void heapifyDown() {
		int index = 0;
		while (hasLeftChild(index)) {
			if (hasRightChild(index) && leftChild(index) > rightChild(index) && rightChild(index) < items[index]) {
				swap(getRightChildIndex(index), index);
				index = getRightChildIndex(index);
			} else if (leftChild(index) > items[index]) {
				swap(getLeftChildIndex(index), index);
				index = getLeftChildIndex(index);
			} else {
				return;
			}

		}
	}

	public void printHeap() {
		for (int i = 0; i < items.length; i++) {
			System.out.print(items[i] + " ");
		}
		System.out.println();
	}
}
