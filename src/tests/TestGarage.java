package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import garage.*;

public class TestGarage {

	@Test
	public void test() {

		Garage g = new Garage();
		
		// Test add
		System.out.println("[TestGarage]: Adding input(s):");
		System.out.println("[TestGarage]: >>> (Vehicle 0) new Car(4, 80, \"Blue\")");
		System.out.println("[TestGarage]: >>> (Vehicle 1) new Motorcycle(2, 80, \"Blue\")");
		System.out.println("[TestGarage]: >>> (Vehicle 2) new Hovercraft(0, 80, \"Blue\")");
		
		g.addVehicle(new Car(4, 80, "Blue"));
		g.addVehicle(new Motorcycle(2, 80, "Blue"));
		g.addVehicle(new Hovercraft(0, 80, "Blue"));
		

		System.out.print("[TestGarage]: Checking that input(s) returns the expected value for getAll().size().");
		if(g.getAll().size() != 3) {  
			System.out.println(" fail");
			fail("getAll().size() from Garage did not return the expected output: 3. Input includes three Vehicles of different types (Car, Motorcycle, Hovercraft).");
		}
		System.out.println(" success");
		
		// Test Vehicle output
		System.out.print("[TestGarage]: Checking that input(s) returns the expected value for getVehicle(0).stringify().");
		try {
			if(!g.getVehicle(0).stringify().equals("[VehicleId: 0] [Type: Car, Wheels: 4, Speed: 80, Colour: Blue]")) { 
				System.out.println(" fail");
				fail("getVehicle(0) failed to return the first Vehicle in the list and give the expected output: [VehicleId: 0] [Type: Car, Wheels: 4, Speed: 80, Colour: Blue]");
			}
		}
		catch (Exception e) { 
			System.out.println(" fail");
			fail("getVehicle(0) threw an exception: " + e.getMessage() + " - expected output: [VehicleId: 0] [Type: Car, Wheels: 4, Speed: 80, Colour: Blue]");
		}
		System.out.println(" success");
		
		// Test Vehicle pricing
		System.out.print("[TestGarage]: Checking that input(s) returns the expected value for calculateBill(getVehicle(0)).");
		try {
			if(g.calculateBill(g.getVehicle(0)) != 40) {  
				System.out.println(" fail");
				fail("calculateBill() from Garage failed the price for Car. Expected output: 40.");
			}
			if(g.calculateBill(g.getVehicle(1)) != 30) {  
				System.out.println(" fail");
				fail("calculateBill() from Garage failed the price for Motorcycle. Expected output: 30.");
			}
			if(g.calculateBill(g.getVehicle(2)) != 100) {  
				System.out.println(" fail");
				fail("calculateBill() from Garage failed the price for Hovercraft. Expected output: 100.");
			}
		}
		catch(Exception e) { 
			System.out.println(" fail");
			fail("getVehicle(0) threw an exception: " + e.getMessage() + " - expected output: [the price of vehicle bill]");
		}
		System.out.println(" success");

		// Test delete by ID
		System.out.print("[TestGarage]: Checking that input(s) returns the expected value for delVehicle(0).");
		if(!g.delVehicle(0)) { 
			System.out.println(" fail");
			fail("delVehicle(int) from Garage failed to delete the Vehicle by ID. Expected output: true.");
		}
		System.out.println(" success");
			
		// Test delete by Object
		System.out.print("[TestGarage]: Checking that input(s) returns the expected value for delVehicle(getVehicle(0)).");
		try {
			if(!g.delVehicle(g.getVehicle(1))) { 
				System.out.println(" fail");
				fail("delVehicle(Vehicle) from Garage failed to delete the Vehicle by Object. Expected output: true.");
			}
		}
		catch(Exception e) { 
			System.out.println(" fail");
			fail("delVehicle(Vehicle) threw an exception: " + e.getMessage() + ". Expected output: true");
		}
		System.out.println(" success");
		
		// Test delete by Type
		System.out.print("[TestGarage]: Checking that input(s) returns the expected value for delVehicle(\"Hovercraft\").");
		if(!g.delVehicle("Hovercraft")) {  
			System.out.println(" fail");
			fail("delVehicle(String) from Garage failed to delete the Vehicle by Type. Expected output: true.");
		}
		System.out.println(" success");

		System.out.print("[TestGarage]: Checking that input(s) returns the expected value for printInventory().\n");
		System.out.println("[TestGarage]: Adding input(s):");
		System.out.println(">>> (Vehicle 3) new Car(4, 80, \"Blue\")");
		System.out.println(">>> (Vehicle 4) new Motorcycle(2, 80, \"Blue\")");
		System.out.println(">>> (Vehicle 5) new Hovercraft(0, 80, \"Blue\")");
		
		// Test print garage
		g.addVehicle(new Car(4, 80, "Blue"));
		g.addVehicle(new Motorcycle(2, 80, "Blue"));
		g.addVehicle(new Hovercraft(0, 80, "Blue"));
		
		try {
			g.printInventory();
		}
		catch(Exception e) { 
			System.out.println(" fail");
			fail("printInventory() from Garage failed to print a list of Vehicle. Output: " + e.getMessage() + ". Expected output: [A list of Vehicles].");
		}
		System.out.println(" success");
		
		// Test empty garage
		System.out.print("[TestGarage]: Checking that input(s) returns the expected value for emptyGarage().");
		g.emptyGarage();

		try {
			g.printInventory();
			 
			System.out.println(" fail");
			fail("printInventory() from Garage failed to clear inventory as printInventory() returned some values. Expected output: Exception(\"Failed to print inventory, there are no Vehicles in the inventory.\").");
		}
		catch(Exception e) {
			System.out.println(" success");
			return;
		}
	}
}
