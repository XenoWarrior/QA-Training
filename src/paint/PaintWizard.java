package paint;

import java.util.ArrayList;

public class PaintWizard {
	
	ArrayList<Paint> paintList = new ArrayList<Paint>();
	
	public PaintWizard() {
		paintList.add(new Paint("CheapoMax", 20, 10, 19.99));
		paintList.add(new Paint("AverageJoes", 15, 11, 17.99));
		paintList.add(new Paint("DuluxourousPaints", 10, 20, 25));
	}
	
	/**
	 * Will return the paint which wastes the least paint based on how big the room is in square-meters
	 * @param size, size of the room in square-meters
	 * @return, the tin which will waste least paint.
	 */
	public Paint wastesLeast(int size) {
		int leastWastedPaint = -1;
		Paint bestPaint = null;
		
		for(Paint p : paintList) {
			int totalCoverage = p.getCoverage() * p.getQuantity();
			int wastedPaint = totalCoverage - size;
						
			if(leastWastedPaint == -1) { 
				leastWastedPaint = wastedPaint;
				bestPaint = p;
			}
		}
		
		return bestPaint;
	}
	
	public Paint bestPrice() {
		
		return new Paint("aa", 0, 0, 0);
		
	}
	
}
