package police_vehicle_management;

public class Motobike extends Vehicle {
	private String cubicMeter;

	public Motobike(String vehicleNumber, String producer, int year, String color, VehicleOwner vehicleOnwer,
			String cubicMeter) {
		super(vehicleNumber, producer, year, color, vehicleOnwer);
		this.cubicMeter = cubicMeter;
	}

	@Override
	public void displayInfo() {
		super.displayInfo();
		System.out.println("Cubic meter: " + this.cubicMeter);
	}

	public String getCubicMeter() {
		return cubicMeter;
	}
}
