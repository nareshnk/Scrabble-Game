import java.util.*;
import java.lang.*;
import java.io.*;


class BaseWordGenerator {
	
	public static int[] letterScore = {1,3,3,2,1, 4,2,4,1,8, 5,1,3,1,1, 3,10,1,1,1, 1,4,4,8,4,10};
	
	public static int wordScore(String word) {
		int score=0;
		for(int i = 0; i < word.length(); i++ ) {
			score += letterScore[word.charAt(i)-'a'];
		}
		return score;
	}
	
	public static ArrayList<String> generateAllCombinationsOfWords(String input) {
		char[] inputArray = input.toCharArray();
		Arrays.sort(inputArray);
		System.out.println(inputArray);
		ArrayList<String> output = new ArrayList<String>();
		
		for(int i = 2; i <= inputArray.length; i++) {
			char[] data = new char[inputArray.length];
			combinationUtil(inputArray, data, 0, inputArray.length - 1, 0, i, output);
		}
		return output;
	}
	
	public static void combinationUtil(char[] arr, char[] data, int start, int end, int index, int r, ArrayList<String> listOfWords) {
	    if (index == r) {
	        listOfWords.add(new String(data));
	        return;
	    }

	    for (int i=start; i<=end && end-i+1 >= r-index; i++) {
	        data[index] = arr[i];
	        combinationUtil(arr, data, i+1, end, index+1, r, listOfWords);
	    }
	}
	
	public static void main (String[] args) throws java.lang.Exception {
		System.out.println(wordScore("baaq"));
	}
}