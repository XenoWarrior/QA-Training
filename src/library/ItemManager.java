package library;

import java.util.HashMap;

public class ItemManager {
	
	private HashMap<Integer, Item> itemList = new HashMap<Integer, Item>();

	public ItemManager() {
		
	}
	
	public HashMap<Integer, Item> getItemList() { 
		return itemList;
	}
	
	public int addItem(Item item) { 
		return 0;
	}
	
	public boolean removeItem(int id) {
		return false;
	}
	
	public boolean updateItem(int id, Item item) {
		return false;
	}
	
	public boolean updateItem(int itemId, boolean itemState) { 
		return itemList.get(itemId).setAvailability(itemState);
	}
}
