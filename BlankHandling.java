import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by test on 7/24/2015.
 */
public class BlankHandling {
    public static int alphabetWeights[] = {1,3,3,2,1,4,2,4,1,8,5,1,3,1,1,3,10,1,1,1,1,4,4,8,4,10};

    HashMap<Integer, String> updateWordScore = new HashMap<Integer, String>();
    public static ArrayList<String> blankReplacedWords = new ArrayList<String>();

    public static void replaceBlanks(String rackAlphabets) {

        if(rackAlphabets.contains(" ")) {
            for(char i='a'; i<='z'; i++) {
                String modifiedWord = rackAlphabets.replaceFirst(" ", Character.toString(i));
                blankReplacedWords.add(modifiedWord);
                if(modifiedWord.contains(" ")) {
                    blankReplacedWords.remove(modifiedWord);
                    replaceBlanks(modifiedWord);
                }
            }
        }
    }

    public static int updatedScore(String word, String rackAlphabets) {
        char [] presentLetters = rackAlphabets.toCharArray();

        int score = 0;
        for (int i=0; i< presentLetters.length; i++) {
            if (word.contains(Character.toString(presentLetters[i]))) {
                score += alphabetWeights[presentLetters[i]-'a'];
            }
        }
        return score;
    }
}
