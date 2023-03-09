package supermarket.management;

public class Electric extends Product {
	private double warrantyPeriod;
	private double wattage;

	public Electric(String name, String code, int quantity, double price, double warrantyPeriod, double wattage) {
		super(name, code, quantity, price);
		this.warrantyPeriod = warrantyPeriod;
		this.wattage = wattage;
	}

	@Override
	void consumptionLevel() {
		if (validateAttribute() && validateQuantity()) {
			if (quantity < 3) {
				System.out.println("Comsumption level: Good");
			} else {
				System.out.println("Comsumption level: Bad");
			}
		} else {
			System.out.println("Invalid!!!");
		}

	}

	public boolean validateAttribute() {
		if (warrantyPeriod >= 0 && wattage >= 0) {
			return true;
		}

		return false;
	}

}
