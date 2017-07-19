package library;

public class Book extends Item {

	private boolean hardBack = false;
	
	public Book(int itemId, String itemName, int itemPages, boolean itemAvailable, boolean hardBack) { 
		super(itemId, itemName, itemPages, itemAvailable);
		this.hardBack = hardBack;
	}
	
	public boolean getReleaseDate() { 
		return this.hardBack;
	}
}
