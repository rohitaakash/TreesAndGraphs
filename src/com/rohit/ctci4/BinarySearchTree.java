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
	public Node root;
	
	private static Node insert(Node node, int value) {
		if(node != null) {
			if(value <= node.key) {
				node.left = insert(node.left, value);
			}else {
				node.right = insert(node.right, value);
			}
		}else {
			return new Node(value);
		}
		return node;
	}
	
	public void insert(int value) {		
		root=insert(root, value);
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
	
	public boolean deleteNode(int key, Node parent) {


		return false;
	}
}