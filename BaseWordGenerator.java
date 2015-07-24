import java.util.*;
import java.lang.*;
import java.io.*;

class BaseWordGenerator{
	private static final String FILE = "C://Users/test/Documents/GitHub/ScrabbleWordGenerator/sowpods-scrabble-list.txt";
	
	static Anagrams AnagramCollection;
	
	public void addToHash(Map<Integer, String> scoreMap, ArrayList<String> words){
        
		int score;
		for(String eachWord: words){
			
			if (AnagramCollection.map.containsKey(eachWord)) {
				score = wordScore(eachWord);
				if (scoreMap.containsKey(score)) {
					scoreMap.put(score, scoreMap.get(score) + " " + word);
				} else {
					scoreMap.put(score, word);
				}
			}
		}
		
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
	
	public static Map<Integer, String> generateScoreHash(String rack){
	
		public static Map<Integer, String> scoreMap = new HashMap<Integer, String>();
	
		ArrayList<String> allPossibleWords = (generateAllCombinationsOfWords(rack));
		addToHash(scoreMap,allPossibleWords);
		return scoreMap;
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

		AnagramCollection = new Anagrams();
        AnagramCollection.readFile(FILE);	
	
	}
}