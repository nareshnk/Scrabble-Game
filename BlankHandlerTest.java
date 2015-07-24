import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by test on 7/24/2015.
 */
public class BlankHandlerTest extends TestCase {
    @Test
    public void testUpdatedScore() throws Exception {
        BlankHandler blankHandler = new BlankHandler();
        String [] expectedOutput = new String[26];
        char blankReplaceChharacter = 'a';
        for(int i=0; i<26; i++) {
            expectedOutput[i] = new String("a"+blankReplaceChharacter);
        }

        assertEquals(4, blankHandler.updatedScore("abc", "a c"));
        assertEquals(15, blankHandler.updatedScore("axyz", "a yz"));
        //assertEquals(12, blankHandler.updatedScore("ayz", "a z"));
    }


}