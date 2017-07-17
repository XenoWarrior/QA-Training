package main;

import java.util.*;

/**
 * Beginner tasks for QA Training
 * @author Ashley Scott 2017
 */
public class Main {

	/**
	 * Main method, entry for the basic tasks in the QA Exercise book.
	 */
	public static void main(String[] args) {
		System.out.println("----- START OF BEGINNER TASKS -----");
		
		BeginnerTasks beginnerTasks = new BeginnerTasks();
		beginnerTasks.runTasks();
		
		System.out.println("----- END OF BEGINNER TASKS -----");

		System.out.println("\n\n----- START OF INTERMEDIATE TASKS -----");
		
		IntermediateTasks intermediateTasks = new IntermediateTasks();
		intermediateTasks.runTasks();
		
		System.out.println("----- END OF INTERMEDIATE TASKS -----");
		
		System.out.println("\n\n----- START OF OOP TASKS -----");
		
		ObjectOrientedTasks oopTasks = new ObjectOrientedTasks();
		oopTasks.runTasks();
		
		System.out.println("----- END OF OOP TASKS -----");
	}

}
