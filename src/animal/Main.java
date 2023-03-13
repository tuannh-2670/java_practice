package animal;

public class Main {

	public static void main(String[] args) {
		Animal conCho1 = new Dog("Alaska", 3, "US", "White", 10.5);
		Animal conMeo1 = new Cat("Cat1", 2, "US", "Yellow", 3.5);
		Dog conCho2 = new Dog("Husky", 2, "EU", "Red", 7.5);
		Cat conMeo2 = new Cat("Cat2", 1, "VN", "Blue", 1.5);

		conCho1.displayInfo();
		conMeo1.displayInfo();
		conCho2.displayInfo();
		conMeo2.displayInfo();
	}

}
