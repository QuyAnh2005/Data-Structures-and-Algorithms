package TreeADT;

import TreeADT.LinkedBinaryTree.Node;

public interface BinaryTreeInterface<T> {
	T root(); 
	
	int size(); // number of node in tree
	boolean isEmpty();
	int numChildren(T p); // number of children of element p;
	
	T parent(T p); //return parent of p
	T left(T p); //return left child of p
	T right(T p); //return right child of p
	T sibling(T p); //return sibling of p

}
