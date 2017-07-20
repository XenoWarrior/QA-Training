package library;

public class Magazine extends Item {

	/**
	 * Variable definitions for the class
	 */
	private String magazineCategory = "";

	/**
	 * Constructor for Magazine which extends Item
	 * @param itemId, the id for this book
	 * @param itemName, the name for this book
	 * @param itemPages, how many pages this book has
	 * @param itemAvailable, if the item is available
	 * @param magazineCategory, custom to class, what category the magazine is
	 */
	public Magazine(int itemId, String itemName, int itemPages, boolean itemAvailable, String magazineCategory) {
		super(itemId, itemName, itemPages, itemAvailable);
		this.magazineCategory = magazineCategory;
	}
	
	/**
	 * Gets the category for this magazine
	 * @return, the category name as a string
	 */
	public String getCategory() { 
		return this.magazineCategory;
	}
	
}
