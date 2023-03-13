package animal;

public class Dog extends Animal {
	private String color;
	private double weight;

	public Dog(String name, int age, String kind, String color, double weight) {
		super(name, age, kind);
		this.color = color;
		this.weight = weight;
	}

	@Override
	public void displayInfo() {
		super.displayInfo();
		System.out.println("Color: " + this.color);
		System.out.println("Weigth: " + this.weight);
	}

	public String getColor() {
		return color;
	}

	public double getWeight() {
		return weight;
	}
}
