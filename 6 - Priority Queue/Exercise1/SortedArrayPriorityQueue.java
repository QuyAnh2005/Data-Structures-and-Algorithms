package PriorityQueue.Exercise1;

public class SortedArrayPriorityQueue<K extends Comparable<K>, E> implements PriorityQueueInterface<K,E> {

	protected class ArrEntry<K, E> implements Entry<K,E> {
		K key;
		E element;
		
		public ArrEntry (K k, E e){
			 this.key = k;
			 this.element = e;
		}
		
		@Override
		public K getKey() { return this.key;}
		public void setKey(K key) {this.key = key;}
		@Override
		public E getValue() { return this.element;}
		public void setValue (E element) {this.element = element;}

		public String toString() {
			return String.format("Key: %s - Element: %s\n", key.toString(), element.toString());
		}
	}
	
	Entry<K, E> [] array;
	int n = 0;
	int defaultsize = 1000;
	int head = 0;
	
	public SortedArrayPriorityQueue () { array = (Entry<K, E>[]) new ArrEntry[defaultsize];}
	public SortedArrayPriorityQueue (int capacity) { array = (Entry<K, E>[]) new ArrEntry[capacity];}
	
	@Override
	public int size() { return n;}
	@Override
	public boolean isEmpty() { return n==0;}
	@Override
	public void insert(Entry entry) { 
		int position = (head + n) % array.length;
		int positionOrd = n;
		// Find position of added data
		for (int i=0; i<n; i++) {
			int index = (head + i) % array.length; 
			if (array[index].getKey().compareTo((K) entry.getKey()) == 1) {
				position = index;
				positionOrd = i;
				break;
			} 
		}
	
		int size = n;
		while (size > positionOrd) {
			int index = (head + size) % array.length;
			int preInd = (head + size - 1) % array.length;
			array[index] = array[preInd];
			size--;
		}
		array[position] = entry;
		n++;
	}

	@Override
	public void insert(K k, E e) {
		Entry data = new ArrEntry(k, e);
		this.insert(data);
	}

	@Override
	public Entry removeMin() {
		Entry min = array[head];
		array[head] = null;
		head++;
		n--;
		return min;
	}

	@Override
	public Entry min() {
		return array[head];
	}
	
	public String toString() {
		String content = "";
		for (int i=0; i<n; i++) {
			int index = (head + i) % array.length;
			content += array[index].toString();
		}
		return content;
	}
	
	public static void main(String[] args) {
		SortedArrayPriorityQueue<Integer, String> priorityQ = new SortedArrayPriorityQueue<>();
		
		// Check whether priority queue is empty or not
		System.out.println("Priority Queue is empty? " + priorityQ.isEmpty());
		
		// Adding data
		System.out.println("\nADDING DATA ...");
		priorityQ.insert(90, "Anh");
		priorityQ.insert(95, "Tung");
		priorityQ.insert(85, "Hung");
		priorityQ.insert(70, "Hoang");
		priorityQ.insert(86, "Hoangg");
		
		// Check functions
		System.out.println("\nPRIORY QUEUE: \n" + priorityQ.toString());
		
		System.out.println("\nREMOVE MIN ELEMENT IN PQ:");
		Entry removed = priorityQ.removeMin();
		System.out.println("Removed: " + removed.toString());
		
		System.out.println("\nPRIORY QUEUE NOW: \n" + priorityQ.toString());
	}
	
}
