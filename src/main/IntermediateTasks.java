package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class IntermediateTasks {

	/**
	 * Runs the tasks from the intermediate section
	 */
	public void runTasks() {
		System.out.println(pickClosest(18, 21)); // 21
		System.out.println(pickClosest(20, 18)); // 20
		System.out.println(pickClosest(22, 22)); // 0

		System.out.println("Sum is: " + uniqueSum(1, 2, 3)); // 6
		System.out.println("Sum is: " + uniqueSum(3, 3, 3)); // 0
		System.out.println("Sum is: " + uniqueSum(1, 1, 2)); // 2

		System.out.println("isSummer is False and the temp is 70, should be True: " + inRange(70, false)); // True
		System.out.println("isSummer is False and the temp is 91, should be False: " + inRange(91, false)); // False
		
		System.out.println("isSummer is True and the temp is 70, should be False: " + inRange(70, true)); // False
		System.out.println("isSummer is True and the temp is 91, should be True: " + inRange(91, true)); // True
	}

	/**
	 * Picks the closest number to 21 which is under 21.
	 * 
	 * @param a first number
	 * @param b second number
	 * @return the number
	 */
	private int pickClosest(int a, int b) {
		return (a > 21 && b > 21) ? 0 : (a > b) ? a : b;
	}

	/**
	 * Adds all numbers in a list, but only those which are not duplicates.
	 * Example: Original List: [1, 2, 3], Removed Duplicates: [1, 2, 3] Sum is:
	 * 6
	 * 
	 * Original List: [3, 3, 3], Removed Duplicates: [] Sum is: 0
	 *
	 * Original List: [1, 1, 2], Removed Duplicates: [2] Sum is: 2
	 *
	 * @param a
	 * @param b
	 * @param c
	 * @return the sum of the new list without duplicates.
	 */
	private int uniqueSum(int a, int b, int c) {

		ArrayList<Integer> numberList = new ArrayList<Integer>();
		numberList.add(a);
		numberList.add(b);
		numberList.add(c);

		System.out.print("Original List: " + numberList);

		int aOccurences = Collections.frequency(numberList, a);
		int bOccurences = Collections.frequency(numberList, b);
		int cOccurences = Collections.frequency(numberList, c);

		if (aOccurences > 1) {
			numberList.remove((Object) a);
		}
		if (bOccurences > 1) {
			numberList.remove((Object) b);
		}
		if (cOccurences > 1) {
			numberList.remove((Object) c);
		}
		System.out.println(", Removed Duplicates: " + numberList);

		int total = 0;
		for (int i = 0; i < numberList.size(); i++) {
			total += numberList.get(i);
		}

		return total;
	}

	private boolean inRange(int temp, boolean isSummer) {

		if (isSummer) {
			if (temp > 90 && temp < 100) {
				return true;
			}
			
			return false;
		} else {
			if (temp > 60 && temp < 90) {
				return true;
			}
			
			return false;
		}
	}
}