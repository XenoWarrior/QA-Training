package library;

import java.util.Date;

public class Newspaper extends Item {

	private Date releaseDate = new Date();
	
	public Newspaper(int itemId, String itemName, int itemPages, boolean itemAvailable, Date releaseDate) { 
		super(itemId, itemName, itemPages, itemAvailable);
		this.releaseDate = releaseDate;
	}
	
	public Date getReleaseDate() { 
		return this.releaseDate;
	}
	
}
