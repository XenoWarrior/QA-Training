package library;

public class Magazine extends Item {

	private String magazineCategory = "";
	
	public Magazine(int itemId, String itemName, int itemPages, boolean itemAvailable, String magazineCategory) {
		super(itemId, itemName, itemPages, itemAvailable);
		this.magazineCategory = magazineCategory;
	}
	
	public String getCategory() { 
		return this.magazineCategory;
	}
	
}
