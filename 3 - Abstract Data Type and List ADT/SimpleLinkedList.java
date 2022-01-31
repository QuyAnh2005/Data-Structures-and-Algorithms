package AbstractDataTypeandListADT;

public class SimpleLinkedList<T> {
	
	class Node {
		
		T data;
		Node next;
		
		// Be used for print element in linked list
		public String toString() {
	        return data.toString();
	    }
	}
	
	private Node top = null;
	private Node bot = null;
	private int n = 0;
	
	public void add(T data) {
		// Insert node at the starting of linked list
		Node newNode = new Node();
		newNode.data = data;
		newNode.next = top;
		
		// Assign top again
		top = newNode;
		
		// Increment size to 1
		this.n += 1;
	}
	
	public void addBot(T data) {
		// Insert node at the ending of linked list
		
		// Using head element to go through all elements in linked array
		Node current = this.top;	
		// Loop until current.next is null that meaning the current is last element
		while (current.next != null) {
			current = current.next;
		}
		
		// Insert last list
		
		// Create new node that presenting for new bottom, meaning that next of new node is null
		Node newNode = new Node();
		newNode.data = data;
		newNode.next = null;		
		// Point now bot to new node
		current.next = newNode;
		// Assign new bot is new node
		bot = newNode;
		
		// Increment size to 1
		this.n = this.n + 1;
	}
	
	public T get(int i) {
		// Take data of element at i-th position in linked list	
		Node current = top;	
		// Loop from top element until i-th element, then stop
		for (int idx=0; idx<i; idx++) {
			current = current.next;
		}	
		return current.data;
	}
	
	public void set(int i, T data){
		// Assign the value of element at i-th position by "data"
		Node current = top;	
		// Loop from top element until i-th element, then stop
		for (int idx=0; idx<i; idx++) {
			current = current.next;
		}
		// Set value of i-th element equals to "data"
		current.data = data;
	}
	
	public boolean isContain(T data) {
		// Check whether "data" is in linked list or not
		// If top element is "data", linked list contains "data"
		Node current = this.top;	
		if (current.data != data) return true;
		// if not, go through all elements and check
		while (current.next != null) {
			current = current.next;    // Move to next element
			if (current.data != data) return true;
		}
		// all elements is not same as "data", then return false
		return false;
	}
	
	public int size() {
		// Return the length of linked list
		return this.n;
	}
	
	public boolean isEmpty() {
		// Check whether linked list is empty of not
		return (this.top == null);
	}
	
	public T removeTop() {
		// Remove element at the head of linked list, return value of that element
		
		// If list is empty, we don't need to remove any element
		if (this.isEmpty()) return null;
		
		// List only has one element-head element (length equal to 1), we will remove it by assigning 
		// head is null. However, we need to return data of removed element. Creating variable to save "data"
		// of head element (removed element) is needed
		if (this.size() == 1) {
			// Create matrix variable to save "data" of head element
			T data = this.top.data;
			// Remove head element
			this.top = null;
			// Update length of linked list after remove one element
			this.n -= 1;
			// Return value of head element
			return data;
		}
		
		// Linked list has more than one element
		Node oldTop = this.top;   // Create matrix variable to save old head of linked list
		// Move head cursor to next element, because head element is removed
		this.top = this.top.next;
		// Update length of linked list
		this.n -= 1;
		// Return value of head element
		return oldTop.data;
	}
	
	public T removeBot() {
		// Remove element at the tail of linked list, return value of that element
		
		// If list is empty (meaning head element is null), we don't need to remove any element		
		if (top == null) return null;
		
		// List only has one element. Head element is also tail element, we will remove it by assigning 
		// head is null. However, we need to return data of removed element. Creating variable to save "data"
		// of head element (removed element) is needed
		if (top.next == null) {
			// Create matrix variable to save "data" of head element
			T data = this.top.data;
			// Remove head element
			this.top = null;
			// Update length of linked list after remove one element
			this.n -= 1;
			// Return value of head element
			return data;
		}
		
		// Find second last
		Node secondLast = top;
		while (secondLast.next.next != null) secondLast = secondLast.next;
		
		// Save value of tail and assign null
		Node last = secondLast.next;
		secondLast.next = null;    // Set new tail is second last elemet
		
		// Update length after remove one element
		this.n -= 1;
		
		return last.data;
	}
	
	public void remove(T data) {
		// Remove all elements that their value are "data"
		// Store head node
        Node temp = this.top, prev = null;
        
        // If head node itself holds the "data" or multiple occurrences 
        while (temp != null && temp.data == data){
            top = temp.next; // Changed head
            temp = top; // Change temp
            
            // Decrease size to 1
            this.n -= 1;
        }
		
        // Delete occurrences other than head
        while (temp != null){
            // Search for the node that having "data" to be deleted, keep track of the previous node
            // as we need to change from "prev" to "next"
            while (temp != null && temp.data != data) {
                prev = temp;
                temp = temp.next;
            }
            
            // If "data" was not present in linked list
            if (temp == null)
                return;
            // Unlink the node from linked list
            prev.next = temp.next;
            // Update temp for next iteration of outer loop
            temp = prev.next;
            
            // Decrease size to 1
            this.n -= 1;
        }
	}
	
	// For printing Linked List
    public String toString() {
    	String message = " ";
        Node current = top;
        while (current != null) {
            message += current.toString() + ", ";
            current = current.next;
        }
        return message;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimpleLinkedList<String> linkedList = new SimpleLinkedList<>();
		
		System.out.println("Size of original linked list: " + linkedList.size());
		
		// Add elements at head of linked list
		linkedList.add("Anh");
		linkedList.add("Quy");
		linkedList.add("Dang");
		linkedList.add("Quy");
		linkedList.add("Quys");
		linkedList.add("Quy");	
		System.out.println("\nSTATUS NOW");
		System.out.println("Linked list: " + linkedList.toString() );
		System.out.println("Size: " + linkedList.size());
		
		// Add element at tail of linked list
		System.out.println("\nADD BOTTOM METHOD");
		linkedList.addBot("AAnh");
		System.out.println("Linked list: " + linkedList.toString() );
		System.out.println("Size: " + linkedList.size());
		
		// Remove one element at top
		System.out.println("\nREMOVE TOP");
		System.out.println("Element is removed: " + linkedList.removeTop().toString());
		System.out.println("Linked list: " + linkedList.toString() );
		System.out.println("Size: " + linkedList.size());
		
		// Remove one element at bottom
		System.out.println("\nREMOVE BOTTOM");
		System.out.println("Element is removed: " + linkedList.removeBot().toString());
		System.out.println("Linked list: " + linkedList.toString() );
		System.out.println("Size: " + linkedList.size());
		
		// Get element at i-th position
		System.out.println("\nGET ELEMENY AT ANY POSITION");
		System.out.println("Get second element in linked list: " + linkedList.get(1).toString());
		
		// Set value at i-th position
		System.out.println("\nSET VALUE ELEMENT IN LINKED LIST");
		linkedList.set(0, "Quy");
		System.out.println("Linked list: " + linkedList.toString() );
		System.out.println("Size: " + linkedList.size());
		
		// Remove all elements is "data"
		System.out.println("\nREMOVE ALL");
		System.out.println("Remove all 'Quy' in linked list: ");
		linkedList.remove("Quy");
		System.out.println("Linked list: " + linkedList.toString() );
		System.out.println("Size: " + linkedList.size());
	}

}
