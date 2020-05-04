package practice.algorithms.stringpattern;

import java.util.Arrays;

public class KnuthMorrisPratt {

	// search pattern
	private static void searchAllExistingPatterns(char[] test, char[] pattern, int[] lps){
		int i=0,j=0,len = test.length,pattLen = pattern.length;
		while(i<len){
			if(pattern[j]==test[i]){
				++j;++i;
			}
			if( j == pattLen){
				System.out.println("found pattern at "+(i-j));
				j = lps[j-1];
			} else if( i <len && pattern[j]!=test[i]){
				if(j!=0){
					j= lps[j-1];
				}
				else{
					++i;
				}
			}
		}
	}
	// create lps
	private static void createLPS(char[] pattern, int[] lps) {
		int i = 0, j = 0, len = pattern.length;
		lps[0] = j;
		++i;
		while (i < len) {
			if (pattern[i] == pattern[j]) {
				lps[i] = ++j;
				++i;
			} else {
				if(j!=0){
					j = lps[j-1];
				} else {
					lps[i]=j;
					++i;
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String testStr = "ABABDABACDABABCABAB";
		String patternStr = "ABABCABAB";
		char[] pattern = patternStr.toCharArray();
		int[] lps = new int[pattern.length];
		createLPS(pattern, lps);
		System.out.println(Arrays.toString(lps));
		searchAllExistingPatterns(testStr.toCharArray(), pattern, lps);
		
	}

}
