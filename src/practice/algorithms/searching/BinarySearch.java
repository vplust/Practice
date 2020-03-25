package practice.algorithms.searching;

public class BinarySearch {

	static int binarySearch(int[] arr, int l, int r, int x) {
		if (r >= l) {
			int mid = l + (r - l) / 2;
			if (arr[mid] == x)
				return mid;
			else if (arr[mid] < x)
				return binarySearch(arr, mid + 1, r, x);
			else
				return binarySearch(arr, l, mid - 1, x);
		}
		return -1;
	}
	
	static int linearSearch(int[] arr, int l, int r, int x) {
		while(r>=l){
			if(arr[l]!=x){
				++l;
				continue;
			}
			return l;
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5 };
		System.out.println(binarySearch(arr, 0, arr.length - 1, 4));
		System.out.println(linearSearch(arr, 0, arr.length - 1, 4));
		
	}

}
