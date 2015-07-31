import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Rummy {
	
	private final int INT_MAX = 100;
	public static final int PACKS = 3;
    public static final int CARDS_IN_PACK = 53;
    public static final int CARDS_IN_SUIT = 13;
    public static final String CARD_NAMES = "A23456789TJQK";
    public static final String CARD_SUITS = "CDHS";

	public int findMinimumDraws(List<String> hand){
		List<Set> validSets = new ArrayList<Set>();
		List<Integer> cards = new ArrayList<Integer>();
		for(String s : hand){
			cards.add(getNumberForCard(s));
		}
		return findMinimumUnusedCards(cards,validSets);
	}



	private List<Set> getAllPossible3LengthPermutations(List<Integer> hand,int setsize){
		Collections.sort(hand);

		List<Set> allPossibleSets= new ArrayList<Set>();

		for (int i=0;i <= hand.size()-setsize;i++)
		{
			allPossibleSets.add(new Set(hand.subList(i,i+setsize)));
		}


		return allPossibleSets;
	}


	private List<Set> getAllPossible3LengthPermutations(List<Integer> hand){
		return null;
	}
	
	private List<Set> getAllPossible4LengthPermutations(List<Integer> hand){
		return null;
	}
	
	private List<Set> getAllPossible5LengthPermutations(List<Integer> hand){
		return null;
	}
	
	private int getNumberForCard(String card){
		 int cardNumber = 0;
         String c = card.substring(0,1);
         cardNumber += (CARD_NAMES.indexOf(c) + 1);
         c = card.substring(1,2);
         cardNumber += (CARD_SUITS.indexOf(c) * 13);
         return cardNumber;
	}
	
	private boolean isTripletOrQuadFound(List<Integer> cards){
		List<Set>  allPossiblePermutations = getAllPossible3LengthPermutations(cards);
		allPossiblePermutations.addAll(getAllPossible4LengthPermutations(cards));
		for(Set s : allPossiblePermutations){
			if(s.isTriplet() || s.isQuadruple()){
				return true;
			}
		}
		return false;
	}
	
	private boolean isSequenceFound(List<Integer> cards){
		List<Set>  allPossiblePermutations = getAllPossible3LengthPermutations(cards);
		allPossiblePermutations.addAll(getAllPossible4LengthPermutations(cards));
		for(Set s : allPossiblePermutations){
			if(s.isSequence()){
				return true;
			}
		}
		return false;
	}
	
	private boolean isNaturalSequenceFound(List<Integer> cards){
		List<Set>  allPossiblePermutations = getAllPossible3LengthPermutations(cards);
		allPossiblePermutations.addAll(getAllPossible4LengthPermutations(cards));
		allPossiblePermutations.addAll(getAllPossible5LengthPermutations(cards));
		for(Set s : allPossiblePermutations){
			if(s.isNaturalSequence()){
				return true;
			}
		}
		return false;
	}
	
	private List<Set> findAllNaturalSequences(List<Integer> cards){
		List<Set>  allPossiblePermutations = getAllPossible3LengthPermutations(cards);
		allPossiblePermutations.addAll(getAllPossible4LengthPermutations(cards));
		allPossiblePermutations.addAll(getAllPossible5LengthPermutations(cards));
		List<Set> naturalSequences  = new ArrayList<Set>();
		for(Set s : allPossiblePermutations){
			if(s.isNaturalSequence()){
				naturalSequences.add(s);
			}
		}
		return naturalSequences;
	}
	
	private List<Set> findAllSequences(List<Integer> cards){
		List<Set>  allPossiblePermutations = getAllPossible3LengthPermutations(cards);
		allPossiblePermutations.addAll(getAllPossible4LengthPermutations(cards));
		allPossiblePermutations.addAll(getAllPossible5LengthPermutations(cards));
		List<Set> sequences  = new ArrayList<Set>();
		for(Set s : allPossiblePermutations){
			if(s.isSequence()){
				 sequences.add(s);
			}
		}
		return sequences;
	}
	
	private List<Set> findAllTripletsAndQuads(List<Integer> cards){
		List<Set>  allPossiblePermutations = getAllPossible3LengthPermutations(cards);
		allPossiblePermutations.addAll(getAllPossible4LengthPermutations(cards));
		allPossiblePermutations.addAll(getAllPossible5LengthPermutations(cards));
		List<Set> tripletsOrQuads  = new ArrayList<Set>();
		for(Set s : allPossiblePermutations){
			if(s.isTriplet()||s.isQuadruple()){
				tripletsOrQuads.add(s);
			}
		}
		return tripletsOrQuads;
	}
	
	
	
	private int findMinimumUnusedCards(List<Integer> leftCards ,List<Set> validSets){
		if(!isNaturalSequenceFound(leftCards) && !isSequenceFound(leftCards) && !isTripletOrQuadFound(leftCards)){
			boolean is5LengthSetFound = false;
			boolean is3LengthSetFound = false;
			for(Set s : validSets){
				if(s.getSize()==5){
					is5LengthSetFound = true;
				}
				if(s.getSize()==3){
					is3LengthSetFound = true;
				}
			}
			
			if(is5LengthSetFound && is3LengthSetFound){
				return INT_MAX;
			}
			return leftCards.size();
		}
		
		int minimumSoFar = INT_MAX;
		
		if(isNaturalSequenceFound(leftCards)){
			List<Set> naturalSequences = findAllNaturalSequences(leftCards);
			for(Set s : naturalSequences){
				validSets.add(s);
				for(int i : s.getSet()){
				leftCards.remove(i);	
				}
				int min = findMinimumUnusedCards(leftCards,validSets);
				if(min<minimumSoFar){
					minimumSoFar = min;
				}
			}
		}
		
		if(isSequenceFound(leftCards)){
			List<Set> sequences = findAllSequences(leftCards);
			for(Set s : sequences){
				validSets.add(s);
				for(int i : s.getSet()){
					leftCards.remove(i);	
				}
				int min = findMinimumUnusedCards(leftCards,validSets);
				if(min<minimumSoFar){
					minimumSoFar = min;
				}
			}
		}
		
		if(isTripletOrQuadFound(leftCards)){
			List<Set> tripletsAndQuads = findAllTripletsAndQuads(leftCards);
			for(Set s : tripletsAndQuads){
				validSets.add(s);
				for(int i : s.getSet()){
					leftCards.remove(i);	
				}
				int min = findMinimumUnusedCards(leftCards,validSets);
				if(min<minimumSoFar){
					minimumSoFar = min;
				}
			}
		}
		
		return 0;
			
		}	
	}

	
