package PriorityQueue.Exercise1;

public class SortedLinkedPriorityQueue<K extends Comparable, E> implements PriorityQueueInterface<K, E> {
	
	protected class NodeEntry<K, E> implements Entry<K, E>{
		private K key;
		private E element;
		private NodeEntry<K, E> next;
		
		public NodeEntry(K k, E e) {
			this.key = k;
			this.element = e;
			this.next = null;
		}
		
		public K getKey() {return this.key;}
		public E getValue() {return this.element;}
		public NodeEntry<K, E> getNext() { return next;}
		public void setNext(NodeEntry<K, E> next) {this.next = next;}
		
		public String toString() {
			return String.format("Key: %s - Element: %s\n", key.toString(), element.toString());
		}
	}
	
	private NodeEntry<K, E> head;
	private NodeEntry<K, E> tail;
	int n = 0;
		
	@Override
	public int size() { return n;}
	@Override
	public boolean isEmpty() { return n==0;}

	@Override
	public void insert(Entry<K, E> entry) {
		NodeEntry newNode = (NodeEntry) entry;
		if (head == null || head.getKey().compareTo(newNode.getKey()) >= 0) {
			newNode.next = head;
			head = newNode;
		} else {
			NodeEntry current = head;
			while ((current.next != null) && (((Comparable) current.next.getKey()).compareTo(newNode.getKey()) < 0)) 
				current = current.next;
			newNode.next = current.next;
			current.next = newNode;
		}
		n++;
	}

	@Override
	public void insert(K k, E e) {
		Entry newNode = new NodeEntry<K, E>(k, e);
		this.insert(newNode);	
	}

	@Override
	public Entry<K, E> removeMin() {
		Entry min = this.min();
		if (this.isEmpty()) throw new IllegalArgumentException("Priority queue is empty!");
		if (this.size() == 1) {
			this.head = null;
			return min;
			}
		head = head.next;
		n--;
		return min;
	}

	@Override
	public Entry<K, E> min() {return this.head;}
	
	public String toString() {
		String content = "";
        NodeEntry current = head;
        while (current != null) {
            content += current.toString();
            current = current.next;
        }
        return content;
	}
	
	public static void main(String[] args) {
		SortedLinkedPriorityQueue<Integer, String> priorityQ = new SortedLinkedPriorityQueue<>();
		
		// Check whether priority queue is empty or not
		System.out.println("Priority Queue is empty? " + priorityQ.isEmpty());
		
		// Adding data
		System.out.println("\nADDING DATA ...");
		priorityQ.insert(70, "Hoang");
		priorityQ.insert(90, "Anh");
		priorityQ.insert(95, "Tung");
		priorityQ.insert(85, "Hung");
		
		// Check functions
		System.out.println("\nPRIORY QUEUE: \n" + priorityQ.toString());
		
		System.out.println("\nREMOVE MIN ELEMENT IN PQ:");
		Entry removed = priorityQ.removeMin();
		System.out.println("Removed: " + removed.toString());

		System.out.println("\nPRIORY QUEUE NOW: \n" + priorityQ.toString());
		
	}

}
