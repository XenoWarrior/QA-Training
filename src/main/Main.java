package main;


import java.util.ArrayList;

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

		ArrayList<Task> taskList = new ArrayList<Task>();

		taskList.add(new BeginnerTasks());
		taskList.add(new IntermediateTasks());
		taskList.add(new ObjectOrientedTasks());
		taskList.add(new AdvancedTasks());
		taskList.add(new TestTasks());
		
		for(Task t : taskList) {
			t.runTasks();
		}
		
	}

}
