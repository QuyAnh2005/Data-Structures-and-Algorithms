package PriorityQueue.Exercise1;

public class Test {
	
	public static void testInt(int sign) {
		PriorityQueueInterface<Integer,Integer> priorityQ;
		
		if (sign == 0) {
			priorityQ = new UnsortedArrayPriorityQueue<Integer, Integer>(); 
		} else if (sign == 1) {
			priorityQ = new SortedArrayPriorityQueue<Integer, Integer>(); 
		} else if (sign == 2) {
			priorityQ = new UnsortedLinkedPriorityQueue<>();
		} else if (sign == 3) {
			priorityQ = new SortedLinkedPriorityQueue<>(); 
		} else throw new IllegalArgumentException("Not valid!");
		
		System.out.println(priorityQ.getClass().getSimpleName().toUpperCase());
		
		// Check whether priority queue is empty or not
		System.out.println("Priority Queue is empty? " + priorityQ.isEmpty());		
		// Adding data
		System.out.println("\nADDING DATA ...");
		priorityQ.insert(70, 70);
		priorityQ.insert(90, 90);
		priorityQ.insert(95, 95);
		priorityQ.insert(85, 85);		
		// Check functions
		System.out.println("\nPRIORY QUEUE: \n" + priorityQ.toString());
		System.out.println("\nREMOVE MIN ELEMENT IN PQ:");
		Entry removed = priorityQ.removeMin();
		System.out.println("Removed: " + removed.toString());
		System.out.println("\nPRIORY QUEUE NOW: \n" + priorityQ.toString());
	}
	
	public static void testObject(int sign) {
		PriorityQueueInterface<Integer,String> priorityQ;
		
		if (sign == 0) {
			priorityQ = new UnsortedArrayPriorityQueue<>(); 
		} else if (sign == 1) {
			priorityQ = new SortedArrayPriorityQueue<>(); 
		} else if (sign == 2) {
			priorityQ = new UnsortedLinkedPriorityQueue<>();
		} else if (sign == 3) {
			priorityQ = new SortedLinkedPriorityQueue<>(); 
		} else throw new IllegalArgumentException("Not valid!");
		
		System.out.println(priorityQ.getClass().getSimpleName().toUpperCase());
		
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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numAlgo = 4;
		
		for (int i=0; i<numAlgo; i++) {
			testInt(i);
			System.out.println("-----------------------------------");
		}
		
		for (int i=0; i<numAlgo; i++) {
			testObject(i);
			System.out.println("-----------------------------------");
		}
		
		
	}

}
