package garage;

public class Motorcycle extends Vehicle {

	public Motorcycle(int w, int s, String c) {
		System.out.println("Motorcycle.");

		super.vehicleWheels = w;
		super.vehicleSpeed = s;
		super.vehicleColour = c;
	}

}
