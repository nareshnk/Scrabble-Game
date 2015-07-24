import java.util.*;
public class PositionalConstraintChecker {
	
		  
	   public static TreeMap<Integer,String> ConstraintChecker(TreeMap<Integer, String> wordList, String constraint) {
		  
		   char letter;
		   int position;
		   boolean failed;
		   String[] words;
		   TreeMap<Integer,String> validWords = new TreeMap<Integer,String>();
		   for ( Map.Entry<Integer, String> entry : wordList.entrySet() ) {
				words = entry.getValue().split("\\s+");
				for (String word : words){
					failed = false;
					for (int j = 0;j < constraint.length();j += 2){
						letter = constraint.charAt(j);
						position = constraint.charAt(j + 1)-'1';
				   
						if (position > word.length()||letter != word.charAt(position)){
							failed = true;
							break;
				        }
			        }
					if (!failed){
						String wordOfSameScore = validWords.get(entry.getKey());
						if( wordOfSameScore == null){
							wordOfSameScore = word;
						}
						else{
							wordOfSameScore = wordOfSameScore + " " + word;
						}
						validWords.put(entry.getKey(), wordOfSameScore);
				   
					}

				}					
					
			}
		   
		   return validWords;
	   }
	   
	   
	}