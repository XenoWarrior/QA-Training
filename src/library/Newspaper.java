package library;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Newspaper extends Item {

	/**
	 * Variable definitions for the class
	 */
	private SimpleDateFormat releaseDate = null;

	/**
	 * Constructor for Newspaper which extends Item
	 * @param itemId, the id for this book
	 * @param itemName, the name for this book
	 * @param itemPages, how many pages this book has
	 * @param itemAvailable, if the item is available
	 * @param getReleaseDate, custom to class, returns the release date
	 */
	public Newspaper(int itemId, String itemName, int itemPages, boolean itemAvailable, SimpleDateFormat releaseDate) { 
		super(itemId, itemName, itemPages, itemAvailable);
		this.releaseDate = releaseDate;
	}
	
	/**
	 * Returns the release date of this newspaper
	 */
	public String getReleaseDate() { 
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		
		return dateFormat.format(releaseDate);
	}
	
}
