package TreeADT;

import java.util.ArrayList;
import java.util.Stack;

public class BuildTree {
	
	class BinaryTreeNode {
		private String data;
		private BinaryTreeNode left, right;
		public BinaryTreeNode (String data) {
			this.data = data;
			this.left = this.right = null;
		}
		
		public String toString() {
			return this.data.toString();
		}
	}
	
	private String expression;
	static final int COUNT = 10;
	
	public BuildTree(String expression) {
		this.expression = expression;
	}
	
	public ArrayList<String> convertPost () {
		//ArrayList<String> output = new ArrayList<>();
		String[] tokens = expression.split(" ");
		ArrayList<String> output = new ArrayList<>();
		Stack<String> stack = new Stack<>();
		
		for (String token : tokens) {
			if (token.chars().allMatch(Character::isDigit)) {
				output.add(token);
			} else if (token.equals("(")) {
				stack.push(token);
			} else if (token.equals(")")) {
				while (!stack.peek().equals("(")) {
					String operator = stack.peek();
					output.add(operator);
					stack.pop();
				}
				stack.pop();
			} else if (isOperator(token)) {			
				if (stack.isEmpty()) stack.push(token);
				else if (isPriority(stack.peek(), token)) {
					output.add(stack.peek());
					stack.pop();
					stack.push(token);
				} else stack.push(token);
			} else throw new IllegalArgumentException("Not valid!");
		}
		
		while (!stack.isEmpty()) {
			output.add(stack.peek());
			stack.pop();
		}
		
		return output;
	}
	
	public boolean isPriority(String op1, String op2) {
		if ((op1.equals("*") || op1.equals("/")) && (op2.equals("+") || op2.equals("-"))) return true;
		return false;
	}
	
	public boolean isOperator(String op) {
		if ((op.equals("*") || op.equals("/") || op.equals("+") || op.equals("-"))) return true;
		return false;
	}
	
	public BinaryTreeNode tree () {
		Stack<BinaryTreeNode> nodes = new Stack<>();
		ArrayList<String> postfix = this.convertPost();
		
		for (String token : postfix) {
			if (!isOperator(token)) nodes.push(new BinaryTreeNode(token));
			else {
				BinaryTreeNode right = nodes.pop();
				BinaryTreeNode left = nodes.pop();
				BinaryTreeNode parent = new BinaryTreeNode(token);
				parent.left = left;
				parent.right = right;
				
				nodes.push(parent);
			}
		}
		
		return nodes.pop();
	}
	
	public void visualize (BinaryTreeNode root, int space) {
		// Base case
	    if (root == null)
	        return;
	 
	    // Increase distance between levels
	    space += COUNT;
	 
	    // Process right child first
	    visualize(root.right, space);
	 
	    // Print current node after space count
	    System.out.print("\n");
	    for (int i = COUNT; i < space; i++)
	        System.out.print(" ");
	    System.out.print(root.data + "\n");
	 
	    // Process left child
	    visualize(root.left, space);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String exp = "( 6 / 3 + 2 ) * ( 7 - 4 )";
		BuildTree build = new BuildTree(exp);
		System.out.println("Post-order: " + build.convertPost().toString());
		BinaryTreeNode root = build.tree();
		
		System.out.println("\nVISUALIZATION");
		int space = 0;
		build.visualize(root, space);
	}

}
