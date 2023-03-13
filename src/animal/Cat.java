package animal;

public class Cat extends Animal {
	private String hairColor;
	private double height;

	public Cat(String name, int age, String kind, String hairColor, double height) {
		super(name, age, kind);
		this.hairColor = hairColor;
		this.height = height;
	}

	@Override
	public void displayInfo() {
		super.displayInfo();
		System.out.println("Color: " + this.hairColor);
		System.out.println("heigt: " + this.height);
	}

	public String getHairColor() {
		return hairColor;
	}

	public double getHeight() {
		return height;
	}
}
