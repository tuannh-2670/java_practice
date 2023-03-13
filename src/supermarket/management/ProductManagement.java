package supermarket.management;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class ProductManagement {
	public static List<Product> productList = new ArrayList<Product>();

	public static void vat(Product product) {
		if (product instanceof China || product instanceof Electric) {
			System.out.println("VAT: " + product.price * 0.1);
		} else if (product instanceof Food) {
			System.out.println("VAT: " + product.price * 0.05);
		}
	}

	public static void main(String[] args) throws ParseException {
		// Consumption level
		System.out.println("===Valid Food===");
		Product salad = new Food("Salad", "S001", 5, 12.0, "01/01/2023", "25/04/2023");
		vat(salad);
		salad.consumptionLevel();
		System.out.println("===Invalid Food===");
		Product expiredSalad = new Food("Salad", "S001", 5, 15.0, "01/01/2023", "20/01/2023");
		expiredSalad.consumptionLevel();
		System.out.println("===Valid Electric===");
		Product electric = new Electric("Air Conditional", "A001", 5, 15.0, 3.5, 50.0);
		vat(electric);
		electric.consumptionLevel();
		System.out.println("===Invalid Electric===");
		Product invalidElectric = new Electric("Air Conditional", "A002", 5, 15.0, -7.0, -50.0);
		invalidElectric.consumptionLevel();
		System.out.println("===Valid China===");
		Product china = new China("China1", "C001", 55, 20.0, "Beijing", "10/02/2023");
		vat(china);
		china.consumptionLevel();
		System.out.println("===Invalid China===");
		Product invalidChina = new China("China2", "C002", 5, 15.0, "ShangHai", "10/04/2023");
		invalidChina.consumptionLevel();

		// Add products:
		addProduct(salad);
		addProduct(electric);
		addProduct(china);
		addProduct(new Food("Salad", "S001", 1, 10.0, "01/01/2023", "25/04/2023"));
	}

	public static void addProduct(Product product) {
		if (product.isCodeExist()) {
			System.out.println("Faled: This product code is already exist");
		} else {
			productList.add(product);
			System.out.println("Add product successfullly");
		}
	}
}
