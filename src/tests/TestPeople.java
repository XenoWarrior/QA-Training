package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import main.Person;

public class TestPeople {

	@Test
	public void test() {
		
		System.out.println("[TestPeople]: Adding input(s):\n>>> new Person(\"Ashley\", 21, \"Consultant\")");
		
		Person p = new Person("Ashley", 21, "Consultant");
		
		System.out.print("[TestPeople]: Checking that input returns the expected value for stringify().");
		if(!p.stringify().equals("Name/Age: Ashley, 21. Job: Consultant")) { 
			System.out.println(" fail");
			fail("stringify() from Person did not give the expected output: Name/Age: Ashley, 21. Job: Consultant. Input is: new Person(\"Ashley\", 21, \"Consultant\")");
		}
		System.out.println(" success");

		System.out.print("[TestPeople]: Checking that input returns the expected value for getName().");
		if(!p.getName().equals("Ashley")) { 
			System.out.println(" fail");
			fail("getName() from Person did not give the expected output: Ashley. Input is: new Person(\"Ashley\", 21, \"Consultant\")");
		}
		System.out.println(" success");

		System.out.print("[TestPeople]: Checking that input returns the expected value for getAge().");
		if(p.getAge() != 21) { 
			System.out.println(" fail");
			fail("getAge() from Person did not give the expected output: 21. Input is: new Person(\"Ashley\", 21, \"Consultant\")");
		}
		System.out.println(" success");

		System.out.print("[TestPeople]: Checking that input returns the expected value for getJob().");
		if(p.getJob() != "Consultant") { 
			System.out.println(" fail");
			fail("getAge() from Person did not give the expected output: Consultant. Input is: new Person(\"Ashley\", 21, \"Consultant\")");
		}
		System.out.println(" success");
		
		return;
	}

}
