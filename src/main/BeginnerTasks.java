package main;

import java.util.Random;

public class BeginnerTasks {

	/**
	 * Main method for this object, for the basic tasks in the QA Exercise book.
	 */
	public void runTasks() {

		// Task: Hello World!
		System.out.println("1) Hello world!");

		// Task: Assignment.
		String helloWorld = "2) Hello world!";
		System.out.println(helloWorld);

		// Task: Parameters.
		helloWorld("3) Hello world!");

		// Task: Return Types.
		System.out.println(helloWorldReturn() + "\n\n");

		// Task: Parameters/Operators.
		// Included tasks: Conditionals, Conditionals 2 and Iteration.
		System.out.println("5) Add: 2 + 3 = " + doCalculation(2, 3, true));
		System.out.println("6) Multiply: 3 * 3 = " + doCalculation(3, 3, false) + "\n\n");

		System.out.println("7) Should be 1: " + doCalculation(1, 0, false));
		System.out.println("8) Should be 3: " + doCalculation(1, 2, true));

		System.out.println("9) Test, should be 3: " + doCalculation(3, 0, false));
		System.out.println("10) Test, should be 5: " + doCalculation(0, 5, false) + "\n\n");

		// Task: Arrays.
		int numberArray[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 };

		System.out.println(
				"11) Task: Arrays (index 0 and 4), result: " + doCalculation(numberArray[0], numberArray[4], true));
		System.out.println(
				"11) Task: Arrays (index 2 and 5), result: " + doCalculation(numberArray[2], numberArray[5], true));
		System.out.println(
				"11) Task: Arrays (index 7 and 3), result: " + doCalculation(numberArray[7], numberArray[3], true));
		System.out.println("11) Task: Arrays (index 1 and 9, is zero), result (should be 2): "
				+ doCalculation(numberArray[1], numberArray[9], true));

		// Task: Iteration/Arrays
		System.out.print("12) Printing array: ");
		printArray(numberArray);

		// Task: Iteration/Arrays 2
		System.out.println("13) Generating a random number array and printing values: ");
		int[] newArray = new int[10];
		newArray = populateArray();

		System.out.println("14) Now lets multiply each result by 10!: ");
		for (int i = 0; i < newArray.length; i++) {
			int item = newArray[i];
			newArray[i] *= 10;
			System.out.println(item + " * 10 = " + newArray[i]);
		}
	}

	/**
	 * Hello World method which accepts a parameter. Prints parameter to
	 * console.
	 * 
	 * @param param
	 *            input string
	 */
	private static void helloWorld(String param) {
		System.out.println(param);
	}

	/**
	 * Called to test return types.
	 * 
	 * @return returns "4) Hello world".
	 */
	private static String helloWorldReturn() {
		return "4) Hello world!";
	}

	/**
	 * Does a calculation or returns the non-zero number.
	 * 
	 * @param a
	 *            the first number
	 * @param b
	 *            the second number
	 * @param add
	 *            if it should add or multiply (true add, false multiply)
	 * 
	 * @return returns the value based on conditions
	 */
	private static int doCalculation(int a, int b, boolean add) {
		// Checks if a number is zero
		if (a < 1 | b < 1) {
			int zeroCheck = a < 1 ? b : a;
			doIteration(zeroCheck);
			return zeroCheck;
		}

		// Do the calculations
		// System.out.println(returnValue);
		return add ? a + b : a * b;
	}

	/**
	 * Does the iteration task
	 */
	private static void doIteration(int value) {
		// Task: Iteration
		for (int i = 0; i < 10; i++) {
			System.out.println("Iteration Task: " + value);
		}
	}

	/**
	 * Prints an array of integers.
	 */
	private static void printArray(int array[]) {
		// Can also use "int i = 0; i < array...etc...".
		for (int i : array) {
			System.out.print(i + " ");
		}

		System.out.println();
	}

	/**
	 * Creates a new array of integers
	 */
	private static int[] populateArray() {
		int[] a = new int[10];

		Random randomNumberGenerator = new Random();
		for (int i = 0; i < 10; i++) {
			a[i] = randomNumberGenerator.nextInt((9 - 0) + 1);
			System.out.println("i = " + i + " number is: " + a[i]);
		}

		return a;
	}

}
