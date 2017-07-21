package library;

import java.util.HashMap;

public class PersonManager {

	/**
	 * Variable definitions for the class
	 */
	private HashMap<Integer, Person> personList = new HashMap<Integer, Person>();

	/**
	 * Constructor stub
	 */
	public PersonManager() {

	}

	/**
	 * Adds a person to the person "database"
	 * 
	 * @param p,
	 *            the person object itself @return, the id of the new person
	 */
	public int addPerson(Person p) {
		try {
			personList.put(p.getPersonId(), p);
			System.out
					.println("[DEBUG]: Added Person (" + p.getClass().getName() + ") with the ID: " + p.getPersonId());
		} catch (Exception e) {
			System.out.println("[DEBUG]: Failed to add Person (" + p.getClass().getName()
					+ "), does an item already exist at ID: " + p.getPersonId() + "?");
			return -1;
		}

		return p.getPersonId();
	}

	/**
	 * @param personId,
	 *            the id of the person to delete @return, if the operation was
	 *            successful
	 */
	public boolean removePerson(int personId) {
		if (personList.containsKey(personId)) {
			personList.remove(personId);

			return true;
		}

		return false;
	}

	/**
	 * Gets a person by ID
	 * 
	 * @param personId,
	 *            the id to find @return, the person object
	 * @throws Exception,
	 *             if there is no object by the specified id
	 */
	public Person getPerson(int personId) throws Exception {
		if (personList.containsKey(personId)) {
			return personList.get(personId);
		}

		throw new Exception("Unable to find an person by ID: " + personId);
	}

	/**
	 * Updates a person object based on its Id
	 * 
	 * @param personId,
	 *            the id of the person to delete
	 * @param p,
	 *            the Person object itself 
	 * @return, if the operation was*
	 *            successful
	 */
	public boolean updatePerson(int personId, Person p) {
		if (personList.containsKey(personId)) {
			personList.put(personId, p);
			return true;
		}

		return false;
	}

	/**
	 * Gets list of people in the "database" 
	 * @return, the list of people in the
	 * "database"
	 */
	public HashMap<Integer, Person> getPersonList() {
		return personList;
	}
}
