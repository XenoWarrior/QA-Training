package main;

import garage.*;

import java.util.ArrayList;

public class ObjectOrientedTasks {
	public void runTasks() {
		
		System.out.println("\n\n----- START OF OOP TASKS -----");
		
		System.out.println("Task 15 (People), result (should be list of three people in a formatted string): ");
		Person p1 = new Person("Ashley", 21, "Consultant");
		Person p2 = new Person("Bradley", 21, "Consultant");
		Person p3 = new Person("Lewis", 21, "Consultant");

		System.out.println("Task 15 (People), result: " + p1.stringify());
		System.out.println("Task 15 (People), result: " + p2.stringify());
		System.out.println("Task 15 (People), result: " + p3.stringify());

		System.out.println("\nTask 15 (People), result (should be a list of three people in a formatted string, from ArrayList): ");
		ArrayList<Person> peopleList = new ArrayList<Person>();

		peopleList.add(p1);
		peopleList.add(p2);
		peopleList.add(p3);

		for (Person p : peopleList) {
			System.out.println(p.stringify());
		}

		System.out.println("\nTask 16 (Garage) A: result (should be initialisation of vehicles, then a printed inventory): ");
		Garage vehicleGarage = new Garage();
		vehicleGarage.addVehicle(new Car(4, 80, "Blue"));
		vehicleGarage.addVehicle(new Motorcycle(2, 100, "Green"));
		vehicleGarage.addVehicle(new Hovercraft(0, 300, "White"));
		vehicleGarage.printInventory();

		System.out.println("\nTask 16 (Garage) B: result (should be a printed price for each type of vehicle): ");
		Vehicle tempV = null;
		for (Vehicle v : vehicleGarage.getAll().values()) {
			System.out.println("Repair bill/cost for [" + v.stringify() + "] is £" + vehicleGarage.calculateBill(v));
			tempV = v;
		}

		System.out.println("\nTask 16 (Garage) C: tests (should delete vehicles without error): ");
		vehicleGarage.delVehicle(0);
		vehicleGarage.delVehicle(tempV);

		System.out.println("\nTask 16 (Garage) C: tests (should print an error 'does not exist'): ");
		vehicleGarage.delVehicle(tempV);

		System.out.println("\nTask 16 (Garage) C: tests (should delete vehicles without error): ");
		vehicleGarage.delVehicle(1);

		System.out.println("\nTask 16 (Garage) C: tests (should print an error 'does not exist'): ");
		vehicleGarage.delVehicle(0);
		vehicleGarage.delVehicle(tempV);
		vehicleGarage.delVehicle(1);
		
		System.out.println("\nTask 16 (Garage) D: result (should print a new inventory of vehicles): ");
		vehicleGarage.addVehicle(new Car(4, 80, "Blue"));
		vehicleGarage.addVehicle(new Motorcycle(2, 100, "Green"));
		vehicleGarage.addVehicle(new Car(4, 80, "Blue"));
		vehicleGarage.addVehicle(new Motorcycle(2, 100, "Green"));
		vehicleGarage.addVehicle(new Car(4, 80, "Blue"));
		vehicleGarage.addVehicle(new Hovercraft(0, 300, "White"));
		vehicleGarage.addVehicle(new Hovercraft(0, 300, "White"));
		vehicleGarage.addVehicle(new Car(4, 80, "Blue"));
		vehicleGarage.printInventory();

		// Delete all from the garage.
		System.out.println("\nTask 16 (Garage) D: test (removes all instances and should not show any results): ");
		vehicleGarage.emptyGarage();
		vehicleGarage.printInventory();

		// Add vehicles
		System.out.println("\nTask 16 (Garage) E: result (should print a new inventory of vehicles): ");
		vehicleGarage.addVehicle(new Car(4, 80, "Blue"));
		vehicleGarage.addVehicle(new Motorcycle(2, 100, "Green"));
		vehicleGarage.addVehicle(new Car(4, 80, "Blue"));
		vehicleGarage.addVehicle(new Motorcycle(2, 100, "Green"));
		vehicleGarage.addVehicle(new Car(4, 80, "Blue"));
		vehicleGarage.addVehicle(new Hovercraft(0, 300, "White"));
		vehicleGarage.addVehicle(new Hovercraft(0, 300, "White"));
		vehicleGarage.addVehicle(new Car(4, 80, "Blue"));
		vehicleGarage.printInventory();

		System.out.println("\nTask 16 (Garage) E: test (should delete all instances of 'Car'): ");
		vehicleGarage.delVehicle("Car");

		System.out.println("\nTask 16 (Garage) F: test (should print the inventory, excluding all 'Car' instances): ");
		vehicleGarage.printInventory();
		
		System.out.println("\nTask 17 (Paint Wizard)");
		
		
		System.out.println("----- END OF OOP TASKS -----");
	}
}
