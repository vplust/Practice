package practice.algorithms.searching;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SearchInSortedRotated {

	private static int findPivot(Integer arr[], int low, int high) {
		// binary search
		if (low <= high) {
			// if right < left then pivot in first half
			int lowVal = arr[low];
			int highVal = arr[high];
			int mid = low + (high - low) / 2;
			int midVal = arr[mid];
			if (mid < high && arr[mid + 1] < midVal)
				return mid;
			else if (lowVal > midVal)
				return findPivot(arr, low, mid);
			else
				return findPivot(arr, mid, high);
		}
		return -1;
	}

	private static int searchNumber(Integer[] arr,int low, int high, int number){
		if(low<=high){
			int mid = low+(high-low)/2;
			if(number==arr[mid])
				return mid;
			else if (number > arr[mid])
				return searchNumber(arr, mid, high, number);
			else 
				return searchNumber(arr, low, mid, number);
		}
		
		return -1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 List<Integer> list= IntStream.range(0,50).boxed().collect(Collectors.toList());
		 int random = new Random().nextInt(49);
		 Collections.rotate(list, random);
		 int index25 = list.indexOf(25);
		System.out.println(list);
		Integer array[] = list.toArray(new Integer[50]);
		int i = findPivot(array, 0, list.size()-1);
		System.out.println("pivot : "+ i);
		int low = array[i]<array[0] ? i+1 : 0;
		int high = low ==0 ? i : array.length-1;
		int indexFound = searchNumber(array, low, high, 25);
		System.out.println("Index found in sorted rotated array : "+(index25==indexFound));
		
		
		
	}

}
