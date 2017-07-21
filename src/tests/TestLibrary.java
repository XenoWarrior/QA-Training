package tests;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.junit.Test;

import library.Book;
import library.Data;
import library.Library;
import library.LibraryIO;
import library.Magazine;
import library.Member;
import library.Newspaper;
import library.Staff;

public class TestLibrary {

	@Test
	/**
	 * Can use assertEquals(), but I've done it this way (more code), just for some extra print statement between each method and task)
	 */
	public void test() {

		Data.resetIncrement();
		Library library = new Library();

		//System.out.println("[TestLibrary]: ");

		System.out.println("[TestLibrary]: Adding input(s):");
		System.out.println("[TestLibrary]: >>> new Book(\"Somebook 1\", 11, true, true)");
		System.out.println("[TestLibrary]: >>> new Book(\"Somebook 2\", 12, true, false)");
		System.out.println("[TestLibrary]: >>> new Magazine(\"SomeMagazine 1\", 15, true, \"Gossip\")");
		System.out.println("[TestLibrary]: >>> new Magazine(\"SomeMagazine 2\", 16, true, \"Cooking\")");
		System.out.println("[TestLibrary]: >>> new Newspaper(\"SomeNewspaper 1\", 15, true, new SimpleDateFormat(\"yyyy/MM/dd HH:mm:ss\"))");
		System.out.println("[TestLibrary]: >>> new Newspaper(\"SomeNewspaper 2\", 16, true, new SimpleDateFormat(\"yyyy/MM/dd HH:mm:ss\"))");
		System.out.println("[TestLibrary]: >>> new Member(\"Someone 1\", 20, \"10 Some Street, Some City, Some Country\")");
		System.out.println("[TestLibrary]: >>> new Member(\"Someone 2\", 21, \"11 Some Street, Some City, Some Country\")");
		System.out.println("[TestLibrary]: >>> new Member(\"Someone 2\", 22, \"12 Some Street, Some City, Some Country\")");
		System.out.println("[TestLibrary]: >>> new Staff(\"Someone 3\", 23, \"13 Some Street, Some City, Some Country\", \"Support\")");
		System.out.println("[TestLibrary]: >>> new Staff(\"Someone 4\", 24, \"14 Some Street, Some City, Some Country\", \"Sales\")");

		SimpleDateFormat d = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	    Date now = new Date();
	    
		library.addItem(new Book("Somebook 1", 11, true, true)); // 0
		library.addItem(new Book("Somebook 2", 12, true, false)); // 1
		library.addItem(new Magazine("SomeMagazine 1", 15, true, "Gossip")); // 2
		library.addItem(new Magazine("SomeMagazine 2", 16, true, "Cooking")); // 3
		library.addItem(new Newspaper("SomeNewspaper 1", 15, true, d.format(now))); // 4
		library.addItem(new Newspaper("SomeNewspaper 2", 16, true, d.format(now))); // 5
		
		library.addPerson(new Member("Someone 1", 20, "10 Some Street, Some City, Some Country")); // 0
		library.addPerson(new Member("Someone 2", 21, "11 Some Street, Some City, Some Country")); // 1
		library.addPerson(new Member("Someone 3", 22, "12 Some Street, Some City, Some Country")); // 2
		library.addPerson(new Staff("Someone 3", 23, "13 Some Street, Some City, Some Country", "Support")); // 3
		library.addPerson(new Staff("Someone 4", 24, "14 Some Street, Some City, Some Country", "Sales")); // 4
		
		// Test item checkout
		System.out.print("[TestLibrary]: Checking that input(s) returns the expected value for checkoutItem(0, 0).");
		if(!library.checkoutItem(0, 0)) {
			System.out.println(" fail");
			fail("checkoutItem(0, 0) from Library did not return the expected output: true.");
		}
		System.out.println(" success");
		
		System.out.print("[TestLibrary]: Checking that input(s) returns the expected value for checkoutItem(0, -1).");
		if(library.checkoutItem(0, -1)) {
			System.out.println(" fail");
			fail("checkoutItem(0, 0) from Library did not return the expected output: false.");
		}
		System.out.println(" success");
		
		// Test item check in
		System.out.print("[TestLibrary]: Checking that input(s) returns the expected value for checkinItem(0, 0).");
		if(!library.checkinItem(0, 0)) {
			System.out.println(" fail");
			fail("checkinItem(0, 0) from Library did not return the expected output: true.");
		}
		System.out.println(" success");
		
		System.out.print("[TestLibrary]: Checking that input(s) returns the expected value for checkinItem(0, -1).");
		if(library.checkinItem(0, -1)) {
			System.out.println(" fail");
			fail("checkinItem(0, 0) from Library did not return the expected output: false.");
		}
		System.out.println(" success");

		
		
		// Test item add
		System.out.print("[TestLibrary]: Checking that input(s) returns the expected value for addItem(new Book(\"Somebook IndexOf 6\", 11, true, true)).");
		if(!library.addItem(new Book("Somebook IndexOf 6", 11, true, true))) {
			System.out.println(" fail");
			fail("addItem(new Book(\"Somebook IndexOf 6\", 11, true, true)) from Library did not return the expected output: true.");
		}
		System.out.println(" success");
		
		// Test item remove
		System.out.print("[TestLibrary]: Checking that input(s) returns the expected value for removeItem(6).");
		if(!library.removeItem(6)) {
			System.out.println(" fail");
			fail("removeItem(6) from Library did not return the expected output: true.");
		}
		System.out.println(" success");
		
		// Test item update 
		System.out.print("[TestLibrary]: Checking that input(s) returns the expected value for updateItem(5, new Book(\"New! Somebook 1\", 11, true, true)).");
		if(!library.updateItem(5, new Book("New! Somebook 1", 11, true, true))) {
			System.out.println(" fail");
			fail("updateItem(5, new Book(\"New! Somebook 1\", 11, true, true)) from Library did not return the expected output: true.");
		}
		System.out.println(" success");
		
		try {
			System.out.print("[TestLibrary]: Checking that input(s) returns the expected value for getItem(5).getName().");
			if(!library.getItem(5).getName().equals("New! Somebook 1")) {
				System.out.println(" fail");
				fail("getItem(10).getName() from Library did not return the expected output: 'New! Somebook 1'.");
			}
			System.out.println(" success");
		}
		catch(Exception e) { 
			System.out.println(e.getMessage());
		}
		
		// Test person add
		System.out.print("[TestLibrary]: Checking that input(s) returns the expected value for addPerson(new Member(\"Someone New\", 20, \"10 Some Street, Some City, Some Country\")).");
		if(!library.addPerson(new Member("Someone New", 20, "10 Some Street, Some City, Some Country"))) {
			System.out.println(" fail");
			fail("addPerson(new Member(\"Someone New\", 20, \"10 Some Street, Some City, Some Country\")) from Library did not return the expected output: true.");
		}
		System.out.println(" success");
		
		// Test person remove
		System.out.print("[TestLibrary]: Checking that input(s) returns the expected value for removePerson(5).");
		if(!library.removePerson(5)) {
			System.out.println(" fail");
			fail("removePerson(5) from Library did not return the expected output: true.");
		}
		System.out.println(" success");
		
		// Test person update
		System.out.print("[TestLibrary]: Checking that input(s) returns the expected value for updatePerson(2, new Member(\"New! Someone 3\", 20, \"10 Some Street, Some City, Some Country\")).");
		if(!library.updatePerson(2, new Member("New! Someone 3", 20, "10 Some Street, Some City, Some Country"))) {
			System.out.println(" fail");
			fail("updatePerson(2, new Member(\"New! Someone 3\", 20, \"10 Some Street, Some City, Some Country\")) from Library did not return the expected output: true.");
		}
		System.out.println(" success");
		
		try {
			System.out.print("[TestLibrary]: Checking that input(s) returns the expected value for getPerson(2).getName().");
			if(!library.getPerson(2).getName().equals("New! Someone 3")) {
				System.out.println(" fail");
				fail("getPerson(2).getName() from Library did not return the expected output: 'New! Someone 3'.");
			}
			System.out.println(" success");
		}
		catch(Exception e) { 
			System.out.println(e.getMessage());
		}

		System.out.print("[TestLibrary]: Checking that input(s) returns the expected value for LibraryIO.writeObjectJson(library.getItemList(), \"JUnitTest_Library_ItemList.json\").\n");
		if(!LibraryIO.writeObjectJSON(library.getItemList(), "JUnitTest_Library_ItemList.json")) {
			System.out.println(" fail");
			fail("LibraryIO.writeObjectJson(library.getItemList(), \"JUnitTest_Library_ItemList.json\") from LibraryIO (static) did not return the expected output: true");
		}
		System.out.println(" success");
		
		System.out.print("[TestLibrary]: Checking that input(s) returns the expected value for LibraryIO.readObjectJson(\"JUnitTest_Library_ItemList.json\").\n");
		if(!(LibraryIO.readObjectJSON("JUnitTest_Library_ItemList.json") instanceof HashMap<?, ?>)) {
			System.out.println(" fail");
			fail("LibraryIO.readObjectJSON(\"JUnitTest_Library_ItemList.json\") from LibraryIO (static) did not return the expected output: HashMap<String, String>");
		}
		System.out.println(" success");
		
		return;
		
	}

}
