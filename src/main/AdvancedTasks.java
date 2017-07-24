package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
	 * 
	 * @throws IOException
	 */

	private ArrayList<String> taskStatisticLog = new ArrayList<String>();

	private ArrayList<Integer> batchNumbers;
	private HashMap<Integer, HashMap<Integer, Boolean>> primeBuckets;

	private int numberRange;
	private int maxBucketSize;
	private int neededBuckets;
	private int currentBucket;
	private int totalPrimes;
	private int nhTotalPrimes;

	public void runTasks() {
		System.out.println("\n\n----- START OF ADVANCED TASKS -----");
		
		task21(); // Anagram Word List
		task22(); // 1 to 3 mil Prime Numbers
		
		System.out.println("\n\n----- END OF ADVANCED TASKS -----");
	}

	private void task21() {

		System.out.println("[AdvancedTasks]: Task 21 (Word List anagram Finder):");
		
		try {
			System.out.print("[AdvancedTasks]: Loading word list...");
			ArrayList<String> wordList = readFile("WordList.txt");
			System.out.println(" done");
			
			HashMap<String, String> anagramList = new HashMap<String, String>();
			HashMap<String, Integer> anagramCount = new HashMap<String, Integer>();

			// System.out.println("[AdvancedTasks]: WordList: " + wordList);

			System.out.println("[AdvancedTasks]: Running task...");
			for (String w : wordList) {
				// System.out.print("[AdvancedTasks]: Sort: " + w + " => ");
				// System.out.println(sortStringAlphabetically(w));
				anagramList.put(w, sortStringAlphabetically(w));
			}

			System.out.println(anagramList);

			for (String a : anagramList.values()) {
				if (anagramCount.containsKey(a)) {
					anagramCount.put(a, anagramCount.get(a) + 1);
				} else {
					anagramCount.put(a, 1);
				}
			}

			// System.out.println(anagramCount);
			System.out.print("[AdvancedTasks]: The word(s) with most anagrams has "
					+ Collections.max(anagramCount.values()) + " matches, the value is: ");

			String result = "";
			for (Object o : anagramCount.keySet()) {
				if (anagramCount.get(o).equals(Collections.max(anagramCount.values()))) {
					System.out.println("[" + o + "]");
					result = (String) o;
				}
			}

			// System.out.print("[AdvancedTasks]: The words matching this
			// anagram are: ");

			// for(String w : wordList) {
			// if(result.equals(sortStringAlphabetically(w))) {
			// System.out.print("[" + w + "]");
			// }
			// }
			// System.out.println();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private void task22() {

		int num = 6000000;

		//calculatePrimes(PrimeMode.MODE_COUNT, num);
		calculatePrimes(PrimeMode.MODE_BATCHED, num);
		//calculatePrimes(PrimeMode.MODE_BATCHED_HASHMAP, num);

		System.out.println();
		for (String i : taskStatisticLog) {
			System.out.println(i);
		}

	}

	private void task23() {

	}

	// For 21
	private ArrayList<String> readFile(String file) throws IOException {

		ArrayList<String> wordList = new ArrayList<String>();

		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = br.readLine()) != null) {
				wordList.add(line);
			}
		} catch (IOException e) {
			throw e;
		}

		return wordList;

	}

	// For 21
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

	// For 22
	private void populateBucket(int from, int to) {
		long startTime = System.nanoTime();
		
		for(int i = from; i <= to; i++) {			
			if(isPrime(i)) {
				currentBucket = i / maxBucketSize;
				//System.out.println("[AdvancedTasks]: Current bucket: " + currentBucket);
				
				if(!primeBuckets.containsKey(currentBucket)) { 
					//System.out.println("[AdvancedTasks]: Making new bucket... (index: " + currentBucket + ")");
					primeBuckets.put(currentBucket, new HashMap<Integer, Boolean>());
				}
				
				primeBuckets.get(currentBucket).put(i, true);
			}
		}
		long endTime = System.nanoTime();
		long duration = (endTime - startTime) / 1000000;  //divide by 1000000 to get milliseconds.
		
		System.out.println("[AdvancedTasks]: [BATCH TASK] | Total prime numbers from " + from + " to " + to + " is: " + primeBuckets.get(currentBucket).size() + " | Bucket (" + currentBucket + ") Time: " + duration + " ms");
	}

	// For 22
	private void batchWork(int from, int to) {
		nhTotalPrimes = 0;

		long startTime = System.nanoTime();

		for (int i = from; i <= to; i++) {
			if (isPrime(i)) {
				nhTotalPrimes++;
			}
		}

		long endTime = System.nanoTime();
		long duration = (endTime - startTime) / 1000000; // divide by 1000000 to
															// get milliseconds.

		System.out.println("[AdvancedTasks]: [BATCH TASK] | Total prime numbers from " + from + " to " + to + " is "
				+ nhTotalPrimes + " | Batch Time: " + duration + " ms");

		batchNumbers.add(nhTotalPrimes);
	}

	// For 22
	private void calculatePrimes(PrimeMode pm, int toNumber) {

		String finalOutputResult = "";

		primeBuckets = new HashMap<Integer, HashMap<Integer, Boolean>>();
		batchNumbers = new ArrayList<Integer>();
		numberRange = toNumber;
		maxBucketSize = 3000000;
		neededBuckets = (int) Math.floor(numberRange / maxBucketSize);
		currentBucket = 1;
		totalPrimes = 0;
		nhTotalPrimes = 0;

		int numberRange = toNumber; // 3000000; //2000000000;

		switch (pm) {
		case MODE_BATCHED:
			// without HM, batched
			System.out.println("[AdvancedTasks]: [BATCHED COUNT MODE] | Calculating primes between 1 and " + numberRange
					+ " | Needed Batch Jobs: " + neededBuckets);

			long startTime = System.nanoTime();

			int currentNumber = 1;
			while (currentNumber < numberRange) {
				if (numberRange > maxBucketSize) {
					batchWork(currentNumber, currentNumber + maxBucketSize - 1);
					currentNumber += maxBucketSize;
				} else {
					batchWork(currentNumber, currentNumber + numberRange - 1);
					currentNumber += numberRange;
				}
			}

			for (HashMap<Integer, Boolean> h : primeBuckets.values()) {
				totalPrimes += h.size();
			}

			long endTime = System.nanoTime();
			long duration = (endTime - startTime) / 1000000;

			int finalCount = 0;
			for (int i : batchNumbers) {
				finalCount += i;
			}

			finalOutputResult = "[BATCHED COUNT MODE] | Time Taken: " + duration + " ms";

			System.out.println("[AdvancedTasks]: [OPERATION COMPLETE] | Total prime numbers from 1 to " + numberRange
					+ " is: " + finalCount + " | Total Time Taken: " + duration + " ms\n\n");
			break;

		case MODE_BATCHED_HASHMAP:
			// with HM, batched
			System.out.println("[AdvancedTasks]: [BATCHED HASHMAP MODE] | Calculating primes between 1 and "
					+ numberRange + " | Needed Buckets: " + neededBuckets);
			startTime = System.nanoTime();
			currentNumber = 1;
			while (currentNumber < numberRange) {
				if (numberRange > maxBucketSize) {
					populateBucket(currentNumber, currentNumber + maxBucketSize - 1);
					currentNumber += maxBucketSize;
				} else {
					populateBucket(currentNumber, currentNumber + numberRange - 1);
					currentNumber += numberRange;
				}
			}

			for (HashMap<Integer, Boolean> h : primeBuckets.values()) {
				totalPrimes += h.size();
			}

			endTime = System.nanoTime();
			duration = (endTime - startTime) / 1000000;

			finalOutputResult = "[BATCHED HASHMAP MODE] | Time Taken: " + duration + " ms";

			System.out.println("[AdvancedTasks]: [OPERATION COMPLETE] |  Total prime numbers from 1 to " + numberRange
					+ " is: " + totalPrimes + " | Total Time Taken: " + duration + " ms");

			break;

		case MODE_COUNT:
			// without HM, no batch
			System.out.println("[AdvancedTasks]: [COUNT ONLY MODE] | Calculating primes between 1 and " + numberRange);

			startTime = System.nanoTime();

			for (int i = 1; i <= numberRange; i++) {
				if (isPrime(i)) {
					nhTotalPrimes++;
				}
			}

			endTime = System.nanoTime();
			duration = (endTime - startTime) / 1000000;

			finalOutputResult = "[COUNT ONLY MODE] | Time Taken: " + duration + " ms";

			System.out.println("[AdvancedTasks]: [OPERATION COMPLETE] | Total prime numbers from 1 to " + numberRange
					+ " is: " + nhTotalPrimes + " | Total Time Taken: " + duration + " ms\n\n");
			break;
		}

		taskStatisticLog.add(finalOutputResult);
	}

	// For 22
	public static boolean isPrime(int num) {
		// Initial check, non primes at the start
		if (num > 2 && num % 2 == 0) {
			return false;
		}

		// Now for all numbers
		int top = (int) Math.sqrt(num) + 1;
		for (int i = 3; i < top; i += 2) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}

}
