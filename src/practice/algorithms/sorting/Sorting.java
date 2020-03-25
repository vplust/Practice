package practice.algorithms.sorting;

import java.util.Arrays;

public class Sorting {
	
	private static void mergeSort(int arr[], int l, int r){
		if(l<r){
			int mid = l + (r-l)/2;
			mergeSort(arr, l, mid);
			mergeSort(arr, mid+1, r);
			merge(arr, l, mid, r);
		}
	}
	
	private static void merge(int arr[], int l, int mid, int r){
		int left[] = Arrays.copyOfRange(arr, l, mid+1);;
		int right[] = Arrays.copyOfRange(arr, mid+1, r+1); 
		int k = l;
		int leftSize = left.length, rightSize = right.length, i = 0, j = 0;
		
		//Insert smallest of sub arrays
		while(i<leftSize && j<rightSize)
			if(left[i]<right[j])
				arr[k++] = left[i++];
			else
				arr[k++] = right[j++];
		
		// Insert left out
		while(i<leftSize)
			arr[k++]=left[i++];
			
		while(j<rightSize)
			arr[k++]=right[j++];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = Arrays.copyOfRange(new int[]{10,4,-3,1},0,4);
		mergeSort(arr, 0, arr.length-1);
		for(int i : arr){
			System.out.println(i);
		}
	}

}
