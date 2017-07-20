package library;

import java.util.HashMap;

public class ItemManager {

	/**
	 * Variable definitions for the class
	 */
	private HashMap<Integer, Item> itemList = new HashMap<Integer, Item>();

	/**
	 * Constructor stub
	 */
	public ItemManager() {

	}
	
	/**
	 * Returns a list of items in the "database"
	 */
	public HashMap<Integer, Item> getItemList() { 
		return itemList;
	}
	
	/**
	 * Adds an item to the item list
	 * @param item, the item object to add
	 * @return, item id is returned
	 */
	public int addItem(Item item) {
		try { 
			itemList.put(item.getId(), item);
			System.out.println("[DEBUG]: Added Item (" + item.getClass().getName() + ") with the ID: " + item.getId());
		}
		catch(Exception e) { 
			System.out.println("[DEBUG]: Failed to add Item (" + item.getClass().getName() + "), does an item already exist at ID: " + item.getId() + "?");
			return -1;
		}
		
		return item.getId();
	}

	/**
	 * Gets an item by ID
	 * @param itemId, the id to find
	 * @return, the item object
	 * @throws Exception, if there is no object by the specified id
	 */
	public Item getItem(int itemId) throws Exception {
		if(itemList.containsKey(itemId)) {
			return itemList.get(itemId);
		}
		
		throw new Exception("Unable to find an item by ID: " + itemId);
	}
	
	/**
	 * Removes an item by ID
	 * @param id, the item to remove
	 * @return, if the operation was successful
	 */
	public boolean removeItem(int id) {
		if(itemList.containsKey(id)) { 
			itemList.remove(id);
			return true;
		}
		
		return false;
	}
	
	/**
	 * Updates an item at a specific ID and replaces it with a new version of the item
	 * @param id, the id to modify
	 * @param item, the item object itself
	 * @return, if the operation was successful
	 */
	public boolean updateItem(int id, Item item) {
		if(itemList.containsKey(id)) { 
			itemList.put(id, item);
			
			return true;
		}
		
		return false;
	}
	
	/**
	 * Updates an item state and sets it to either true or false based on the parameter
	 * @param itemId, the item id to update
	 * @param itemState, the new state to set to it
	 * @return, if the operation was successful
	 */
	public boolean updateItem(int itemId, boolean itemState) { 
		if(itemList.containsKey(itemId)) {
			return itemList.get((int)itemId).setAvailability(itemState);
		}
		
		return false;
	}
}
