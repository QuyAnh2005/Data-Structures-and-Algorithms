package BinarySearchTree;

public class BinarySearchTree<E extends Comparable<E>, T> extends LinkedBinaryTree<E, T> {
	
	public Node<E> root; // root of the tree 
	private int size = 0;
	
	public BinarySearchTree() { root=null;}
	
	public boolean isEmpty() {return size==0;}
	
	public int getHeight(Node<E> node) {
		if (node == null) return 0;
		return node.height;
	}
	
	public int getMax(int numberThis, int numberThat) {return Math.max(numberThis, numberThat);}
	
	public void findMin() { this.findMin(this.root);}
	
	public E findMin(Node<E> root) {
		Node<E> current = root;
		while (current.left != null) current = current.left;
		return current.element;
	}
	
	public Node<E> search(E x) {return search(x, this.root);}
	
	public Node<E> search(E x, Node<E> root) {
		if (root == null || x.compareTo(root.element) == 0) return root;
		else if (x.compareTo(root.element) <= -1) return search(x, root.left);
		else return search(x, root.right);
	}
	
	public void insert(E x) { 
		root = this.insert(x, root);
		size++;
	} 

	public Node<E> insert(E x, Node<E> root) {
		if (root == null) return new Node(x);
		else if (x.compareTo(root.element) == -1) root.left = insert(x, root.left);
		else if (x.compareTo(root.element) == 1) root.right = insert(x, root.right);
		else throw new IllegalArgumentException("Element is already in tree!");
		root.height = getMax(getHeight(root.left), getHeight(root.right)) + 1;
		return root;
	}
	
	public void delete(E x) { 
		root = delete(x, root);
		size--;
	}
	
	public Node<E> delete(E x, Node<E> root) {
		if (this.numChildren((T) root) == 0) {
			// Node không có con nào
			if (x.compareTo(root.element) == 0) { return null;}
			else throw new IllegalArgumentException("Element is not in tree!");
		} else if (this.numChildren((T) root) == 1 && root.left != null) {
			// Node có một con và là con trái
			if (x.compareTo(root.element) == 0) { return root.left;}
			else root.left = delete(x, root.left);
		} else if (this.numChildren((T) root) == 1 && root.right != null) {
			// Node có một con và là con phải
			if (x.compareTo(root.element) == 0) { return root.right;}
			else root.right = delete(x, root.right);
		} else {
			// Node có cả hai con
			if (x.compareTo(root.element) == 0) {
				root.element = this.findMin(root.right);
				root.right = delete(root.element, root.right);
			} else if ( x.compareTo(root.element) == -1) root.left = delete(x, root.left);
			else root.right = delete(x, root.right);
		}
		root.height = getMax(getHeight(root.left), getHeight(root.right)) + 1;
		return root;
	}
}