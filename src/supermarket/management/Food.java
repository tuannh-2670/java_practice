package supermarket.management;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Food extends Product {
	private Date mfgDate;
	private Date expDate;
	private Date today = new Date();

	public Food(String name, String code, int quantity, double price, String mfgDate, String expDate)
			throws ParseException {
		super(name, code, quantity, price);
		this.mfgDate = convertDate(mfgDate);
		this.expDate = convertDate(expDate);
	}

	@Override
	void consumptionLevel() {
		if (validateDate() && validateQuantity()) {
			if (quantity > 0 && today.compareTo(expDate) <= 0) {
				System.out.println("Comsumption level: Hard to sell");
			} else {
				System.out.println("Comsumption level: No result");
			}
		} else {
			System.out.println("Date or Quantity is invalid!!!");
		}

	}

	public boolean validateDate() {
		if (expDate.compareTo(mfgDate) >= 0) {
			return true;
		}

		return false;
	}

	public Date getMfgDate() {
		return mfgDate;
	}

	public Date getExpDate() {
		return expDate;
	}

	public Date getToday() {
		return today;
	}
}
