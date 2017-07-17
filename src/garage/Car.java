package garage;

public class Car extends Vehicle {

	public Car() {
		System.out.println("Car.");
		
		super.vehicleWheels = 4;
		super.vehicleSpeed = 80;
	}

}
