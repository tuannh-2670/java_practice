package vehicle_management;

public abstract class Vehicle {
	private String producer;
	private String color;
	private double price;

	public Vehicle(String producer, String color, double price) {
		this.producer = producer;
		this.color = color;
		this.price = price;
	}
	
	public abstract void tax();

	public String getProducer() {
		return producer;
	}

	public String getColor() {
		return color;
	}

	public double getPrice() {
		return price;
	}
}
