package library;

import java.util.ArrayList;

public interface Person {

	String personName = "";
	int personAge = 0;
	String personAddress = "";
	
	ArrayList<Integer> rentedList = new ArrayList<Integer>();

	public String getName();
	public int getAge();
	public String getAddress();
	
	public String getType();
	
	public boolean doTask();

	public ArrayList<Integer> getItems();
	public boolean addItem(int itemId);
	public boolean removeItem(int itemId);
}
