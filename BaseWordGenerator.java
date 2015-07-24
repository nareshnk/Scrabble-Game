import java.util.*;
import java.lang.*;
import java.io.*;


class BaseWordGenerator
{
	private static final String FILE = "C://Users/test/Documents/GitHub/ScrabbleWordGenerator/sowpods-scrabble-list.txt";
	private static final String OUTPUT_FILE = "C://Users/test/Documents/GitHub/ScrabbleWordGenerator/output.txt";
	
	public static boolean ifPresent(String word){
		
		
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		Anagrams AnagramCollection = new Anagrams();
        AnagramCollection.readFile(FILE);
		
		
	}
}