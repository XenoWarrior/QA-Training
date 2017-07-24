package paint;

import java.util.ArrayList;

public class PaintWizard {
	
	ArrayList<Paint> paintList = new ArrayList<Paint>();
	
	public PaintWizard() {
		paintList.add(new Paint("CheapoMax", 20, 10, 19.99));
		paintList.add(new Paint("AverageJoes", 15, 11, 17.99));
		paintList.add(new Paint("DuluxourousPaints", 10, 20, 25.00));
	}
	
	/**
	 * Will return the paint which wastes the least paint based on how big the room is in square-meters
	 * @param size, size of the room in square-meters
	 * @return, the tin which will waste least paint.
	 * @throws Exception 
	 */
	public Paint wastesLeast(double size) throws Exception {
				
		System.out.println("\n[PaintWizard]: Deciding on best paint for the room size: " + size + "M²");
		
		double leastWastedPaint = -1;
		Paint bestPaint = null;
		
		for(Paint p : paintList) {
			double totalCoverage = p.getQuantity() * p.getCoverage();
			double coveredSize = totalCoverage - size; 
			double wastedPaint = coveredSize / p.getCoverage();

			//System.out.println("\n[DEBUG]: Paint(Name = " + p.getName() + ", Litres = " + p.getQuantity() + ", Coverage (per-litre) = " + p.getCoverage()  + "M², Price = " + p.getPrice() + ")");
			//System.out.println("[DEBUG]: Paint(Total Coverage = " + totalCoverage + "M², Covered Size = " + coveredSize + ")");
			//System.out.println("[DEBUG]: The paint covers " + totalCoverage + "M², the room is " + size + "M² so this means that there will be " + wastedPaint + " Litre(s) of wasted paint.");
			
			if(wastedPaint < 0) { 
				System.out.println("[PaintWizard]: " + p.getName() + " can only cover " + totalCoverage + "M², the room size is " + size + "M², ignoring soultion.");
				continue;
			}
			
			if(leastWastedPaint == -1) { 
				System.out.println("[PaintWizard]: " + p.getName() + " is the first paint found which will cover " + size + "M² and waste " + wastedPaint + "L, setting as first solution.");

				leastWastedPaint = wastedPaint;
				bestPaint = p;
			}
			else if(wastedPaint < leastWastedPaint) {
				//System.out.println("[DEBUG]: " + p.stringify() + " is better than " + bestPaint.stringify() + " because it wastes less paint, changing.");
				System.out.println("[PaintWizard]: Found a better solution: " + p.getName() + " which wastes " + wastedPaint + "L in comparison to " + bestPaint.getName() + " which wastes " + leastWastedPaint + "L");
				
				leastWastedPaint = wastedPaint;
				bestPaint = p;
			}
		}
		
		if(bestPaint == null) { 
			throw new Exception("No paint was found, unable to return a good paint solution.");
		}
		
		return bestPaint;
	}
	
	public void listPaints() {
		System.out.println();
		
		for(Paint p : paintList) { 
			System.out.println(p.stringify());
		}
	}
	
	public Paint bestPrice() throws Exception {
		System.out.println("\n[PaintWizard]: Deciding on best paint based on price.");
		
		Paint bestPaint = null;
		double bestPrice = -1;
		
		for(Paint p : paintList) {
			
			if(bestPrice == -1) {  
				System.out.println("[PaintWizard]: " + p.getName() + " is the first paint found which costs £" + p.getPrice() + ", setting as first solution.");

				bestPrice = p.getPrice();
				bestPaint = p;
			}
			else { 
				if(p.getPrice() < bestPrice) { 
					System.out.println("[PaintWizard]: Found a better solution: " + p.getName() + " costs £" + p.getPrice() + " in comparison to " + bestPaint.getName() + " which costs £" + bestPrice);
					
					bestPrice = p.getPrice();
					bestPaint = p;
				}
				else {
					System.out.println("[PaintWizard]: " + p.getName() + " which costs £" + p.getPrice() + " in comparison to " + bestPaint.getName() + " which costs £" + bestPrice + ", ignoring.");
				}
			}
		}

		if(bestPaint == null) { 
			throw new Exception("No paint was found, unable to return a good paint solution.");
		}
		
		
		return bestPaint;
	}
	
}
