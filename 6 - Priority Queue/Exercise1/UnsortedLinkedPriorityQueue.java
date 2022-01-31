package PriorityQueue.Exercise1;

public class UnsortedLinkedPriorityQueue<K extends Comparable, E> implements PriorityQueueInterface<K, E> {
	
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
		newNode.setNext(head);
		head = newNode;
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
		if (min == null) throw new IllegalArgumentException("Priority Queue is empty!");
		if (min == head) {
			NodeEntry temp = head.next;
			head = temp;
			return head;
		}
		
		NodeEntry current = head;
		while (current.next != null) {
			if (current.next == min) {
				NodeEntry node = current.next.next;
				current.next = node;
				break;
			}
			current = current.next;
		}
		return min;
	}

	@Override
	public Entry<K, E> min() {
		if (isEmpty()) return null;
		Entry min = this.head;
		NodeEntry<K, E> current = head.next;
		while (current != null) {
			if (((Comparable) min.getKey()).compareTo(current.getKey()) == 1) min = current;
			current = current.next;
		}
		return min;
	}
	
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
		UnsortedLinkedPriorityQueue<Integer, String> priorityQ = new UnsortedLinkedPriorityQueue<>();
		
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
		
		System.out.println("\nREMOVE MIN ELEMENT IN PQ: \n");
		Entry removed = priorityQ.removeMin();
		System.out.println("\nRemoved: " + removed.toString());

		System.out.println("\nPRIORY QUEUE NOW: \n" + priorityQ.toString());
	}

}
