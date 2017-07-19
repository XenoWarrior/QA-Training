package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import paint.PaintWizard;

public class TestPaint {

	@Test
	public void test() {
		System.out.println("[TestPaint]: Adding input(s):\n>>> new PaintWizard()");
		System.out.println("[PaintWizard]: >>> new Paint(\"CheapoMax\", 20, 10, 19.99)");
		System.out.println("[PaintWizard]: >>> new Paint(\"AverageJoes\", 15, 11, 17.99)");
		System.out.println("[PaintWizard]: >>> new Paint(\"DuluxourousPaints\", 10, 20, 25.00)");

		System.out.print("[TestPaint]: Checking that input(s) returns the expected value for wastesLeast(190).");
		PaintWizard pw = new PaintWizard();
		try { 
			if(!pw.wastesLeast(190).getName().equals("DuluxourousPaints")){
				System.out.println(" fail");
				fail("wastesLeast(190) from PaintWizard did not give the expected output: DuluxourousPaints. Input is: 190 M²");
			}
		}
		catch(Exception e) { 
			System.out.println(" fail");
			fail("[TestPaint]: wastesLeast(190) threw an exception: " + e.getMessage() + " - expected output: DuluxourousPaints");
		}
		System.out.println(" success");
		
		System.out.print("[TestPaint]: Checking that input(s) returns the expected value for bestPrice().");
		try { 
			if(!pw.bestPrice().getName().equals("AverageJoes")){
				System.out.println(" fail");
				fail("bestPrice() from PaintWizard did not give the expected output: AverageJoes.");
			}
		}
		catch(Exception e) { 
			System.out.println(" fail");
			fail("[TestPaint]: wastesLeast() threw an exception: " + e.getMessage() + " - expected output: AverageJoes");
		}
		System.out.println(" success");
		
		return;
	}

}
