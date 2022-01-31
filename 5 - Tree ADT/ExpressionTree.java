package TreeADT;

public class ExpressionTree<E> extends LinkedBinaryTree{
	public void preorderPrint(Node<E> p) {
		//pre-order traversal of tree with root p
		if (p == null) return;
		System.out.print(p.getElement() + " ");
		preorderPrint(p.getLeft());
		preorderPrint(p.getRight());
	}
	
	public void postorderPrint(Node<E> p) {
		//post-order traversal of tree with root p
		if (p == null) return;
		postorderPrint(p.getLeft());
		postorderPrint(p.getRight());
		System.out.print(p.getElement() + " ");
	}
	
	public void inorderPrint(Node<E> p) {
		//in-order traversal of tree with root p
		if (p == null) return;
		inorderPrint(p.getLeft());
		System.out.print(p.getElement() + " ");
		inorderPrint(p.getRight());
	}
	
	public static Double toDouble(String node) {
		Double number = Double.parseDouble(node);
		return number;
	}
	
	public static double oper2calculate(String operator, double leftValue, double rightValue) {
		switch (operator) {
		case "+":
			return leftValue + rightValue;
		case "-":
			return leftValue - rightValue;
		case "*":
			return leftValue * rightValue;
		case "/":
			if (rightValue == 0) throw new UnsupportedOperationException("Cannot divide by zero"); 
			return leftValue / rightValue; 
		default:
			return 0.0;
		}
	}
	
	public static Double compute(Node<String> root) {
		if (root == null) return 0.0;
		if (root.getLeft() == null || root.getRight() == null) return toDouble(root.getElement());
		
		double leftValue = compute(root.getLeft());
		double RightValue = compute(root.getRight());	
		String operator = root.getElement();
		return oper2calculate(operator, leftValue, RightValue);
	}
	
	public static void main(String[] args) {
		ExpressionTree<String> tree = new ExpressionTree<String>();
		
		// Creating tree
		System.out.println("\nCREATING TREE ...");
		tree.addRoot("*");
		Node<String> root = tree.root;
		tree.addLeft(root, "+");
		tree.addRight(root, "-");
		tree.addLeft(root.getLeft(), "/");
		tree.addRight(root.getLeft(), "2");
		tree.addLeft(root.getRight(), "7");
		tree.addRight(root.getRight(), "4");
		tree.addLeft(root.getLeft().getLeft(), "6");
		tree.addRight(root.getLeft().getLeft(), "3");
		
		// Print tree
		System.out.println("\nVISUALIZATION");
		int space = 0;
		tree.visualize(root, space);
		
		// Test print function
		System.out.println("\nPREORDER--------");
		tree.preorderPrint(root);
		
		System.out.println("\nPOSTORDER---------");
		tree.postorderPrint(root);
		
		System.out.println("\nINORDER---------");
		tree.inorderPrint(root);
		System.out.println();
		
		// Expression: (((6/3)+2)*(7-4))
		double result = compute(root);
		System.out.println("\n\nResult of arithmetic expression: " + result);
	}
}
