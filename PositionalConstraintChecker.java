import java.io.*;
import java.util.*;
public class PositionalConstraintChecker {
	
		  
	   public static ArrayList ConstraintChecker(String[] wordList, String constraint) {
		  
		   char letter;
		   int position;
		   boolean failed = false;
		   List validWords = new ArrayList();
		   for (int i = 0;i < wordList.length; i++) {
			  
			   for (int j = 0;j < constraint.length();j += 2){
				   letter = constraint.charAt(j);
				   position = constraint.charAt(j + 1);
				   if (letter != wordList[i].charAt(position)){
					   failed = true;
					   break;
				   }
			   }
			   if (failed != true){
				   validWords.add(wordList[i]);
			   }
			   
		  }
		   return validWords;
	   
		
	}
	   }