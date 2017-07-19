package library;

import java.util.ArrayList;

public class Member implements Person {

	private int memberId = 0;
	
	public Member(int memberId) {
		this.memberId = memberId;
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
		System.out.println("Member is renting a book.");
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
	
	public int getMemberId() { 
		return this.memberId;
	}
	
}
