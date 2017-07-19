package library;

import java.util.HashMap;

public class PersonManager {

	private HashMap<Integer, Person> personList = new HashMap<Integer, Person>();
	
	public PersonManager() {
		
	}
	
	public int registerPerson(Person p) { 
		return 0;
	}
	
	public boolean deletePerson(int personId) { 
		return false;
	}

	public boolean updatePerson(int personId, Person p) { 
		return false;
	}

	public HashMap<Integer, Person> getPersonList() { 
		return personList;
	}
}
