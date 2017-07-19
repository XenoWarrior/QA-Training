package library;

public class Library {
	
	private PersonManager personManager = new PersonManager();
	private ItemManager itemManager = new ItemManager();
	
	/**
	 * Constructor for the Library.
	 */
	public Library() { 
		
	}
	
	/**
	 * Checks an item out.
	 * 	Adds the itemId to the member's rented list then sets the availability to "false".
	 * @param itemId, the item id itself.
	 * @param personId, the person id itself.
	 * @return, if the checkout was successful.
	 */
	public boolean checkoutItem(int itemId, int personId) {
		if(itemManager.updateItem(itemId, true)) {
			Person p = personManager.getPersonList().get(personId);
			p.addItem(itemId);
			personManager.updatePerson(personId, p);
			
			return true;
		}

		return false;
	}
	
	/**
	 * Checks an item in.
	 * 	Removes the item from the memeber's rented list then sets the availability to "true".
	 * @param itemId, the item id itself.
	 * @param personId, the person id itself.
	 * @return, if the checkin was successful.
	 */
	public boolean checkinItem(int itemId, int personId) { 
		if(itemManager.updateItem(itemId, false)) {
			Person p = personManager.getPersonList().get(personId);
			p.removeItem(itemId);
			personManager.updatePerson(personId, p);
			
			return true;
		}

		return false;
	}
}
