package vehicle_management;

public class Truck extends Vehicle{

	public Truck(String producer, String color, double price) {
		super(producer, color, price);
	}

	@Override
	public void tax() {
		System.out.println("Tax: " + (this.getPrice() * 0.1 + this.getPrice() * 0.02));
	}

}
