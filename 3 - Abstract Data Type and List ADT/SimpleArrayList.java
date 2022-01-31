package AbstractDataTypeandListADT;

import java.util.Iterator;

public class SimpleArrayList<T> implements ListInterface<T> {
	
	private T[] array;
	private int n = 0;    // initial size of array list
	private int defaultSize = 100;
	
	public SimpleArrayList() {
		array = (T[]) new Object[defaultSize];
	}

	public SimpleArrayList(int capacity) {
		// Hàm dựng với kích thước mảng là capacity
		array = (T[]) new Object[capacity];
	}
	
	public void add(T data) {
		// We have an array list with 5 elements, but the order of elements is 0, 1, 2, 3, 4.
		// That means the added element is at 5-th 
		int now_size = this.size();
		this.array[now_size] = data;
		
		// n represent for size now, we add one element, then size increment to 1 
		this.n += 1;
	}
	
	public T get(int i) {
		// Check whether i-th element is in array list or not
		if (i>=this.size() || i<0) {
			System.out.println("OutOfIndex");
			return null;
		}
		
		// Return i-th element of array presenting i-th element of array list
		return array[i];
	}
	
	public void set(int i, T data) {
		// Check whether i-th element is in array list or not
		if (i>this.size() || i<0) System.out.println("OutOfIndex");
		
		// Set value of i-th elements is "data"
		array[i] = data;
	}
	
	public void remove(T data) {	
		// Find first position of "data" appear. At the beginning, assign index to -1
		int index = -1; 
		// Loop to take first position of "data" in array list (i-th element). Assign index equals to i and break out loop
		for (int i=0; i<this.size(); i++) {
			if (array[i].equals(data)) {
				index = i;
				break;
			}
		}
		
		// index is not equal -1 that meaning "data" appears at least once in array list. We will shift 
		// left 1 position from (index + 1) position.
		if (index != -1) {
			for (int i=index; i < this.size()-1; i++)
				array[i] = array[i+1];   // Shift left to 1
			
			// Remove one element, size decrease to 1
			this.n -= 1;
		}
	}
	
	public boolean isContain(T data) {

		// Loop all elements in array list and find the element has the same value as data
		for (int i=0; i<this.size(); i++) {
			if (array[i].equals(data)) return true;
		}
		
		// After looping, if we can't find value as "data", "data" is out of array list
		return false;
	}
	
	
	public int size() {
		// Return now size of array list
		return this.n;
	}
	
	
	public boolean isEmpty() {
		// Now size equal 0, then array list is empty 
		return (this.size() == 0);
	}
	
	// This function is created for exercise WordCount
	public int indexOf(T data) {
		for (int i=0; i<this.size(); i++) {
			if (array[i].equals(data)) {
				return i;
			}
		}
		return 0;
	}
	
	public String toString() {
		String arrString = " ";
		for (int i=0; i<this.size(); i++) {
			arrString += array[i].toString() + " ";
		}
		return arrString;
	}
	
	public Iterator<T> iterator() {
		return new Iter();
	}
	
	
	// Create iterator class for iterator method of array list
	private class Iter implements Iterator<T>{
		int cursor = -1;       // index of next element to return
		
		// prevent creating matrix synthetic constructor
        Iter() {}
		
		@Override
		public boolean hasNext() {
			cursor += 1;
			return cursor < size();
		}

		@Override
		public T next() {
            return array[cursor];
        }
		
	}
	
	public static void main(String args[]) {
		SimpleArrayList<Integer> arr = new SimpleArrayList<>();
		
		// Original array list is empty
		System.out.println("ArrayList is empty? " + arr.isEmpty());
		System.out.println("Original size of ArrayList: " + arr.size());

		// Add elements to array list
		System.out.println("\nADDING ELEMENTS ...");
		arr.add(5);
		arr.add(3);
		arr.add(3);
		arr.add(7);
		arr.add(10);
		
		// Now size of array list is 5
		System.out.println("\nSTATUS NOW ARRAYLIST");
		System.out.println("Now size of ArrayList: " + arr.size());
		System.out.println("Now arraylist: " + arr.toString());

		// Check whether matrix element is in array list
		System.out.println("\nCHECK ISCONTAIN METHOD" );
		System.out.println("3 is in ArrayList: " + arr.isContain((Integer) 3)); 
		System.out.println("0 is in ArrayList: " + arr.isContain((Integer) 0)); 
		
		// Get i-th position in array list
		System.out.println("\nGET ELEMENT AT SPECIFICAL POSITION");
		int position = 3;
		System.out.println(position + "-th of ArrayList is " + arr.get(position-1));
		
		// Remove an element in array list
		System.out.println("\nREMOVE METHOD");
		Integer data = (Integer) 3;
		System.out.println("Remove " + data.toString() + "from array list");
		arr.remove(data);
		// Check size and array list now
		System.out.println("Now size of ArrayList: " + arr.size());
		System.out.println("Now arraylist: " + arr.toString());
		
		// Set value of i-th position in array list
		System.out.println("\nSET METHOD");
		System.out.println("ArrayList before setting: " + arr.toString());
		// Assign value and position
		int pos = 2;
		Integer newValue = (Integer) 5;
		System.out.println("Change at position " + pos + "-th with value is " + newValue);
		// Set value again
		arr.set(pos, newValue);
		System.out.println("ArrayList after set: " + arr.toString());
		
		System.out.println("\nTEST ITERATOR");
		Iterator iter = arr.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
	}

}
