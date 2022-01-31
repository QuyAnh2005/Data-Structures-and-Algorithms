package StackAndQueue;

import java.util.Iterator;

import StackAndQueue.LinkedListStack.Node;

public class LinkedListQueue<E> implements QueueInterface<E> {
	
	class Node {
		E data;
		Node next;
		
		// Be used for print element in linked list
		public String toString() {
	        return data.toString();
	    }
	}
	
	private Node head = null;
	private Node tail = null;
	private int size = -1;
	
	public LinkedListQueue() {
		// TODO Auto-generated constructor stub
	}
	
	public int size() {
		return size + 1;
	}
	

	@Override
	public void enqueue(E element) {
		Node newNode = new Node();
		newNode.data = element;
		newNode.next = null;
		
		// If queue is empty, new node is both head and tail
		if (head == null) {
			head = tail = newNode;
		}
		
		// queue has more one node, add new node at tail of queue
		tail.next = newNode;
		tail = newNode;
		
		size ++;
		
	}

	@Override
	public E dequeue() {
		// If queue is empty, return null
		if (head == null) return null;
		
		// Remove head element, assign head for queue
		Node removedNode = head;
		head = head.next;
		
		// After remove head element, new head is null
		if (head == null) tail = null;
		
		size--;
		
		return head.data;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return head == null;
	}
	
	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return new Queueterator();
	}
	
	class Queueterator implements Iterator<E> {
		private Node currentNode = head;

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return currentNode != null;
		}
		
		@Override
		public E next() {
			// TODO Auto-generated method stub
			E element = currentNode.data;
			currentNode = currentNode.next;
			return element;
		}
	}
	
	public String toString() {
		String content = " ";
        Node current = head;
        while (current != null) {
            content += current.toString() + " ";
            current = current.next;
        }
        return content;
	}
	
	public void status() {
		System.out.println("Queue: " + toString());
		System.out.println("Size: " + size());
	}
	
	public static void main(String[] args) {
		LinkedListQueue<String> queue = new LinkedListQueue<>();
		
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
		System.out.println("First element: " + queue.head);
		queue.dequeue();
		queue.status();
		
		// Test iterator
		System.out.println("\nITERATOR FOR QUEUE");
		Iterator iter = queue.iterator();
		while (iter.hasNext()) System.out.println(iter.next());
	}
	
}
