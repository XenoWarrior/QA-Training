package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import garage.*;

public class TestGarage {

	@Test
	public void test() {

		Garage g = new Garage();
		
		// Test add
		System.out.println(">>>> Testing: Adding Vehicles (Car, Motorcycle, Hovercraft) to the Garage inventory.");
		g.addVehicle(new Car(4, 80, "Blue"));
		g.addVehicle(new Motorcycle(2, 80, "Blue"));
		g.addVehicle(new Hovercraft(0, 80, "Blue"));
		if(g.getAll().size() != 3) { 
			fail("getAll().size() from Garage did not return the expected output: 3. Input includes three Vehicles of different types (Car, Motorcycle, Hovercraft).");
		}
		
		// Test Vehicle output
		System.out.println(">>>> Testing: Getting a Vehicle from the Garage and fetching its information.");
		try {
			if(!g.getVehicle(0).stringify().equals("[VehicleId: 0] [Type: Car, Wheels: 4, Speed: 80, Colour: Blue]")) {
				fail("getVehicle(0) failed to return the first Vehicle in the list and give the expected output: [VehicleId: 0] [Type: Car, Wheels: 4, Speed: 80, Colour: Blue]");
			}
		}
		catch (Exception e) {
			fail("getVehicle(0) threw an exception: " + e.getMessage() + " - expected output: [VehicleId: 0] [Type: Car, Wheels: 4, Speed: 80, Colour: Blue]");
		}
		
		// Test Vehicle pricing
		try {
			if(g.calculateBill(g.getVehicle(0)) != 40) { 
				fail("calculateBill() from Garage failed the price for Car. Expected output: 40.");
			}
			if(g.calculateBill(g.getVehicle(1)) != 30) { 
				fail("calculateBill() from Garage failed the price for Motorcycle. Expected output: 30.");
			}
			if(g.calculateBill(g.getVehicle(2)) != 100) { 
				fail("calculateBill() from Garage failed the price for Hovercraft. Expected output: 100.");
			}
		}
		catch(Exception e) {
			fail("getVehicle(0) threw an exception: " + e.getMessage() + " - expected output: [the price of vehicle bill]");
		}

		// Test delete by ID
		if(!g.delVehicle(0)) {
			fail("delVehicle(int) from Garage failed to delete the Vehicle by ID. Expected output: true.");
		}
			
		// Test delete by Object
		try {
			if(!g.delVehicle(g.getVehicle(1))) {
				fail("delVehicle(Vehicle) from Garage failed to delete the Vehicle by Object. Expected output: true.");
			}
		}
		catch(Exception e) {
			fail("delVehicle(Vehicle) threw an exception: " + e.getMessage() + ". Expected output: true");
		}
		
		// Test delete by Type
		if(!g.delVehicle("Hovercraft")) { 
			fail("delVehicle(String) from Garage failed to delete the Vehicle by Type. Expected output: true.");
		}
		
		// Test print garage
		g.addVehicle(new Car(4, 80, "Blue"));
		g.addVehicle(new Motorcycle(2, 80, "Blue"));
		g.addVehicle(new Hovercraft(0, 80, "Blue"));
		
		try {
			g.printInventory();
		}
		catch(Exception e) {
			fail("printInventory() from Garage failed to print a list of Vehicle. Output: " + e.getMessage() + ". Expected output: [A list of Vehicles].");
		}
		
		// Test empty garage
		g.emptyGarage();

		try {
			g.printInventory();
			
			fail("printInventory() from Garage failed to clear inventory as printInventory() returned some values. Expected output: Exception(\"Failed to print inventory, there are no Vehicles in the inventory.\").");
		}
		catch(Exception e) {
			return;
		}
	}
}
