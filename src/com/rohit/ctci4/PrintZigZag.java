
package com.rohit.ctci4;

import java.util.Stack;

import com.rohit.ctci4.BinarySearchTree.Node;

public class PrintZigZag {

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();		
		bst.insert(5);
		bst.insert(8);
		bst.insert(13);
		bst.insert(2);
		bst.insert(6);
		bst.insert(1);
		bst.insert(9);
		bst.insert(0);
		bst.insert(4);
		bst.insert( 11);
		
		printZigZag(bst);
		
	}
	
	public static void printZigZag(BinarySearchTree bst) {
		Stack<Node> stack1 = new Stack<>();
		Stack<Node> stack2 = new Stack<>();
		stack2.push(bst.root);		
		int i = 1;
		while(!stack1.isEmpty() || !stack2.isEmpty()) {			
			if(i%2 == 1) {
				while(!stack2.isEmpty()) {
					Node temp = stack2.pop();
					if(temp.left!=null) stack1.push(temp.left);
					if(temp.right!=null) stack1.push(temp.right);
					System.out.println(temp.key);
				}				
			}else {
				while(!stack1.isEmpty()) {
					Node temp = stack1.pop();
					if(temp.right!=null)stack2.push(temp.right);
					if(temp.left!=null)stack2.push(temp.left);
					System.out.println(temp.key);
				}
				
			}
			i++;
		}
		
	}
}
