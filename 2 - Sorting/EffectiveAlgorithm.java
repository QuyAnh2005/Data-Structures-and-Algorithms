package Sorting;

// BAI 4
public class EffectiveAlgorithm {

	public static void main(String[] args) {
		// Given array
		int[] arr = {2, 5, 8, 10, 13, 17, 20, 28, 35, 46, 50};
		// Because we only care the number of comparability and swapping, 
		// we will set verbosr for all algorithm is false
		boolean verbose = false;
		
		// Sort to algorithms
		// Bubble Sort
		BubbleSort bubble = new BubbleSort(arr, verbose);
		int[] sort2bubble = bubble.bubbleSort();
		System.out.println("BUBBLE SORT ALGORITHM");
		System.out.println(bubble.effective());
		
		SelectionSort select = new SelectionSort(arr, verbose);
		int[] sort2select = select.selectionSort();
		System.out.println("SELECTION SORT ALGORITHM");
		System.out.println(select.effective());
		
		InsertionSort insert = new InsertionSort(arr, verbose);
		int[] sort2insert = insert.insertionSort();
		System.out.println("INSERTION SORT ALGORITHM");
		System.out.println(insert.effective());

	}

}
