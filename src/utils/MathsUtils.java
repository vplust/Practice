package utils;

public class MathsUtils {
	
	public static int gcd(long a, long b){
		if(b%a==0)
			return (int) a;
		else 
			return gcd(b%a,a);
	}

}
