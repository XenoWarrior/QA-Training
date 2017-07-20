package library;

import java.text.SimpleDateFormat;

public class Library {

	/**
	 * Variable definitions for the class
	 */
	private PersonManager personManager = new PersonManager();
	private ItemManager itemManager = new ItemManager();
	
	/**
	 * Constructor stub.
	 */
	public Library() { 
		itemManager.addItem(new Book(Data.getNewItemId(), "Somebook 1", 11, true, true));
		itemManager.addItem(new Book(Data.getNewItemId(), "Somebook 2", 12, true, false));

		itemManager.addItem(new Magazine(Data.getNewItemId(), "SomeMagazine 1", 15, true, "Gossip"));
		itemManager.addItem(new Magazine(Data.getNewItemId(), "SomeMagazine 2", 16, true, "Cooking"));
		
		itemManager.addItem(new Newspaper(Data.getNewItemId(), "SomeMagazine 1", 15, true, new SimpleDateFormat("yyyy/MM/dd HH:mm:ss")));
		itemManager.addItem(new Newspaper(Data.getNewItemId(), "SomeMagazine 2", 16, true, new SimpleDateFormat("yyyy/MM/dd HH:mm:ss")));
		
		personManager.registerPerson(new Member(Data.getNewPersonId(), "Someone 1", 20, "10 Some Street, Some City, Some Country"));
		personManager.registerPerson(new Member(Data.getNewPersonId(), "Someone 2", 21, "11 Some Street, Some City, Some Country"));
		personManager.registerPerson(new Member(Data.getNewPersonId(), "Someone 2", 22, "12 Some Street, Some City, Some Country"));
		personManager.registerPerson(new Member(Data.getNewPersonId(), "Someone 3", 23, "13 Some Street, Some City, Some Country"));
		personManager.registerPerson(new Member(Data.getNewPersonId(), "Someone 4", 24, "14 Some Street, Some City, Some Country"));
	}
	
	/**
	 * Checks an item out.
	 * Adds the itemId to the member's rented list then sets the availability to "false".
	 * @param itemId, the item id itself.
	 * @param personId, the person id itself.
	 * @return, if the checkout was successful.
	 */
	public boolean checkoutItem(int itemId, int personId) {
		
		try {
			Person p = personManager.getPerson(personId);
			Item i = itemManager.getItem(itemId);
			
			if(itemManager.updateItem(itemId, false)) {
				p.removeItem(itemId);
				personManager.updatePerson(personId, p);
				
				System.out.println("[DEBUG]: Successfully checked item [" + itemId + "] " + i.getName() + " out for [" + p.getPersonId() + "] " +p.getName());
				
				return true;
			}
			
		}
		catch (Exception e) {
			System.out.println("[DEBUG]: Failed to check item [" + itemId + "] out for person: [" + personId + "], " + e.getMessage());
			return false;
		}

		System.out.println("[DEBUG]: Failed to check item [" + itemId + "] out for person: [" + personId + "], item is already checked out.");
		
		return false;
		
	}
	
	/**
	 * Checks an item in.
	 * Removes the item from the memeber's rented list then sets the availability to "true".
	 * @param itemId, the item id itself.
	 * @param personId, the person id itself.
	 * @return, if the check in was successful.
	 */
	public boolean checkinItem(int itemId, int personId) { 
		
		try {
			Person p = personManager.getPerson(personId);
			Item i = itemManager.getItem(itemId);
			
			if(itemManager.updateItem(itemId, true)) {
				p.removeItem(itemId);
				personManager.updatePerson(personId, p);
				
				System.out.println("[DEBUG]: Successfully checked item [" + itemId + "] " + i.getName() + " in for [" + p.getPersonId() + "] " +p.getName());
				
				return true;
			}
			
		}
		catch (Exception e) {
			System.out.println("[DEBUG]: Failed to check item [" + itemId + "] in for person: [" + personId + "], " + e.getMessage());
			return false;
		}

		System.out.println("[DEBUG]: Failed to check item [" + itemId + "] in for person: [" + personId + "], item is already checked in.");
		
		return false;
		
	}

	/**
	 * 
	 * THE BELOW METHOD STUBS CAN BE USED IF THE PROGRAM REQUIRES INPUT.
	 * BUT, FOR THE SAKE OF TESTING, THIS IS NOT NEEDED.
	 * 
	 */
	
	/**
	 * Adds a new person to the personManager
	 * @param p, the person object
	 * @return, if the operation was successful
	 */
	public boolean addPerson(Person p) { 
		return false;
	}

	/**
	 * Removes a person from the personManager
	 * @param id, the person id
	 * @return, if the operation was successful
	 */
	public boolean removePerson(int id) {  
		return false;
	}
	/**
	 * Adds a new item to the itemList
	 * @param i, the item object
	 * @return, if the operation was successful
	 */
	public boolean addItem(Item i) { 
		return false;
	}

	/**
	 * Removes an item from the itemManager
	 * @param id, the item id
	 * @return, if the operation was successful
	 */
	public boolean removeItem(int id) {  
		return false;
	}
}
