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
					
				    int prevPosition = 0;
					int prevIndex = -1;
					int currentIndex ;
					for (int j = 0;j < constraint.length();j += 2){
						letter = constraint.charAt(j);
						position = constraint.charAt(j + 1)-'1';
						
						currentIndex = word.indexOf(letter);
						if(currentIndex == -1){
							failed = true;

						}
						if(!failed && position == 0){
							if(word.charAt(0) != letter){
								failed = true;
								
							}
						}
						if (!failed && position > word.length()-1){
							failed = true;
							
				        }
						
						
						if (prevIndex != -1){
							if((currentIndex-prevIndex) != (position - prevPosition )){
								failed = true;
								break;
							}
							
						}
						prevIndex = currentIndex;
						prevPosition = position;
						
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