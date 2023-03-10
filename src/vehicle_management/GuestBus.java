package vehicle_management;

public class GuestBus extends Vehicle {
	private int seatNumber;

	public GuestBus(String producer, String color, double price, int seatNumber) {
		super(producer, color, price);
		this.seatNumber = seatNumber;
	}

	@Override
	public void tax() {
		double specialTax;
		if (seatNumber >= 5) {
			specialTax = this.getPrice() * 0.3;
		} else {
			specialTax = this.getPrice() * 0.5;
		}
		System.out.println("Tax: " + (this.getPrice() * 0.1 +  this.getPrice() * 0.2 + specialTax));
	}

	public int getSeatNumber() {
		return seatNumber;
	}

}
