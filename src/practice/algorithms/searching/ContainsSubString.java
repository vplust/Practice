package practice.algorithms.searching;

public class ContainsSubString {

	private boolean containsSubString(char[] source, char[] test,int indexSource, int indexTest){
		if(indexSource==source.length)
			return false;
		else if(indexTest==test.length)
			return true;
		else if(source[indexSource]==test[indexTest])
			return containsSubString(source, test, ++indexSource, ++indexTest);
		else if(source[indexSource]!=test[indexTest])
			return containsSubString(source, test, ++indexSource, 0);
		
		return false;
	}
	public static void main(String[] args) {
		System.out.println(new ContainsSubString().containsSubString("testtest123".toCharArray(), "t12".toCharArray(), 0, 0));;
		
		
		
		

	}

}
