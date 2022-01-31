package PriorityQueue.Exercise3;

public class SelectionSort implements SortInterface{
	
	private int[] arr;
	
	public SelectionSort (int[] arr) {
		this.arr = arr;
	}
	
	// Implement Selection Sort
	public void sort() {
		int length = arr.length;
		for (int i=length-1; i>=1; i--) {
			int maxIndex = i;
			for (int j=0; j<i; j++) {
				if (arr[j] > arr[maxIndex]) maxIndex = j;
			}		
			// Swap
			int temp = arr[maxIndex];
			arr[maxIndex] = arr[i];	
			arr[i] = temp;
		}
	}
	
	public String toString() {
		String content = "";
		for (int i=0; i<arr.length; i++) content += arr[i] + ", ";
		return content;
	}
}
