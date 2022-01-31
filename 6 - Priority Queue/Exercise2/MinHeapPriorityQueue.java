package PriorityQueue.Exercise2;

import PriorityQueue.Exercise1.Entry;
import PriorityQueue.Exercise1.SortedArrayPriorityQueue;

public class MinHeapPriorityQueue<K extends Comparable<K>, E> extends SortedArrayPriorityQueue<K, E> {
	
	ArrEntry<K, E> heapPQ[];
	int n = 0;
	int defaultsize = 1000;
	int root = 1;
	
	public MinHeapPriorityQueue() {heapPQ = (ArrEntry<K, E>[]) new ArrEntry[defaultsize];}
	public MinHeapPriorityQueue(int compacity) {heapPQ = (ArrEntry<K, E>[]) new ArrEntry[compacity];}
	
	public int size() {return n;}
	public boolean isEmpty() {return n==0;}
	
	protected void swap(int i, int j) {
		ArrEntry temp = heapPQ[i];
		heapPQ[i] = heapPQ[j];
		heapPQ[j] = temp;
	}
	
	protected void upHeap() {
		int i = this.size();
		while (i > 1 && heapPQ[i/2].getKey().compareTo(heapPQ[i].getKey()) == 1) {
			this.swap(i/2, i);
			i /= 2;
		}
	}
	
	protected void downHeap() {
		int i = 1;
		while (i <= n) {
			if (2*i+1 <= n) 
				if (heapPQ[i].getKey().compareTo(heapPQ[2*i].getKey()) == 1
				|| heapPQ[i].getKey().compareTo(heapPQ[2*i + 1].getKey()) == 1) {
					int j = heapPQ[2*i].getKey().compareTo(heapPQ[2*i+1].getKey()) == -1 ? 2*i : 2*i+1;
					this.swap(i, j);
					i = j;
				} else break;
			else 
				if (2*i <= n) {
					if (heapPQ[i].getKey().compareTo(heapPQ[2*i].getKey()) == 1) this.swap(i, 2*i);
					i = 2*i;
				} else break;
		}
	}
	
	@Override
	public void insert(Entry entry) { 
		heapPQ[++n] = (ArrEntry<K, E>) entry;
		this.upHeap();
	}

	@Override
	public void insert(K k, E e) {
		Entry entry = new ArrEntry(k, e);
//		System.out.println(entry.toString());
		this.insert(entry);
	}

	@Override
	public Entry removeMin() {
		Entry min = this.min();
		heapPQ[1] = heapPQ[n--];
		this.downHeap();
		return min;
	}

	@Override
	public Entry min() {
		return heapPQ[root];
	}
	
	public String toString() {
		String content = "";
		for (int i=1; i<=n; i++) content += heapPQ[i].toString();
		return content;
	}
	
	public static void main(String[] args) {
		MinHeapPriorityQueue<Integer, String> priorityQ = new MinHeapPriorityQueue<>();
		
		// Check whether priority queue is empty or not
		System.out.println("Priority Queue is empty? " + priorityQ.isEmpty());
		
		// Adding data
		System.out.println("\nADDING DATA ...");
		priorityQ.insert(90, "Anh");
		priorityQ.insert(95, "Tung");
		priorityQ.insert(85, "Hung");
		priorityQ.insert(70, "Hoang");
		priorityQ.insert(86, "Hoangg");
		priorityQ.insert(100, "Hoa");
		
		// Check functions
		System.out.println("\nPRIORY QUEUE: \n" + priorityQ.toString());
		
		System.out.println("\nREMOVE MIN ELEMENT IN PQ:");
		Entry removed = priorityQ.removeMin();
		System.out.println("Removed: " + removed.toString());
		
		System.out.println("\nPRIORY QUEUE NOW: \n" + priorityQ.toString());
		System.out.println(priorityQ.size());
	}
}
