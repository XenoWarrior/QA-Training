package garage;

public class Hovercraft extends Vehicle {

	public Hovercraft(int w, int s, String c) {
		System.out.println("Hovercraft.");

		super.vehicleWheels = w;
		super.vehicleSpeed = s;
		super.vehicleColour = c;
	}

}
