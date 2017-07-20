package library;

import java.util.ArrayList;

public class Staff implements Person {

	/**
	 * Variable definitions for the class
	 */
	private int personId = 0;
	private String personName = "";
	private int personAge = 0;
	private String personAddress = "";
	private String jobTitle = "";
	
	private ArrayList<Integer> rentedList = new ArrayList<Integer>();

	/**
	 * Constructor
	 * @param personName, the name for the new person
	 * @param personAge, the age for the new person
	 * @param personAddress, the address for the new person
	 * @param jobTitle, the job title for the new person
	 */
	public Staff(String personName, int personAge, String personAddress, String jobTitle) { 
		this.personId = Data.getNewPersonId();
		this.personName = personName;
		this.personAge = personAge;
		this.personAddress = personAddress;
		this.jobTitle = jobTitle;
	}

	/**
	 * Gets the person ID
	 */
	public int getPersonId() { 
		return this.personId;
	}
	
	/**
	 * Gets the name of the person
	 */
	public String getName() { 
		return this.personName;
	}
	
	/**
	 * Gets the age of the person
	 */
	public int getAge() {
		return this.personAge;
	}

	/**
	 * Gets the address of the person
	 */
	public String getAddress() {
		return this.personAddress;
	}
	
	/**
	 * Gets the class name of this person
	 */
	public String getType() { 
		return this.getClass().getName();
	}
	
	/**
	 * Does a unique task to this class, but can still be treated as Person
	 */
	public boolean doTask() {
		System.out.println("Staff member is working.");
		return true;
	}
	
	/**
	 * Adds an ItemId to this person record
	 */
	public boolean addItem(int itemId) {
		return this.rentedList.add(itemId);
	}
	
	/**
	 * Removes an ItemId from this person record
	 */
	public boolean removeItem(int itemId) {
		return this.rentedList.remove((Object)itemId);
	}
	
	/**
	 * Returns a list of items this person has rented
	 */
	public ArrayList<Integer> getItems() { 
		return this.rentedList;
	}
	
	/**
	 * Returns the staff member's job title
	 */
	public String getStaffTitle() {
		return this.jobTitle; 
	}
}
