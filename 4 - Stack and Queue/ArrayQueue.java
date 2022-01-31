package StackAndQueue;

import java.util.Iterator;

public class ArrayQueue<E> implements QueueInterface<E> {

	private E[] queue;
	private int n = 0;
	private int top = 0;
	private int count = 0;
	private int default_size = 100;
	
	public ArrayQueue(int capacity) {
		n = capacity;
		queue = (E[]) new Object[capacity];
	}
	
	public ArrayQueue() {
		n = default_size;
		queue = (E[]) new Object[default_size];
	}
	
	public int size() {
		return count;
	}

	@Override
	public void enqueue(E element) throws IllegalStateException{
		// TODO Auto-generated method stub
		if (size() == queue.length) throw new IllegalStateException("Queue is full");
		int botIndex = (top + size()) % queue.length;
		queue[botIndex] = element;
		count++;
	}

	@Override
	public E dequeue() {
		// TODO Auto-generated method stub
		if (isEmpty()) return null;
		E removeElement = queue[top];
		queue[top] = null;
		top = (top + 1) % queue.length;
		count--;
		return removeElement;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return count == 0;
	}
	
	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return new ArrayQueueIterator();
	}
	
	class ArrayQueueIterator implements Iterator<E> {
		
		private int current = top;
		private int num = 0;

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return num < count;
		}
		
		@Override
		public E next() {
			// TODO Auto-generated method stub
			E data = queue[(current + num) % n];
			num++;
			return data;
		}
	}
	
	public String toString() {
		String content = "";
		for (int i=top; i< top+size(); i++) content += queue[i].toString() + " ";
		return content;
	}
	
	public void status() {
		System.out.println("Size: " + size());
		System.out.println("Queue: " + toString());
	}
	
	public static void main(String[] args) {
		ArrayQueue<String> queue = new ArrayQueue<>();
		
		// Original queue
		System.out.println("ORIGINAL QUEUE");
		queue.status();
		
		// Adding element
		System.out.println("\nADDING ELEMENTS");
		queue.enqueue("I");
		queue.enqueue("love");
		queue.enqueue("you");
		queue.enqueue("so");
		queue.enqueue("much");
		
		// Check queue now
		System.out.println("\nQUEUE AFTER ADDING");
		queue.status();
		
		// Test dequeue method
		System.out.println("\nREMOVING FIRST ELEMENT OF QUEUE");
		System.out.println("First element: " + queue.top);
		queue.dequeue();
		queue.status();
		
		// Test iterator
		System.out.println("\nITERATOR FOR QUEUE");
		Iterator iter = queue.iterator();
		while (iter.hasNext()) System.out.println(iter.next());
	}

}
