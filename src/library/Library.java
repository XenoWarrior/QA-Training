package library;

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
	 * Adds a new person to the personManager
	 * @param p, the person object
	 * @return, if the operation was successful
	 */
	public boolean addPerson(Person p) { 
		if(personManager.addPerson(p) != -1) { 
			return true;
		}
		
		return true;
	}

	/**
	 * Removes a person from the personManager
	 * @param id, the person id
	 * @return, if the operation was successful
	 */
	public boolean removePerson(int id) {
		return personManager.removePerson(id);
	}
	
	/**
	 * Updates a person the personManager
	 * @param id, id of the person
	 * @param p, the new person object
	 * @return, if the operation was successful
	 */
	public boolean updatePerson(int id, Person p) {
		return personManager.updatePerson(id, p);
	}
	
	/**
	 * Gets a person by their ID number
	 * @param id, the ID of the person
	 * @return, the person object itself
	 * @throws Exception, if no person exists at that ID
	 */
	public Person getPerson(int id) throws Exception {
		return personManager.getPerson(id);
	}
	
	/**
	 * Adds a new item to the itemList
	 * @param i, the item object
	 * @return, if the operation was successful
	 */
	public boolean addItem(Item i) { 
		if(itemManager.addItem(i) != -1) { 
			return true;
		}
		
		return false;
	}

	/**
	 * Removes an item from the itemManager
	 * @param id, the item id
	 * @return, if the operation was successful
	 */
	public boolean removeItem(int id) { 
		if(itemManager.removeItem(id)) { 
			return true;
		}
		
		return false;
	}

	/**
	 * Updates a person in the itemManager
	 * @param id, the id
	 * @param i, the item itself
	 * @return, if the operation was successful
	 */
	public boolean updateItem(int id, Item i) { 
		return itemManager.updateItem(id, i);
	}
	
	/**
	 * 
	 * @param id, the item ID to find
	 * @return, the item object itself
	 * @throws Exception, if no item was found
	 */
	public Item getItem(int id) throws Exception {
		return itemManager.getItem(id);
	}
}
