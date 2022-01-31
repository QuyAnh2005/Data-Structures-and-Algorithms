package PriorityQueue.Exercise3;

import PriorityQueue.Utils.GenerateArray;

public class QuickSort implements SortInterface {
	private int[] arr;
	
	public QuickSort (int[] arr) {
		this.arr = arr;
	}
	
	// Implement Quick Sort
	public void sort() {
		int low = 0;
		int high = arr.length-1;
		this.quickSort(arr, low, high);
	}
	
	public void quickSort(int[] arr, int low, int high) {
		int pivotIdx;
		if (low < high) {
			pivotIdx = partition(arr, low, high);
			quickSort(arr, low, pivotIdx-1);
			quickSort(arr, pivotIdx+1, high);
		}
	}
	
	public int partition(int[] arr, int low, int high) {
		int pivot = arr[low];
		int m = low;
		
		for (int k=low+1; k<=high; k++) {
			if (arr[k] < pivot) {
				++m;
				this.swap(arr, k, m);
			}
		}
		this.swap(arr, low, m);
		return m;
	}
	
	public void swap(int [] arr, int i, int m) {
		int temp = arr[i];
		arr[i] = arr[m];	
		arr[m] = temp;
	}
	
	public String toString() {
		String content = "";
		for (int i=0; i<arr.length; i++) content += arr[i] + ", ";
		return content;
	}
}
