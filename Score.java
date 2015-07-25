import java.util.*;

class Score{
	
	public int wordScore(String word) {
		int score=0;
		for(int i = 0; i < word.length(); i++ ) {
			score += letterScore[word.charAt(i)-'a'];
		}
		return score;
	}
	
}