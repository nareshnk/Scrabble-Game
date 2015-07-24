/**
 * Created by test on 7/22/2015.
 * by team
 */

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Anagrams {
    
	public Map<String, String> map = new HashMap<String, String>();
	
    
	public String sortString(String original) {
        char[] chars = original.toCharArray();
        Arrays.sort(chars);
        String sorted = new String(chars);
        return sorted;
    }

    public void addToHash(String word){
        String sortedWord = sortString(word);
        if (map.containsKey(sortedWord)) {
            map.put(sortedWord, map.get(sortedWord) + " " + word);
        } else {
            map.put(sortedWord, word);
        }
    }

    public String getMap() {
        String collectedAnagrams = "";
        Iterator<String> keySetIterator = map.keySet().iterator();
        while(keySetIterator.hasNext()) {
            String key = keySetIterator.next();
            String anagramList = map.get(key);
            if (anagramList.indexOf(" ")  != -1){
                collectedAnagrams = collectedAnagrams + "\n" + anagramList;
            }

        }
        return collectedAnagrams;
    }

    public void readFile(String path){
        BufferedReader br = null;
        try {
            String sCurrentLine;
            br = new BufferedReader(new FileReader(path));
            while ((sCurrentLine = br.readLine()) != null) {
                this.addToHash(sCurrentLine);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    public void writeToFile(String path) {
        try {

            String content = getMap();

            File file = new File(path);

            // if file doesnt exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(content);
            bw.close();

            System.out.println("Write complete!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        }
}
