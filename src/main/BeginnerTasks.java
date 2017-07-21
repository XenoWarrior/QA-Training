package main;

import java.util.Random;

public class BeginnerTasks implements Task {

	/**
	 * Main method for this object, for the basic tasks in the QA Exercise book.
	 */
	public void runTasks() {

		System.out.println("----- START OF BEGINNER TASKS -----");
		
		// Task: Hello World!
		System.out.println("Task 1 (Hello World!), print Hello world! directly.");

		// Task: Assignment.
		String helloWorld = "\nTask 2 (Assignment), print Hello world! by assignment to variable.";
		System.out.println(helloWorld);

		// Task: Parameters.
		helloWorld("\nTask 3 (Parameters), print Hello world! via method and parameter.");

		// Task: Return Types.
		System.out.println(helloWorldReturn());

		// Task: Parameters/Operators.
		// Included tasks: Conditionals, Conditionals 2 and Iteration.
		System.out.println("\nTask 5 (Parameters/Operators), add two values via method and parameter: Add 2 + 3 = " + doCalculation(2, 3, true));
		System.out.println("\nTask 6 (Conditionals), include boolean to decide if a calculation is ADD or MULTIPLY: Multiply: 3 * 3 = " + doCalculation(3, 3, false));

		System.out.println("Task 7 (Conditionals 2), result (should be 1): " + doCalculation(1, 0, false));
		System.out.println("Task 7 (Conditionals 2), result (should be 3): " + doCalculation(1, 2, true));

		System.out.println("Task 7 (Conditionals 2), result (should be 3): " + doCalculation(3, 0, false));
		System.out.println("Task 7 (Conditionals 2), result (should be 5): " + doCalculation(0, 5, false));

		// Task: Arrays.
		int numberArray[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 };

		System.out.println("\nTask 9 (Arrays), (index 0 and 4), result (should be: 6): " + doCalculation(numberArray[0], numberArray[4], true));
		System.out.println("Task 9 (Arrays), (index 2 and 5), result (should be: 9): " + doCalculation(numberArray[2], numberArray[5], true));
		System.out.println("Task 9 (Arrays), (index 7 and 3), result (should be: 12): " + doCalculation(numberArray[7], numberArray[3], true));
		System.out.println("Task 9 (Arrays), (index 1 and 9), result (should be: 2): " + doCalculation(numberArray[1], numberArray[9], true));

		// Task: Iteration/Arrays
		System.out.print("\nTask 10 (Iteration/Arrays), result (should be array of numbers): ");
		printArray(numberArray);

		// Task: Iteration/Arrays 2
		System.out.print("\nTask 11 (Iteration/Arrays), result (should be randomly generated array): ");
		int[] newArray = new int[10];
		newArray = populateArray();
		printArray(newArray);

		System.out.print("Task 11 (Iteration/Arrays), result (should be the array above, multiplied by 10 each time): ");
		for (int i = 0; i < newArray.length; i++) {
			newArray[i] *= 10;
		}
		printArray(newArray);
		
		System.out.println("----- END OF BEGINNER TASKS -----");
		
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
		return "\nTask 4 (Return Types), print Hello world! via method return value.";
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
		System.out.println("\n------------------------------------");
		// Task: Iteration
		for (int i = 0; i < 10; i++) {
			System.out.println("Task 8 (Iteration), Result: " + value);
		}
		System.out.println("------------------------------------");
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
			//System.out.println("i = " + i + " number is: " + a[i]);
		}

		return a;
	}

}
