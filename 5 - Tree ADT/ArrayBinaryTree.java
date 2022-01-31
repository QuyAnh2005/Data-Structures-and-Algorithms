package TreeADT;

import java.io.FileWriter;
import java.io.IOException;

public class ArrayBinaryTree<E> implements BinaryTreeInterface<Integer> {
	private E [] array;
	private int n = 0;
	private int defaultsize = 100;
	static final int COUNT = 10;
	
	public ArrayBinaryTree(){
		array = (E[]) new Object[defaultsize];
	} 
	
	public int validate(Integer p) throws IllegalArgumentException {
		int position = (int) p;
		if (position<0 || position>n) throw new IllegalArgumentException("Out of index!");
		return position;
	}
	
	//update methods
	public void setRoot(E element) {
		// Set element to root of an empty tree (at index 1)
		if (!isEmpty()) throw new IllegalArgumentException("Tree is exist");
		n = 1;
		array[1] = element;
	}
	
	public void setLeft(int p, E element) {
		// Set left child of p (at index 2p)
		if (array[p] == null) throw new IllegalArgumentException("Not exist!");
		int index = 2 * p;
		if (index<0 || index>defaultsize) throw new IllegalArgumentException("Out of index!");
		array[index] = element;
		n++;
	}
	
	public void setRight(int p, E element) {
		// Set right child of p (at index 2p+1)
		if (array[p] == null) throw new IllegalArgumentException("Not exist!");
		int index = 2 * p + 1;
		if (index<0 || index>defaultsize) throw new IllegalArgumentException("Out of index!");
		array[index] = element;
		n++;
	}

	@Override
	public Integer root() {
		if (array[1] == null) return null;
		return 1;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return n;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return n == 0;
	}

	@Override
	public int numChildren(Integer p) {
		int count = 0;
		if (this.getLeft(p) != null) count++;
		if (this.getRight(p) != null) count++;
		return count;
	}

	@Override
	public Integer parent(Integer p) {
		if (p == this.root()) throw new IllegalArgumentException("It is root. Not have parent");
		int position = validate(p);
		return position/2;
	}

	@Override
	public Integer left(Integer p) {
		int position = validate(p);
		return 2 * position;
	}

	@Override
	public Integer right(Integer p) {
		// TODO Auto-generated method stub
		int position = validate(p);
		return 2 * position + 1;
	}

	@Override
	public Integer sibling(Integer p) {
		int position = validate(p);
		if (position%2 == 0) return position + 1;
		return position-1;
	}
	
	public E getRoot() {
		return array[this.root()];
	}
	
	public E getParent(int p) {
		return array[this.parent(p)];
	}
	
	public E getLeft(int p) {
		return array[this.left(p)];
	}
	
	public E getRight(int p) {
		return array[this.right(p)];
	}
	
	public E getData(int p) {
		int position = validate(p);
		return array[position];
	}
	
	public void visualize (int root, int space) {
		// Base case
	    if (array[root] == null)
	        return;
	 
	    // Increase distance between levels
	    space += COUNT;
	 
	    // Process right child first
	    visualize(this.right(root), space);
	 
	    // Print current node after space count
	    System.out.print("\n");
	    for (int i = COUNT; i < space; i++)
	        System.out.print(" ");
	    System.out.print(array[root] + "\n");
	 
	    // Process left child
	    visualize(this.left(root), space);
	}
	
	public void writeFile (int root, int space, FileWriter write) throws IOException {
		// Base case
	    if (array[root] == null)
	        return;
	 
	    // Increase distance between levels
	    space += COUNT;
	 
	    // Process right child first
	    writeFile(this.right(root), space, write);
	 
	    // Print current node after space count
	    write.write("\n");
	    for (int i = COUNT; i < space; i++)
	        write.write(" ");
	    write.write(array[root] + "\n");
	 
	    // Process left child
	    writeFile(this.left(root), space, write);
	}
	
	
	public static void main (String[] args) {
		ArrayBinaryTree<String> tree = new ArrayBinaryTree<>();
		
		// Test structure
		System.out.println("Root and size of tree when not initialized!");
		System.out.println(String.format("Root: %d \nSize: %d", tree.root(), tree.size()));
		
		// Creating tree
		System.out.println("\nCREATING TREE ...");
		tree.setRoot("I");
		tree.setLeft(1, "love");
		tree.setRight(1, "you");
		tree.setLeft(3, "so");
		tree.setRight(3, "much");
		tree.setLeft(2, "hi");
		tree.setRight(2, "ho");

		// Print tree
		System.out.println("\nVISUALIZATION");
		int root = tree.root();
		int space = 0;
		tree.visualize(root, space);
		
		// Other functions
		System.out.println("\nTEST SOME FUNCTIONS ...");
		int position = 2;
		System.out.println(String.format("Position: %d - Data: %s", position, tree.getData(position)));
		System.out.println(String.format("Number of child: %d", tree.numChildren(position)));
		System.out.println(String.format("Parent: %s", tree.getParent(position)));
		System.out.println(String.format("Left child: %s", tree.getLeft(position)));
		System.out.println(String.format("Right child: %s", tree.getRight(position)));
		System.out.println(String.format("Sibling: %s", tree.getData(tree.sibling(position))));
		
		// Print to file
		System.out.println("\nWRITING TO FILE ...");
		String fileName = "src/TreeADT/treeToArray.txt";
		try {
			FileWriter myWriter = new FileWriter(fileName);
			tree.writeFile(root, space, myWriter);
			myWriter.close();
			System.out.println("Successfully wrote to the file.");
		} catch (IOException e) {
			System.out.println("An error occurred.");
		    e.printStackTrace();
		}
	}
	
}
