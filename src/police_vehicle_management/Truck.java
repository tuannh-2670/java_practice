package police_vehicle_management;

public class Truck extends Vehicle {
	private String tonnage;

	public Truck(String vehicleNumber, String producer, int year, String color, VehicleOwner vehicleOnwer,
			String tonnage) {
		super(vehicleNumber, producer, year, color, vehicleOnwer);
		this.tonnage = tonnage;
	}

	@Override
	public void displayInfo() {
		super.displayInfo();
		System.out.println("Tonnage: " + this.tonnage);
	}

	public String getTonnage() {
		return tonnage;
	}
}
