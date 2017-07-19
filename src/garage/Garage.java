package garage;

import java.util.ArrayList;
import java.util.HashMap;

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

	public Vehicle getVehicle(int id) throws Exception {
		if (vehicleList.containsKey(id)) {
			return vehicleList.get(id);
		} else {
			throw new Exception("No vehicle exists at that index in the garage.");
		}
	}

	/**
	 * Deleted vehicle by it's ID.
	 * 
	 * @param id
	 *            Number for the vehicle ID.
	 */
	public boolean delVehicle(int id) {
		if (vehicleList.containsKey(id)) {
			//System.out.println("Removing Vehicle by ID: " + vehicleList.get(id).stringify());
			
			vehicleList.remove(id);
			
			return true;
		}
		
		System.out.println("Vehicle does not exist in garage. ID: " + id);
		return false;
	}

	/**
	 * Deleted vehicle by the "physical" vehicle object/instance.
	 * 
	 * @param v
	 *            Vehicle object/instance.
	 */
	public boolean delVehicle(Vehicle v) {
		if (vehicleList.containsValue(v)) {
			///System.out.println("Removing Vehicle by instance: " + v.stringify());
			vehicleList.values().remove(v);
			
			return true;
		}
		System.out.println("Vehicle does not exist in garage. Instance: " + v.stringify());
		return false;
	}

	/**
	 * Deletes all vehicle by type.
	 */
	public boolean delVehicle(String type) {

		ArrayList<Vehicle> temp = new ArrayList<Vehicle>();

		for (Vehicle v : vehicleList.values()) {
			if (v.getClass().getName().equals("garage." + type)) {
				// System.out.println("Deleted: " + v.stringify() + ", is part of the '" + type + "' class.");
				temp.add(v);
			} else {
				System.out.println("Did NOT delete: " + v.stringify() + ", is not part of the '" + type + "' class.");
				
				return false;
			}
		}

		vehicleList.values().removeAll(temp);
		
		return true;
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
		if (v.getClass() == Hovercraft.class) {
			return 100;
		}

		return 0;
	}

	/**
	 * Prints the list of the inventory to the screen or returns "no vehicles
	 * found"
	 * 
	 * @return
	 * @throws Exception 
	 */
	public void printInventory() throws Exception {
		if (vehicleList.size() > 0) {
			for (Vehicle v : vehicleList.values()) {
				System.out.println(v.stringify());
			}
		} else {
			throw new Exception("Failed to print inventory, there are no Vehicles in the inventory.");
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
