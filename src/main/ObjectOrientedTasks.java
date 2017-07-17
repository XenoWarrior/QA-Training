package main;

import garage.*;

import java.util.ArrayList;

public class ObjectOrientedTasks {
	public void runTasks() {
		System.out.println("\n\nIndividual People, with Formatted String:");
		Person p1 = new Person("Ashley", 21, "Consultant");
		Person p2 = new Person("Bradley", 21, "Consultant");
		Person p3 = new Person("Lewis", 21, "Consultant");

		System.out.println(p1.getPersonString());
		System.out.println(p2.getPersonString());
		System.out.println(p3.getPersonString());

		System.out.println("\n\nPeople in ArrayList, with Loop and Formatted String:");
		ArrayList<Person> peopleList = new ArrayList<Person>();

		peopleList.add(p1);
		peopleList.add(p2);
		peopleList.add(p3);

		for (Person p : peopleList) {
			System.out.println(p.getPersonString());
		}
		
		System.out.println("\n\nGarage Task:");

		Garage vehicleGarage = new Garage();

		vehicleGarage.addVehicle(new Car());
		vehicleGarage.addVehicle(new Motorcycle());
		vehicleGarage.addVehicle(new Truck());

		System.out.println("\n\n");
		
		vehicleGarage.printInventory();

		System.out.println("\n\n");
		
		Vehicle tempV = new Vehicle();
		System.out.println(" Empty Vehicle");
		
		for(Vehicle v : vehicleGarage.getAll().values()) {
			System.out.println("Repair bill/cost for ["+v.stringify()+"] is £" + vehicleGarage.calculateBill(v));
			
			tempV = v;
		}

		System.out.println("\n\nWill work:");
		
		// Should work!
		vehicleGarage.delVehicle(0);
		vehicleGarage.delVehicle(tempV);

		System.out.println("\nWon't work:");
		
		// Should not work!
		vehicleGarage.delVehicle(tempV);

		System.out.println("\nWill work:");
		
		// Should work!
		vehicleGarage.delVehicle(1);

		System.out.println("\nWon't work:");
		
		// Should not work!
		vehicleGarage.delVehicle(0);
		vehicleGarage.delVehicle(tempV);
		vehicleGarage.delVehicle(1);

		System.out.println("\n\nAdd new vehicles for deletion:");
		vehicleGarage.addVehicle(new Car());
		vehicleGarage.addVehicle(new Motorcycle());
		vehicleGarage.addVehicle(new Car());
		vehicleGarage.addVehicle(new Motorcycle());
		vehicleGarage.addVehicle(new Car());
		vehicleGarage.addVehicle(new Truck());
		vehicleGarage.addVehicle(new Truck());
		vehicleGarage.addVehicle(new Car());
		

		System.out.println("\nEnsure vehicles exist:");
		// Print all from inventory
		vehicleGarage.printInventory();
		
		System.out.println("\n\nDelete / empty all from inventory...");
		// Delete all from the garage.
		vehicleGarage.emptyGarage();

		System.out.println("\nEnsure vehicles are gone:");
		// Print all from inventory
		vehicleGarage.printInventory();
	}
}
