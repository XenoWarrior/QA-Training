package library;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Newspaper extends Item {

	/**
	 * Variable definitions for the class
	 */
	private SimpleDateFormat releaseDate = null;

	/**
	 * Constructor for Newspaper which extends Item
	 * @param itemName, the name for this book
	 * @param itemPages, how many pages this book has
	 * @param itemAvailable, if the item is available
	 * @param getReleaseDate, custom to class, returns the release date
	 */
	public Newspaper(String itemName, int itemPages, boolean itemAvailable, SimpleDateFormat releaseDate) { 
		super(Data.getNewItemId(), itemName, itemPages, itemAvailable);
		this.releaseDate = releaseDate;
	}
	
	/**
	 * Returns the release date of this newspaper
	 */
	public String getReleaseDate() { 
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		
		return dateFormat.format(releaseDate);
	}
	
	@Override
	public String toString() {
		return "Name: " + this.itemName + ", Pages: " + this.itemPages + ", Available: " + this.itemAvailable + ", ReleaseDate: " + this.releaseDate;
	}
	
}
