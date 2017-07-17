package garage;

public class Motorcycle extends Vehicle {

	public Motorcycle() {
		System.out.println("Motorcycle.");
		
		super.vehicleWheels = 2;
		super.vehicleSpeed= 100;
	}

}
