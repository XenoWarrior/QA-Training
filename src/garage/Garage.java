package garage;

import java.util.HashMap;
import java.util.Map;

public class Garage {

	// Task requested List, but using a map gave a better "idea" for an ID.
	private HashMap<Integer, Vehicle> vehicleList = new HashMap<Integer, Vehicle>();
	private int uniqueId = 0;

	public Garage() {

	}

	/**
	 * Adds a vehicle to the garage list.
	 * 
	 * @param v.
	 */
	public void addVehicle(Vehicle v) {
		v.setId(uniqueId);
		vehicleList.put(uniqueId, v);
		uniqueId++;
	}

	public Vehicle getVehicle(int id) {
		if (vehicleList.containsKey(id)) {
			return vehicleList.get(id);
		} else {
			throw new IndexOutOfBoundsException("No vehicle exists at that index in the garage.");
		}
	}

	/**
	 * Deleted vehicle by it's ID.
	 * 
	 * @param id
	 *            int number for the vehicle ID.
	 */
	public void delVehicle(int id) {
		if (vehicleList.containsKey(id)) {
			System.out.println("Removing Vehicle by ID: " + vehicleList.get(id).stringify());
			vehicleList.remove(id);
		} else {
			System.out.println("Vehicle does not exist. ID: " + id);
		}
	}

	/**
	 * Deleted vehicle by the "physical" vehicle object/instance.
	 * 
	 * @param v
	 *            Vehicle object/instance.
	 */
	public void delVehicle(Vehicle v) {
		if (vehicleList.containsValue(v)) {
			System.out.println("Removing Vehicle by instance: " + v.stringify());
			vehicleList.values().remove(v);
		} else {
			System.out.println("Vehicle does not exist in Garage List. Instance: " + v.stringify());
		}
	}

	/**
	 * Fix Vehicle requirement was vague, just returns a random price based on
	 * vehicle the vehicle type.
	 */
	public int calculateBill(Vehicle v) {
		if (v.getClass() == Motorcycle.class) {
			return 30;
		}
		if (v.getClass() == Car.class) {
			return 40;
		}
		if (v.getClass() == Truck.class) {
			return 100;
		}

		return 0;
	}

	/**
	 * Prints the list of the inventory to the screen or returns "no vehicles
	 * found"
	 * 
	 * @return
	 */
	public void printInventory() {
		if (vehicleList.size() > 0) {
			for (Vehicle v : vehicleList.values()) {
				System.out.println(v.stringify());
			}
		} else {
			System.out.println("No vehicles found.");
		}
	}

	/**
	 * Returns a list of all vehicles.
	 * 
	 * @return list of vehicles
	 */
	public HashMap<Integer, Vehicle> getAll() {
		return vehicleList;
	}

	/**
	 * Deletes all items from the garage list.
	 */
	public void emptyGarage() {
		vehicleList.clear();
	}
}
