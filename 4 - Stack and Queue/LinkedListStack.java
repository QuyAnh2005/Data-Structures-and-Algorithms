package StackAndQueue;

import java.util.Iterator;

public class LinkedListStack<E> implements StackInterface<E> {

	class Node {
		E element;
		Node next;
		
		// Be used for print element in linked list
		public String toString() {
	        return element.toString();
	    }
	}
	
	private Node stack = null;
	private int topIndex = -1;
	
	// Return the number of elements in matrix stack
	public int size() {
		return topIndex + 1;
	}

	@Override
	public void push(E element) {
		Node newStack = new Node();
		newStack.element = element;
		newStack.next = stack; 
		
		// Assign top again
		stack = newStack;
		
		// Increment size to 1
		topIndex ++;
		
	}

	@Override
	public E pop() {
		if (this.isEmpty()) return null;
		
		// List only has one element-head element (length equal to 1), we will remove it by assigning 
		// head is null. However, we need to return data of removed element. Creating variable to save "data"
		// of head element (removed element) is needed
		if (this.size() == 1) {
			// Create matrix variable to save "data" of head element
			E element = stack.element;
			// Remove head element
			this.stack = null;
			// Update length of linked list after remove one element
			topIndex--;
			// Return value of head element
			return element;
		}
		
		// Linked list has more than one element
		Node oldTop = this.stack;   // Create matrix variable to save old head of linked list
		// Move head cursor to next element, because head element is removed
		this.stack = this.stack.next;
		// Update length of linked list
		topIndex--;
		// Return value of head element
		return oldTop.element;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return topIndex == -1;
	}

	@Override
	public E top() {
		// TODO Auto-generated method stub
		return stack.element;
	}
	
	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return new StackIterator();
	}
	
	class StackIterator implements Iterator<E> {
		private Node currentNode = stack;

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return currentNode != null;
		}
		
		@Override
		public E next() {
			// TODO Auto-generated method stub
			E element = currentNode.element;
			currentNode = currentNode.next;
			return element;
		}
	}
	
	public String toString() {
		String content = " ";
        Node current = stack;
        while (current != null) {
            content += current.toString() + " ";
            current = current.next;
        }
        return content;
	}
	
	public void checkStack() {
		System.out.println("Stack now: " + toString());
		System.out.println("Size: " + size());
	}
	
	public static void main(String[] args) {
		LinkedListStack<String> stack = new LinkedListStack<>();
		
		// Stack is empty
		System.out.println("ORIGINAL STACK");
		stack.checkStack();
		
		// Add elements in stack
		System.out.println("\nADD ELEMENTS IN STACK");
		stack.push("I");
		stack.push("love");
		stack.push("you");
		stack.push("so");
		stack.push("much");
		
		// Check stack
		System.out.println("\nSTACK AFTER ADDING");
		stack.checkStack();
		
		// Check top() method
		System.out.println("\nTOP METHOD");
		System.out.println(stack.top());
		
		// Check pop() method
		System.out.println("\nPOP() METHOD");
		String removedElement = stack.pop();
		System.out.println("Stack removed: " + removedElement);
		stack.checkStack();
		
			
		// Check iterator method
		System.out.println("\nITERATOR METHOD");
		Iterator iter = stack.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
	}

}
