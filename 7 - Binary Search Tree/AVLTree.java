package BinarySearchTree;

import java.util.ArrayList;

public class AVLTree<E extends Comparable<E>, T> extends BinarySearchTree<E, T> {
//	Node root;
	int size=0;
	
	public AVLTree() {super();}
	public boolean isEmpty() {return size==0;}
	
	public Node<E> rightRotation(Node<E> y) {
		Node<E> x = y.left;
        Node<E> T2 = x.right;
 
        // Perform rotation
        x.right = y;
        y.left = T2;
 
        // Update heights
        y.height = getMax(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = getMax(getHeight(x.left), getHeight(x.right)) + 1;
 
        // Return new root
        return x;
	}
	
	public Node<E> leftRotation(Node<E> x) {
        Node<E> y = x.right;
        Node<E> T2 = y.left;
 
        // Perform rotation
        y.left = x;
        x.right = T2;
 
        //  Update heights
        x.height = getMax(getHeight(x.left), getHeight(x.right)) + 1;
        y.height = getMax(getHeight(y.left), getHeight(y.right)) + 1;
 
        // Return new root
        return y;
    }
	
	// Get Balance factor of node 
    public int getBalance(Node<E> node) {
        if (node == null) return 0;
        return getHeight(node.left) - getHeight(node.right);
    }
    
    public Node<E> search(E x) {return super.search(x, this.root);}
    
    @ Override
	public void insert(E key) { 
		root = this.insert(key, root);
		size++;
	} 
    
	@ Override
    public Node<E> insert(E key, Node<E> node) {
    	node = super.insert(key, node);
        return this.rebalance(node);
    }
    
    public void delete(E key) { 
    	root = delete(key, root);
    	size--;
    }
    
    public Node<E> delete (E key, Node<E> root) {
    	root = super.delete(key, root);
        return this.rebalance(root);	
    }
    
    public Node<E> rebalance(Node<E> node) {
    	int balance = getBalance(node);
        // If this node becomes unbalanced, then there are 4 cases
        // Left Left Case
        if (balance > 1 && getBalance(node.left) >= 0) return rightRotation(node);
        // Left Right Case
        if (balance > 1 && getBalance(node.left) < 0){
            node.left = leftRotation(node.left);
            return rightRotation(node);
        }
        // Right Right Case
        if (balance < -1 && getBalance(node.right) <= 0) return leftRotation(node);
        // Right Left Case
        if (balance < -1 && getBalance(node.right) > 0){
            node.right = rightRotation(node.right);
            return leftRotation(node);
        }    
        return node;
    }
    
    public void preOrder(Node<E> node) {
        if (node != null) {
            preOrder(node.left);
            System.out.println("Node: " + node.element + " -Height: " + getHeight(node));
            preOrder(node.right);
        }
    }
    
    public void toSort(Node<E> node, ArrayList<E> nodeList) {
        if (node != null) {
            toSort(node.left, nodeList);
            nodeList.add(node.element);
            toSort(node.right, nodeList);
        }
    }
    
    public ArrayList<E> toSort(){
    	ArrayList<E> nodeList = new ArrayList<E>();
    	this.toSort(root, nodeList);
		return nodeList;
    }
    
    public static void main(String args[]) {
    	
		AVLTree<Integer, Node<Integer>> tree = new AVLTree<>();
		for (int i=0; i<30; i+=1) tree.insert(i);
		for (int i=0; i<28; i+=2) tree.delete(i);
		tree.visualize(tree.root, COUNT);
		System.out.println(tree.root);
		System.out.println("Size: " + tree.size);
		System.out.println("Min: " + tree.findMin(tree.root));
		System.out.println(tree.search(7).height);
		System.out.println(tree.root.height);
		
	}
}
