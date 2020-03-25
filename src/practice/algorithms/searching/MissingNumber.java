package practice.algorithms.searching;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MissingNumber {

	public int missingNumber(int... arr){
		return arr.length*(arr.length+1)/2 - Arrays.stream(arr).sum();
	}
	
	public int missingNumberXor(int...arr){
		int xorOfArr = Arrays.stream(arr).reduce((a,b)->a^b).getAsInt();
		int xorOfSize = IntStream.rangeClosed(1, arr.length).reduce((a,b)->a^b).getAsInt();
		System.out.format("xorArr : %d, xorLength : %d",xorOfArr,xorOfSize);
		return xorOfSize-xorOfArr; 
	}
	
	public static void main(String[] args) {
		System.out.println(new MissingNumber().missingNumber(1,2,0,4,5));
		System.out.println(new MissingNumber().missingNumberXor(1,2,0,4,5));

	}

}
