package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import main.Person;

public class TestPeople {

	@Test
	public void test() {
		Person p = new Person("Ashley", 21, "Consultant");
		
		if(!p.stringify().equals("Name/Age: Ashley, 21. Job: Consultant")) { 
			fail("stringify() from Person did not give the expected output: Name/Age: Ashley, 21. Job: Consultant. Input is: new Person(\"Ashley\", 21, \"Consultant\")");
		}
		
		if(!p.getName().equals("Ashley")) {
			fail("getName() from Person did not give the expected output: Ashley. Input is: new Person(\"Ashley\", 21, \"Consultant\")");
		}
		
		if(p.getAge() != 21) {
			fail("getAge() from Person did not give the expected output: 21. Input is: new Person(\"Ashley\", 21, \"Consultant\")");
		}
		
		if(p.getJob() != "Consultant") {
			fail("getAge() from Person did not give the expected output: Consultant. Input is: new Person(\"Ashley\", 21, \"Consultant\")");
		}
		
		return;
	}

}
