package PriorityQueue.Exercise3;

import PriorityQueue.Utils.GenerateArray;

public class Compare {
	
	public static void judge(int[] arr, int sign) {
		SortInterface sortAlgo = null;
		
		if (sign == 1) {
			sortAlgo = (SelectionSort) new SelectionSort(arr);
		} else if (sign == 2) {
			sortAlgo = new MergeSort(arr);
		} else if (sign == 3) {
			sortAlgo = new QuickSort(arr);
		} else if (sign == 4) {
			if (arr.length >= 1000) sortAlgo = new HeapSort(arr, arr.length+1);
			else sortAlgo = new HeapSort(arr);
		} else {
			System.out.println("Algorithm is invalid!!");
		}
		
		// Measure time
		long startTime = System.currentTimeMillis();
		sortAlgo.sort();
		long elapsedTime = System.currentTimeMillis() - startTime;
		
		// Print out
		String messageOut = String.format("%s: %d", sortAlgo.getClass().getSimpleName(), elapsedTime);
		System.out.println(messageOut);
	}
	
	public static void main(String[] args) {
		int seed = 36; 	// Set seed to generate same array in every time
		int numAlgo = 4;   // 1 - Selection Sort, 2 - Merge Sort, 3 - Quick Sort, 4 - Heap Sort 
		// Test on some samples
		int[] sizes = {1000, 10000, 100000, 1000000};
		
		// Measure 
		for (int size:sizes) {
			System.out.println("SAMPLE SIZE - " + size);
			for (int i=1; i<=numAlgo; i++) {
				GenerateArray generate = new GenerateArray(size, seed);
				int[] arr = generate.generate();
				judge(arr, i);	
			}
			System.out.println("---------------------------------\n\n");
		} 
	}

	
}
