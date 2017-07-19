package library;

import java.util.ArrayList;

public class Staff implements Person {

	private String jobTitle = "";
	
	public Staff(String jobTitle) { 
		this.jobTitle = jobTitle;
	}
	
	public String getName() { 
		return personName;
	}
	
	public int getAge() {
		return personAge;
	}
	
	public String getAddress() {
		return personAddress;
	}
	
	public String getType() { 
		return this.getClass().getName();
	}
	
	public boolean doTask() {
		System.out.println("Staff member is working.");
		return true;
	}

	public boolean addItem(int itemId) {
		return rentedList.add(itemId);
	}

	public boolean removeItem(int itemId) {
		return rentedList.remove((Object)itemId);
	}
	
	public ArrayList<Integer> getItems() { 
		return rentedList;
	}
	
	public String getJobTitle() { 
		return this.jobTitle;
	}
	
}
