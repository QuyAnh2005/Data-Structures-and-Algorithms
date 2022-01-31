package BinarySearchTree;

import java.io.FileWriter;
import java.io.IOException;

public class LinkedBinaryTree<E extends Comparable<E>, T> implements BinaryTreeInterface<T> {
	
	public static class Node<E extends Comparable<E>> {
		int height; // Chiều cao của cây được tính từ nút lá lên
		E element; // an element stored at this node
		Node<E> parent; // matrix reference to the parent node (if any)
		Node<E> left; // matrix reference to the left child
		Node<E> right; // matrix reference to the right child
		
		// Constructs matrix node with the given element and neighbors. ∗/
		public Node(E e, Node<E> above, Node<E> leftChild, Node<E> rightChild){
			this.element = e;
			this.parent = above;
			this.left = leftChild;
			this.right = rightChild;
			this.height = 0;
		}
		
		// Constructs matrix node with the given element and neighbors. ∗/
		public Node(E e){
			this.element = e;
			this.height = 1;
		}
		
		public String toString() {
			return element.toString();
		}

		public E getElement() {
			return element;
		}

		public void setElement(E element) {
			this.element = element;
		}
		
	}
	
	public Node<E> root = null; // root of the tree
	private int size = 0;
	static final int COUNT = 10;
	
	// validate
	public Node<E> validate(Node<E> p) throws IllegalArgumentException {
		Node<E> node = (Node<E>) p;
		if (node.parent == node) throw new IllegalArgumentException("p is not in tree");
		return node;
	}
	
	public Node<E> validate(T p) throws IllegalArgumentException {
		if (!(p instanceof Node)) throw new IllegalArgumentException("Not valid position type");
		Node<E> node = (Node<E>) p;
		if (node.parent == node) throw new IllegalArgumentException("p is not in tree");
		return node;
	}
	
	//update methods
	public Node<E> addRoot(E element) throws IllegalStateException {
		// Add element to root of an empty tree
		if (!isEmpty()) throw new IllegalStateException("Tree is not empty");
		root = new Node(element, null, null, null);
		size = 1;
		return root;
	}
	
	public Node<E> addLeft(Node<E> p, E element) {
		// Add element to left child node of p if empty
		Node<E> parent = this.validate(p);
		if (parent.left != null) throw new IllegalArgumentException("Had left child!");
		Node<E> child = new Node(element, parent, null, null);
		parent.left = child;
		size ++;
		return child;
	}
	
	public Node<E> addRight(Node<E> p, E element) {
		// Add element to right child node of p if empty
		Node<E> parent = this.validate(p);
		if (parent.right != null) throw new IllegalArgumentException("Had left child!");
		Node<E> child = new Node(element, parent, null, null);
		parent.right = child;
		size ++;
		return child;
	}
	
	public void set(Node<E> p, E element) {
		// set element to node p
		Node<E> node = validate(p);
		node.element = element;
	}

	@Override
	public T root() {
		return (T) root;
	}

	@Override
	public int size() {
		return size;
	}
	
	@Override
	public boolean isEmpty() {
		return size == 0;
	}
	
	@Override
	public int numChildren(T p) {
		Node<E> node = validate(p);
		int count = 0;
		if (node.left != null) count++;
		if (node.right != null) count ++;
		return count;
	}
	
	@Override
	public T parent(T p) {
		Node<E> node = validate(p);
		return (T) node.parent;
	}
	
	@Override
	public T left(T p) {
		Node<E> node = validate(p);
		return (T) node.left;
	}
	
	@Override
	public T right(T p) {
		Node<E> node = validate(p);
		return (T) node.right;
	}
	
	@Override
	public T sibling(T p) {
		Node<E> node = validate(p);
		return null;
	}
	
	public void visualize (Node<E> root, int space) {
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
	    System.out.print(root.element + "\n");
	 
	    // Process left child
	    visualize(root.left, space);
	}
	
	// Write to file
	public void writeFile (Node<E> root, int space, FileWriter write) throws IOException {
		// Base case
	    if (root == null)
	        return;
	 
	    // Increase distance between levels
	    space += COUNT;
	 
	    // Process right child first
	    writeFile(root.right, space, write);
	 
	    // Print current node after space count
	    write.write("\n");
	    for (int i = COUNT; i < space; i++)
	        write.write(" ");
	    write.write(root.element + "\n");
	 
	    // Process left child
	    writeFile(root.left, space, write);
	}
}

