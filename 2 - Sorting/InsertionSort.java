package Sorting;

import java.util.Random;

// BAI 3
public class InsertionSort {

	private int[] arr;
	private int count_compare=0, count_swap=0;
	private boolean verbose; // print status of array after each iteration if True
	
	public InsertionSort(int[] arr, boolean verbose) {
		this.arr = arr;
		this.verbose = verbose;
	}

	public int[] getArr() {
		return arr;
	}

	public void setArr(int[] arr) {
		this.arr = arr;
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
	
	public boolean isVerbose() {
		return verbose;
	}

	public void setVerbose(boolean verbose) {
		this.verbose = verbose;
	}

	// Function for initialize random array
	public static int[] createArray(int n, int bound) {
		// Initialize an empty array with n elements
		int[] array = new int[n];
		
		// Set seed for random to reuse
		long seed = 10;
		Random rand = new Random(seed);
		
		// Create an random array with n element
		for (int i=0; i<n; i++) {
			array[i] = rand.nextInt(bound);
		}
		
		return array;
	}
	
	// Function for printing elements of array
	public static void printOut (int[] arr) {
		for (int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	// Implement Insertion Sort
	public int[] insertionSort() {
		int[] arr = this.getArr();
		int length = arr.length;
		for (int i=1; i<length; i++) {
			int next = arr[i];
			for (int j=i-1; j>=0; j--) {
				// Swap
				if (arr[j] > next) {
					arr[j+1] = arr[j];
					arr[j] = next;
					this.count_swap += 1;
				}
				this.count_compare += 1;
				}
			if (this.isVerbose()) {
				System.out.println("Now, status :");
				printOut(arr);
				}
			}
		return arr;
		}
	
	public String effective() {
		return String.format("Number of comparability: %d\nNumber of swapping: %d\n",
				this.getCount_compare(), this.getCount_swap());
	}
	
	public static void main(String[] args) {
		// Set bound that meaning every element of array is in arrange 0,1,2,...,bound-1.
		int bound = 50;
		// The number of elements in your array
		int n = 8;
		// Create random array
//		int[] arr = createArray(n, bound);
		int[] arr = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
		// Set verbose is True to print status of array after each iteration
		boolean verbose = true;
		// Sort
		InsertionSort sort = new InsertionSort(arr, verbose);
		int[] sorted = sort.insertionSort();
		System.out.println(sort.effective());
	}

}
