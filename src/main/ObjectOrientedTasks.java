package main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.simple.JSONValue;

import garage.*;
import library.*;

public class ObjectOrientedTasks {

	Garage vehicleGarage = new Garage();
	
	public void runTasks() {

		System.out.println("\n\n----- START OF OOP TASKS -----");

		task15();
		task16();
		task17();
		//task18(); is now run in MAIN
		task19();
		task20();
		
		System.out.println("----- END OF OOP TASKS -----");

	}
	
	public void task15() { 
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
		vehicleGarage.addVehicle(new Car(4, 80, "Blue"));
		vehicleGarage.addVehicle(new Motorcycle(2, 100, "Green"));
		vehicleGarage.addVehicle(new Hovercraft(0, 300, "White"));
		
		try {
			vehicleGarage.printInventory();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
	
	public void task16() {
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
		try {
			vehicleGarage.printInventory();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		// Delete all from the garage.
		System.out.println("\nTask 16 (Garage) D: test (removes all instances and should not show any results): ");
		vehicleGarage.emptyGarage();
		try {
			vehicleGarage.printInventory();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

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
		try {
			vehicleGarage.printInventory();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println("\nTask 16 (Garage) E: test (should delete all instances of 'Car'): ");
		vehicleGarage.delVehicle("Car");

		System.out.println("\nTask 16 (Garage) F: test (should print the inventory, excluding all 'Car' instances): ");

		try {
			vehicleGarage.printInventory();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
	
	public void task17() { 
		
		int roomSize = 190;
		System.out.println("\nTask 17 (Paint Wizard), results (should show a list of paints followed by the best value based on least waste): ");
		System.out.println("Room size is: " + roomSize + " M²");

		paint.PaintWizard paintWizard = new paint.PaintWizard();
		paintWizard.listPaints();

		try {
			System.out.println(">>> Paint Wizard picked: " + paintWizard.wastesLeast(roomSize).stringify());
			System.out.println(">>> Paint Wizard picked: " + paintWizard.bestPrice().stringify());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
	
	public void task18 () {
		// Testing, but it has been called at the end of main in Main.java
	}
	
	@SuppressWarnings("unchecked")
	public void task19 () {

		System.out.println("\nTask 19 (Person File Writer + Reader):");

		// Create lists for this task
		ArrayList<String> jsonList = new ArrayList<String>();
		ArrayList<Person> personList = new ArrayList<Person>();
		
		// Write some people straight to JSON, we will write them to file then from file back to people as objects. 
		jsonList.add(new Person("Ashley", 21, "Consultant").toJson());
		jsonList.add(new Person("Bradley", 21, "Consultant").toJson());
		jsonList.add(new Person("Lewis", 21, "Consultant").toJson());
		
		// Setup the writer
		BufferedWriter writer = null;
		try {
			// Try to write the people list to a json feed.
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("PersonList.json"), "utf-8"));
			writer.write(JSONValue.toJSONString(jsonList));
		} 
		catch (IOException e) {
			System.out.println(e.getMessage());
		} 
		finally {
			try {
				writer.close();
			} 
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	
		
		// Now read them back and convert to objects
		try { 
			File fileLocation = new File("PersonList.json");
			FileInputStream fileReader = new FileInputStream(fileLocation);

			byte[] fileData = new byte[(int) fileLocation.length()];
			
			fileReader.read(fileData);
			
			String rawJson = new String(fileData, "UTF-8");
			System.out.println("Raw JSON: " + rawJson);
			
			try { 
				ArrayList<String> decodedJson = (ArrayList<String>) JSONValue.parse(rawJson);
				 
				for(String s : decodedJson) {
					System.out.println("Decoded JSON value found: " + s);
					HashMap<String, String> attribs = (HashMap<String, String>) JSONValue.parse(s);
					personList.add(new Person(attribs.get("name"), Integer.parseInt(attribs.get("age")), attribs.get("job")));
				}
				
				System.out.println();
				
				for(Person p : personList) {
					System.out.println("Converted JSON -> Person gives: " + p.stringify());
				}
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
			
			fileReader.close();

		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}

	}
	
	public void task20() {

		System.out.println("\nTask 20 (Library System):");

		Library l = new Library();

		SimpleDateFormat d = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	    Date now = new Date();
	    
		// Give library some items
		l.addItem(new Book("Somebook 1", 11, true, true));
		l.addItem(new Book("Somebook 2", 12, true, false));
		l.addItem(new Magazine("SomeMagazine 1", 15, true, "Gossip"));
		l.addItem(new Magazine("SomeMagazine 2", 16, true, "Cooking"));
		l.addItem(new Newspaper("SomeMagazine 1", 15, true, d.format(now)));
		l.addItem(new Newspaper("SomeMagazine 2", 16, true, d.format(now)));

		// Give library some people
		l.addPerson(new Member("Someone 1", 20, "10 Some Street, Some City, Some Country"));
		l.addPerson(new Member("Someone 2", 21, "11 Some Street, Some City, Some Country"));
		l.addPerson(new Member("Someone 2", 22, "12 Some Street, Some City, Some Country"));
		l.addPerson(new Staff("Someone 3", 23, "13 Some Street, Some City, Some Country", "Support"));
		l.addPerson(new Staff("Someone 4", 24, "14 Some Street, Some City, Some Country", "Sales"));

		// Fail, cannot checkout item at -1 (does not exist)
		// Fail, cannot checkout item at 0 for person at -1 (does not exist)
		l.checkoutItem(-1, 0);
		l.checkoutItem(0, -1);

		// Success then fail, can checkout, but can't checkout again
		l.checkoutItem(0, 0);
		l.checkoutItem(0, 0);

		// Success then fail, can check in, but can't check in again
		l.checkinItem(0, 0);
		l.checkinItem(0, 0);

		// Remove, then fail to checkout item (does not exist)
		l.removePerson(0);
		l.checkoutItem(0, 0);

		// Remove then fail to checkout item (does not exist)
		l.removeItem(0);
		l.checkoutItem(0, 1);

		// Success, get a person at id 1 and print their name
		try {
			System.out.println("[DEBUG]: Get person [1]: " + l.getPerson(1).getName());
		} catch (Exception e) {
			System.out.println("[DEBUG]: " + e.getMessage());
		}

		// Success, get an item at id 1 and print the name
		try {
			System.out.println("[DEBUG]: Get item [1]: " + l.getItem(1).getName());
		} 
		catch (Exception e) {
			System.out.println("[DEBUG]: " + e.getMessage());
		}

		// Fail, person 0 was deleted, can't print name (does not exist)
		try {
			System.out.println("[DEBUG]: Get person [0]: " + l.getPerson(0).getName());
		} catch (Exception e) {
			System.out.println("[DEBUG]: " + e.getMessage());
		}

		// Fail, item 0 was deleted, can't print name (does not exist)
		try {
			System.out.println("[DEBUG]: Get item [0]: " + l.getItem(0).getName());
		} 
		catch (Exception e) {
			System.out.println("[DEBUG]: " + e.getMessage());
		}

		// Success then fail
		try {
			// Success, can cast Item -> Book to Book
			Book i = (Book) l.getItem(1);
			System.out
					.println("[DEBUG]: " + i.getName() + " is a " + (i.isHardback() ? "hardback" : "normal") + " book");

			// Fail, can't cast Item -> Magazine to Item -> Book
			i = (Book) l.getItem(2);
			System.out
					.println("[DEBUG]: " + i.getName() + " is a " + (i.isHardback() ? "hardback" : "normal") + " book");
		} 
		catch (Exception e) {
			System.out.println("[DEBUG]: " + e.getMessage());
		}

		// Success, update item name
		try {
			System.out.println("[DEBUG]: Before updating item name [1]: " + l.getItem(1).getName());

			l.updateItem(1, new Book("New! Somebook 2", 12, true, false));

			System.out.println("[DEBUG]: After updating item name [1]: " + l.getItem(1).getName());
		} 
		catch (Exception e) {
			System.out.println("[DEBUG]: " + e.getMessage());
		}

		// Success, update person name
		try {
			System.out.println("[DEBUG]: Before updating person name [1]: " + l.getPerson(1).getName());

			l.updatePerson(1, new Member("New! Someone 2", 21, "11 Some Street, Some City, Some Country"));

			System.out.println("[DEBUG]: After updating person name [1]: " + l.getPerson(1).getName());
		} 
		catch (Exception e) {
			System.out.println("[DEBUG]: " + e.getMessage());
		}

		// Success then fail
		try {
			// Success, can cast Person -> Member to Member
			Member per = (Member) l.getPerson(1);

			System.out.println("[DEBUG]: Member 1, name is: " + per.getName());

			// Fail, can't cast Person -> Member to Staff
			per = (Member) l.getPerson(3);

			System.out.println("[DEBUG]: Member 3, name is: " + per.getName());
		} 
		catch (Exception e) {
			System.out.println("[DEBUG]: " + e.getMessage());
		}

		LibraryIO.writeObjectJSON(l.getItemList(), "Library_ItemList.json");
		LibraryIO.writeObjectJSON(l.getPersonList(), "Library_PeopleList.json");
		
		LibraryIO.readObjectJSON("Library_ItemList.json");
		
	}
}
