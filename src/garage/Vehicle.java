package garage;

public class Vehicle {
	protected int vehicleWheels = 0;
	protected int vehicleSpeed = 0;
	protected int vehicleId = 0;

	public Vehicle() {
		System.out.print("Instance Vehicle is: ");
	}

	public String stringify() {
		return "[VehicleId: " + this.vehicleId + "] [Type: " + this.getClass().getName().replace("garage.", "") + ", Wheels: " + vehicleWheels + ", Speed: " + vehicleSpeed + "]";
	}

	public void setId(int id) {
		this.vehicleId = id;
	}
}
