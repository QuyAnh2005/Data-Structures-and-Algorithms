package StackAndQueue;

import java.util.Iterator;

public class ArrayStack<E> implements StackInterface<E> {
	
	public static final int CAPACITY=1000;
	private E[] data;
	private int topIndex = -1;
	
	public ArrayStack() {
		// TODO Auto-generated constructor stub
		data = (E[]) new Object[this.CAPACITY];
	}
	
	public ArrayStack(int capacity) {
		// TODO Auto-generated constructor stub
		data = (E[]) new Object[capacity];
	}
	
	// Return the number of elements in matrix stack
	public int size() {
		return topIndex + 1;
	}

	@Override
	public void push(E element) throws IllegalStateException{
		// Add an element in matrix stack
		// Check whether stack is full or not
		if (size() == data.length) throw new IllegalStateException("Stack is full");
		// else
		data[++topIndex] = element;    // increment index before storing new item
		
	}

	@Override
	public E pop() {
		// Removes and returns the top element from the stack
		if (isEmpty()) return null;
		E removedElement = data[topIndex];
		data[topIndex] = null;
		topIndex --;
		return removedElement;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return topIndex == -1;
	}

	@Override
	public E top() {
		// Returns, but does not remove, the element at the top
		if (isEmpty()) return null;
		return data[topIndex];
	}
	
	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return new StackIterator();
	}
	
	class StackIterator implements Iterator<E> {
		
		private int cursor = -1;

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return data[++cursor] != null;
		}

		@Override
		public E next() {
			// TODO Auto-generated method stub
			E element = data[cursor];
//			cursor ++;
			return element;
		}
		
	}
	
	public String toString() {
		String content = " ";
		for (int i=0; i<size(); i++) {
			content += data[i].toString() + " ";
		}
		return content;
	}
	
	public void checkStack() {
		System.out.println("Stack now: " + toString());
		System.out.println("Size: " + size());
	}
	
	public static void main(String[] args) {
		ArrayStack<String> stack = new ArrayStack<>();
		
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
