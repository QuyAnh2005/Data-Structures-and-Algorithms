package Sorting;

import java.util.Random;
import java.util.Collections;

// BAI 5
public class GenericSort<T extends Comparable<T>> {
	
	// Set the number of comparison and swapping to 0
	private int count_compare, count_swap;
	private T[] array;
	
	public GenericSort(T[] array) { 
		this.array = array;
	}
	
	// Getter and Setter	
	public T[] getArray() {
		return array;
	}

	public void setArray(T[] array) {
		this.array = array;
	}
	
	public int getCount_compare() {
		return count_compare;
	}
	
	public void setCount_compare(int count_compare) {
		this.count_compare = count_compare;
	}

	public int getCount_swap() {
		return count_swap;
	}

	public void setCount_swap(int count_swap) {
		this.count_swap = count_swap;
	}

	// Return matrix string to print your array out
	public String toString(T[] arr) {
		String content = "";
		for (T element: arr) {
			content += element.toString();
		}
		return content;
	}
	
	// Return matrix string to print the number of comparison and swapping
	public String seeEffection() {
		return String.format("The number of comparision: %d "
				+ "\nThe number of swapping: %d", this.count_compare, this.count_swap);
	}

	// Implement bubble sort
	public T[] bubbleSort() {
		T[] arr = this.getArray();
		int length = arr.length;
		// Reset the number of comparison and swapping to 0
		this.setCount_compare(0);
		this.setCount_swap(0);	
		
		// Loop, compare and swap
		for (int i=0; i<length; i++) {
			for (int j=1; j<length-i; j++) {
				// Increment to 1 count_compare
					this.count_compare += 1;
				if (arr[j-1].compareTo(arr[j]) == 1) {
					T temp = arr[j-1];
					// Swap two element if matrix[j-1] more than matrix[j]
					arr[j-1] = arr[j];
					arr[j] = temp;
					// Increment to 1 count_swap
					this.count_swap += 1;
				}
			}
		}
		return arr;
	}
	
	// Implement selection sort
	public T[] selectionSort() {
		T[] arr = this.getArray();
		int length = arr.length;
		// Reset the number of comparison and swapping to 0
		this.setCount_compare(0);
		this.setCount_swap(0);	
		
		// Loop, compare and swap
		for (int i=length-1; i>=1; i--) {
			int maxIndex = i;
			for (int j=0; j<i; j++) {
				if (arr[j].compareTo(arr[maxIndex]) == 1) {
					maxIndex = j;
				}
				this.count_compare += 1;
			}		
			// Swap
			T temp = arr[maxIndex];
			arr[maxIndex] = arr[i];	
			arr[i] = temp;
			// Increment count_swap to 1
			this.count_swap += 1;
		}
		return arr;
	}
	
	// Implement insertion sort
	public T[] insertionSort() {
		T[] arr = this.getArray();
		int length = arr.length;
		// Reset the number of comparison and swapping to 0
		this.setCount_compare(0);
		this.setCount_swap(0);	
		
		// Loop, compare and swap
		for (int i=1; i<length; i++) {
			T next = arr[i];
			for (int j=i-1; j>=0; j--) {
				// Swap
				if (arr[j].compareTo(next) == 1) {
					arr[j+1] = arr[j];
					arr[j] = next;
					this.count_swap += 1;
				}
				this.count_compare += 1;
			}
		}
		return arr;
	}
	
	// Function for shuffling elements in staff array
	public static Staff[] shuffle(Staff[] staffs) {
		System.out.println("----------------------");
		Random rand = new Random();
		int length = staffs.length;
		for (int i=0; i<length; i++) {
			int randInt = rand.nextInt(length);
			// Swap random two element in array
			Staff temp = staffs[i];
			staffs[i] = staffs[randInt];
			staffs[randInt] = temp;
		}
		return staffs;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 6;
		Staff[] staffs = new Staff[n];
		
		// Initialize elements for array 
		Staff p1 = new Staff("Anh", 17, 901.5);	
		Staff p2 = new Staff("Tung", 16, 850.2);
		Staff p3 = new Staff("Quan", 18, 900.9);
		Staff p4 = new Staff("Hoa", 17, 750.5);	
		Staff p5 = new Staff("Hung", 16, 810.2);
		Staff p6 = new Staff("Tan", 18, 1000.0);
		staffs[0] = p1;
		staffs[1] = p2;
		staffs[2] = p3;
		staffs[3] = p4;
		staffs[4] = p5;
		staffs[5] = p6;
		
		// Test sort algorithm with generic object
		GenericSort<Staff> sort = new GenericSort<>(staffs);
		
		/* NOTE: Because you only have an array, after sorting using one algorithm, your array is changed.
		 * Therefore, you need to shuffle or comment other algorithms to run algorithm that you want
		 */
		
		// Sort generic object using bubble sort
		System.out.println("BUBBLE SORT");
		sort.bubbleSort();
		System.out.println(sort.seeEffection());
		shuffle(staffs);
		
		// Sort generic object using selection sort
		System.out.println("SELECTION SORT");
		sort.selectionSort();
		System.out.println(sort.seeEffection());
		shuffle(staffs);
		
		// Sort generic object using insertion sort
		System.out.println("INSERTION SORT");
		sort.insertionSort();
		System.out.println(sort.seeEffection());
		
		// Print sorted array
		System.out.println("-------------------------");
		System.out.println(sort.toString(staffs));
		
	}

}
