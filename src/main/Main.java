package main;

import library.Library;
import tests.*;

/**
 * Beginner tasks for QA Training
 * 
 * @author Ashley Scott 2017
 */
public class Main {

	/**
	 * Main method, entry for the basic tasks in the QA Exercise book.
	 */
	public static void main(String[] args) {

		BeginnerTasks beginnerTasks = new BeginnerTasks();
		beginnerTasks.runTasks();

		IntermediateTasks intermediateTasks = new IntermediateTasks();
		intermediateTasks.runTasks();

		ObjectOrientedTasks oopTasks = new ObjectOrientedTasks();
		oopTasks.runTasks();

		System.out.println("\n\n----- RUNNING JUNIT TESTS -----");

		System.out.println("Running unit test for Person:");
		System.out.println("--------------------------------------------\nConsole Output (if any):");
		TestPeople p = new TestPeople();
		p.test();
		System.out.println("--------------------------------------------");
		System.out.println(">>>> Success!\n\n");

		System.out.println("Running unit test for Garage:");
		System.out.print("--------------------------------------------\nConsole Output (if any):\n");
		TestGarage g = new TestGarage();
		g.test();
		System.out.println("--------------------------------------------");
		System.out.println(">>>> Success!\n\n");

		System.out.println("Running unit test for PaintWizard:");
		System.out.print("--------------------------------------------\nConsole Output (if any):\n");
		TestPaint w = new TestPaint();
		w.test();
		System.out.println("--------------------------------------------");
		System.out.println(">>>> Success!");

		System.out.println("\n\n----- ALL TESTS PASSED! -----");
		

		System.out.println("\n\n----- START LIBRARY SYSTEM -----\n");
		
		Library l = new Library();

		l.checkoutItem(-1, 0);
		l.checkoutItem(0, -1);
		
		l.checkoutItem(0, 0);
		l.checkoutItem(0, 0);

		l.checkinItem(0, 0);
		l.checkinItem(0, 0);
		
		System.out.println("\n----- END LIBRARY SYSTEM -----");
		
	}

}
