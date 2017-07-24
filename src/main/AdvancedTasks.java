package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

public class AdvancedTasks implements Task {

	/**
	 * HashMaps – Anagrams Create a method that reads words from a file, one per
	 * line, and stores them in an Array. -> Done Create a method that takes a
	 * String as a parameter, and returns a sorted version of the string back.
	 * (bac->abc) -> Done
	 * 
	 * Using these methods and a HashMap, perform the following; • Find the word
	 * that has the most anagrams located in the list • If two words have the
	 * same amount of anagrams, output the word that is longer. • If two words
	 * have the same length and the same amount of anagrams, output both.
	 * 
	 * Email your lecturer to get access to the wordlist once your code is
	 * ready. Until then create your own text file to test it on. Hint – The key
	 * will be the sorted word, the value will be an arraylist of the anagrams
	 * found.
	 */

	private ArrayList<String> readFile(String file) {

		ArrayList<String> wordList = new ArrayList<String>();

		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = br.readLine()) != null) {
				wordList.add(line);
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		return wordList;

	}

	private String sortStringAlphabetically(String word) {

		ArrayList<Character> charList = new ArrayList<Character>();

		char[] charArray = word.toLowerCase().toCharArray();
		for (char c : charArray) {
			charList.add(c);
		}

		Collections.sort(charList);

		String finalString = "";
		for (Character c : charList) {
			finalString += c;
		}

		return finalString;
	}

	private void task21() {

		ArrayList<String> wordList = readFile("WordList.txt");
		HashMap<String, String> anagramList = new HashMap<String, String>();
		HashMap<String, Integer> anagramCount = new HashMap<String, Integer>();

		//System.out.println("[AdvancedTasks]: WordList: " + wordList);

		for (String w : wordList) {
			//System.out.print("[AdvancedTasks]: Sort: " + w + " => ");
			//System.out.println(sortStringAlphabetically(w));
			anagramList.put(w, sortStringAlphabetically(w));
		}

		//System.out.println(anagramList);

		for (String a : anagramList.values()) {
			if (anagramCount.containsKey(a)) {
				anagramCount.put(a, anagramCount.get(a) + 1);
			} else {
				anagramCount.put(a, 1);
			}
		}

		//System.out.println(anagramCount);
		System.out.print("[AdvancedTasks]: The word(s) with most anagrams has " + Collections.max(anagramCount.values()) + " matches, the value is: ");

		
		String result = "";
		for (Object o : anagramCount.keySet()) {
			if (anagramCount.get(o).equals(Collections.max(anagramCount.values()))) {
				System.out.println("[" + o + "]");
				result = (String)o;
			}
		}
		
		//System.out.print("[AdvancedTasks]: The words matching this anagram are: ");
		
		//for(String w : wordList) { 
		//	if(result.equals(sortStringAlphabetically(w))) { 
		//		System.out.print("[" + w + "]");
		//	}
		//}
		//System.out.println();

	}

	public void runTasks() {
		task21();
	}

}
