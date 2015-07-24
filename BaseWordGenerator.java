import java.util.*;

class BaseWordGenerator{
	//private static final String FILE = "C://Users/test/Documents/GitHub/ScrabbleWordGenerator/sowpods-scrabble-list.txt";
	private static final String FILE = "C:/Users/test/Documents/ScrabbleFinal/ScrabbleWordGenerator/sowpods-scrabble-list.txt";

	static Anagrams AnagramCollection;

	public static void addToHash(Map<Integer, String> scoreMap, ArrayList<String> words){

		int score;
		for(String eachWord: words){
			if (AnagramCollection.map.containsKey(eachWord)) {
				score = wordScore(eachWord);

				if (scoreMap.containsKey(score)) {
					scoreMap.put(score, scoreMap.get(score) + " " + AnagramCollection.map.get(eachWord));
				}
				else {
					scoreMap.put(score, AnagramCollection.map.get(eachWord));
				}
			}
		}

	}

	public static int[] letterScore = {1,3,3,2,1,4,2,4,1,8,5,1,3,1,1,3,10,1,1,1,1,4,4,8,4,10};

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
		ArrayList<String> output = new ArrayList<String>();

		for(int i = 2; i <= inputArray.length; i++) {
			char[] data = new char[i];
			combinationUtil(inputArray, data, 0, inputArray.length - 1, 0, i, output);
		}
		return output;
	}

	public static Map<Integer, String> generateScoreHash(String rack){

		Map<Integer, String> scoreMap = new HashMap<Integer, String>();

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


	public static boolean containsWord(String sameWeightWords, String comparionWord){

		boolean result=false;

		if(sameWeightWords!=null)
		{
			String [] words = sameWeightWords.split(" ");

			for(String word: words) {
				if (comparionWord.trim().equals(word.trim())) {
					return true;
				}
			}
		}
		return result;

	}

public static void main (String[] args) throws Exception {

		AnagramCollection = new Anagrams();
        AnagramCollection.readFile(FILE);

		Scanner input = new Scanner(System.in);

		System.out.print("GIVE INPUT  \n");
		String rackWords = input.nextLine();

		Map<Integer, String> updatedWordScore = new HashMap<Integer, String>();
		Map<Integer, String> sortedWords;

		if (rackWords.contains(" ")) {
			ArrayList<String> updatedWords = BlankHandler.getBlankReplacedWords(rackWords);

			for(String word: updatedWords) {
				Map<Integer, String> spaceReplacedWords = generateScoreHash(word);

				for(int weight: spaceReplacedWords.keySet()) {
					String [] words = spaceReplacedWords.get(weight).split(" ");

					for(String validWord:words) {
						int finalScore = BlankHandler.updatedScore(validWord.trim(), rackWords.trim());
						if (updatedWordScore.containsKey(finalScore)) {
							if(!containsWord(updatedWordScore.get(finalScore),validWord))
								updatedWordScore.put(finalScore, (updatedWordScore.get(finalScore) +" "+ validWord));

						} else {
							updatedWordScore.put(finalScore, validWord);

						}
					}
				}

			}
			sortedWords = new TreeMap<Integer, String>(updatedWordScore);
		} else {

			sortedWords = new TreeMap<Integer, String>(generateScoreHash(rackWords));
		}

	for(int entry: sortedWords.keySet()) {
		System.out.println(entry+" "+sortedWords.get(entry));
	}
	}

}