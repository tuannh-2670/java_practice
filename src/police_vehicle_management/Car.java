package police_vehicle_management;

public class Car extends Vehicle {
	private int seatNumber;
	private String engineType;

	public Car(String vehicleNumber, String producer, int year, String color, VehicleOwner vehicleOnwer, int seatNumber,
			String engineType) {
		super(vehicleNumber, producer, year, color, vehicleOnwer);
		this.seatNumber = seatNumber;
		this.engineType = engineType;
	}

	@Override
	public void displayInfo() {
		super.displayInfo();
		System.out.println("Seat number: " + this.seatNumber);
		System.out.println("Engine: " + this.engineType);
	}

	public int getSeatNumber() {
		return seatNumber;
	}

	public String getEngineType() {
		return engineType;
	}
}
