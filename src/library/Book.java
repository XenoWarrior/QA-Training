package library;

public class Book extends Item {

	/**
	 * Variable definitions for the class
	 */
	private boolean hardBack = false;
	
	/**
	 * Constructor for Book which extends Item
	 * @param itemName, the name for this book
	 * @param itemPages, how many pages this book has
	 * @param itemAvailable, if the item is available
	 * @param hardBack, custom to class, if the book is hardback or not
	 */
	public Book(String itemName, int itemPages, boolean itemAvailable, boolean hardBack) { 
		super(Data.getNewItemId(), itemName, itemPages, itemAvailable);
		this.hardBack = hardBack;
	}
	
	/**
	 * Simply returns if the book is a hardback book or not
	 * @return
	 */
	public boolean isHardback() { 
		return this.hardBack;
	}
	
	@Override
	public String toString() {
		return "{ \"name\": \"" + this.itemName + "\", \"pages\": \"" + this.itemPages + "\", \"available\": \"" + this.itemAvailable + "\", \"hardback\": \"" + this.hardBack + "\"}";
	}
}
