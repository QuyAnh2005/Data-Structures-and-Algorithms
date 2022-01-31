package PriorityQueue.Exercise3;

import PriorityQueue.Exercise2.MinHeapPriorityQueue;

public class HeapSort implements SortInterface {
	
	private int[] array;
	MinHeapPriorityQueue<Integer, Integer> priorityQ;
	
	public HeapSort(int[] array) { 
		this.array = array;
		priorityQ = new MinHeapPriorityQueue<>();
		this.buildHeap();
	}
	
	public HeapSort(int[] array, int n) { 
		this.array = array;
		priorityQ = new MinHeapPriorityQueue<>(n);
		this.buildHeap();
	}
	
	public void buildHeap() {
		for (int number: array) {priorityQ.insert(number, number);}
	}
	
	public void sort() {
		for (int i=0; i<array.length; i++) array[i] = (int) priorityQ.removeMin().getKey();
	}
	
	public String toString() {
		String content = "";
		for (int i=0; i<array.length; i++) content += array[i] + ", ";
		return content;
	}
}
