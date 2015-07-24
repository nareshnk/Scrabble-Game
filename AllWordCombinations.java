/**
 * Created by test on 7/24/2015.
 */
import java.util.ArrayList;

public class AllWordCombinations {
    private static ArrayList<String> allPossibleWords = new ArrayList<String>();

    public static void generateLetterCombinations(String instr, StringBuffer outstr, int index)
    {
        for (int i = index; i < instr.length(); i++)
        {
            outstr.append(instr.charAt(i));
            allPossibleWords.add(outstr.toString());
            generateLetterCombinations(instr, outstr, i + 1);
            outstr.deleteCharAt(outstr.length() - 1);
        }
    }

    public static String [] possibleCombinations(String word) {
        generateLetterCombinations(word, new StringBuffer(), 0);
        return allPossibleWords.toArray(new String[allPossibleWords.size()]);
    }
}
