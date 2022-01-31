package PriorityQueue.Exercise3;

public class MergeSort implements SortInterface{
	private int[] arr;
	
	public MergeSort (int[] arr) {
		this.arr = arr;
	}
	
	// Implement Merge Sort
	public void sort() {
		int low = 0;
		int high = arr.length-1;
		this.mergeSort(arr, low, high);
	}
	
	public void mergeSort(int[] arr, int low, int high) {
		if (low < high) {
			int mid = (low + high) /  2;
			mergeSort(arr, low, mid);
			mergeSort(arr, mid+1, high);
			this.merge(arr, low, mid, high);
		}
	}
	
	public void merge(int[] arr, int low, int mid, int high) {
		int n = high - low + 1;
		int[] b = new int[n];
		int left = low, right = mid + 1, bIdx = 0;
		while (left <= mid && right <= high) {
			if (arr[left] <= arr[right]) b[bIdx++] = arr[left++];
			else b[bIdx++] = arr[right++];
		}
		
		while (left <= mid) b[bIdx++] = arr[left++];
		while (right <= high) b[bIdx++] = arr[right++];
		
		for (int i=0; i<n; i++) arr[low+i] = b[i];
	}
	
	public String toString() {
		String content = "";
		for (int i=0; i<arr.length; i++) content += arr[i] + ", ";
		return content;
	}
}
