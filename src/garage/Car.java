package garage;

public class Car extends Vehicle {
	
	public Car(int w, int s, String c) {
		System.out.println("Car.");

		super.vehicleWheels = w;
		super.vehicleSpeed = s;
		super.vehicleColour = c;
	}
	
}
