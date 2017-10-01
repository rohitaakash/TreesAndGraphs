package com.rohit.ctci4;

public class BinarySearchTree {

	public static class Node{
		public int key;
		
		public Node left;
		public Node right;
		
		public Node(int key) {
			this.key = key;
		}
		
	}
	Node root;
	
	public void insert(Node node, int value) {
		if(node != null) {
			if(value <= node.left.key) {
				insert(node.left, value);
			}else {
				insert(node.right, value);
			}
		}else {
			node = new Node(value);
		}
	}
	
	public boolean contains(Node node, int value) {
		if(node == null) {
			return false;
		}else {
			if(value <= node.key) {
				return contains(node.left, value);
			}else {
				return contains(node.right, value);
			}
		}
	}
	
	public void printInOrder(Node node) {
		if(node != null) {
			printInOrder(node.left);
			System.out.println(node.key);
			printInOrder(node.right);
		}
	}
	
	public void printPreOrder(Node node) {
		if(node != null) {
			System.out.println(node.key);
			printPreOrder(node.left);
			printPreOrder(node.right);
		}
	}
	
	public void printPostOrder(Node node) {
		if(node != null) {
			printPostOrder(node.left);
			printPostOrder(node.right);
			System.out.println(node.key);
		}
	}
	
	public void deleteNode(Node node) {
		
	}
}