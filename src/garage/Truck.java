package garage;

public class Truck extends Vehicle{

	public Truck() {
		System.out.println("Truck.");
		
		super.vehicleWheels = 6;
		super.vehicleSpeed= 70;
	}
	
}
