package practice.algorithms.sorting;

import java.util.Arrays;

public class Sorting {

	private static void mergeSort(int arr[], int l, int r) {
		if (l < r) {
			int mid = l + (r - l) / 2;
			mergeSort(arr, l, mid);
			mergeSort(arr, mid + 1, r);
			merge(arr, l, mid, r);
		}
	}

	private static void merge(int arr[], int l, int mid, int r) {
		int left[] = Arrays.copyOfRange(arr, l, mid + 1);
		;
		int right[] = Arrays.copyOfRange(arr, mid + 1, r + 1);
		int k = l;
		int leftSize = left.length, rightSize = right.length, i = 0, j = 0;

		// Insert smallest of sub arrays
		while (i < leftSize && j < rightSize)
			if (left[i] < right[j])
				arr[k++] = left[i++];
			else
				arr[k++] = right[j++];

		// Insert left out
		while (i < leftSize)
			arr[k++] = left[i++];

		while (j < rightSize)
			arr[k++] = right[j++];
	}

	private static int partition(int[] arr, int l, int r) {

		// set pivot
		int pivot = arr[r];
		int i = l;
		// divide array into two parts around pivot
		for (int j = l; j <= r; ++j) {
			if (arr[j] < pivot) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				++i;
			}
		}
		int temp = arr[i];
		arr[i] = arr[r];
		arr[r] = temp;

		// return pivot index
		return i;
	}

	private static void quickSort(int arr[], int l, int r) {

		if(l<r){
			// parition on pivot
			int p = partition(arr, l, r);

			// call quicksort on first half
			quickSort(arr, l, p - 1);

			// call quicksort on second half
			quickSort(arr, p + 1, r);
		}

	}

	
	private static void heapSort(int arr[]){
		//Create heap
		for(int node = arr.length-1;node>=0;--node){
			heapify(arr,node,arr.length);
		}
		//sort heap
		for(int i = arr.length-1;i>=0;--i){
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i]=temp;
			
			heapify(arr, 0, i);
			
		}
		
	}
	private static void heapify(int[] arr, int node, int sizeForSort) {
		// TODO Auto-generated method stub
		//Set node to highest
		int highest = node;
		//Compare highest with left child
		int left = 2*node+1;
		highest = left < sizeForSort && arr[highest]<arr[left] ? left : highest;
		//Compare highest with right child
		int right = 2*node +2;
		highest = right < sizeForSort && arr[highest]<arr[right] ? right : highest;
		//swap node with highest node and heapify the swapped child
		if(highest != node){
			int temp = arr[node];
			arr[node] = arr[highest];
			arr[highest] = temp;
			
			heapify(arr,highest, sizeForSort);
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = Arrays.copyOfRange(new int[] { 10, 4, -3, 1 ,6}, 0, 5);
		// mergeSort(arr, 0, arr.length-1);
		//quickSort(arr, 0, arr.length - 1);
		heapSort(arr);
		
		for (int i : arr) {
			System.out.println(i);
		}
	}

}
