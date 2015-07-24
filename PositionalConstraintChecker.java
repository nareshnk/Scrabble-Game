import java.util.*;
public class PositionalConstraintChecker {
	
		  
	   public static ArrayList<String> ConstraintChecker(String[] wordList, String constraint) {
		  
		   char letter;
		   int position;
		   boolean failed;
		   ArrayList<String> validWords = new ArrayList<String>();
		   for (String word: wordList) {
			  failed = false;
			   for (int j = 0;j < constraint.length();j += 2){
				   letter = constraint.charAt(j);
				   position = constraint.charAt(j + 1)-1;
				   
				   if (position>word.length()||letter != word.charAt(position)){
					   failed = true;
					   break;
				   }
			   }
			   if (!failed){
				   validWords.add(word);
			   }

			   
		  }
		   return validWords;
	   }
	   
	   public static void main(String[] args) {
		   String[] test = {"Hi","Hello","Beast","parade"};
		   String constraint = "H0i1";
		   ArrayList<String> testarray = new ArrayList<String>();
		   testarray = PositionalConstraintChecker.ConstraintChecker(test,constraint);
		   for (String s: testarray)
		   System.out.println(s);
		   
		}
	}