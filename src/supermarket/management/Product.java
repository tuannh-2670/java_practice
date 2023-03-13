package supermarket.management;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Product {
	protected String name;
	protected String code;
	protected int quantity;
	protected double price;
	public static ArrayList<String> codeList = new ArrayList<String>();

	public Product(String name, String code, int quantity, double price) {
		this.name = name;
		this.code = code;
		this.quantity = quantity;
		this.price = price;
	}

	abstract void consumptionLevel();

	public boolean validateQuantity() {
		if (quantity >= 0) {
			return true;
		}

		return false;
	}

	public Date convertDate(String date) throws ParseException {
		Date convertedDate = new SimpleDateFormat("dd/MM/yyyy").parse(date);
		return convertedDate;
	}

	public boolean isCodeExist() {
		if (codeList.contains(code)) {
			return true;
		}
		codeList.add(code);
		return false;
	}

	public String getName() {
		return name;
	}

	public String getCode() {
		return code;
	}

	public int getQuantity() {
		return quantity;
	}

	public double getPrice() {
		return price;
	}
}

