package supermarket.management;

import java.text.ParseException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class China extends Product {
	private String producer;
	private Date inStockDate;
	private Date today = new Date();

	public China(String name, String code, int quantity, double price, String producer, String inStockDate)
			throws ParseException {
		super(name, code, quantity, price);
		this.producer = producer;
		this.inStockDate = convertDate(inStockDate);
	}

	@Override
	void consumptionLevel() {
		if (validateQuantity() && today.compareTo(inStockDate) >= 0) {
			if (quantity >= 50 && getDiffDays(inStockDate, today) >= 10) {
				System.out.println("Comsumption level: Slow");
			} else {
				System.out.println("Comsumption level: No result");
			}
		} else {
			System.out.println("Invalid!!!");
		}

	}

	public static long getDiffDays(Date d1, Date d2) {
		long diff = d2.getTime() - d1.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}

	public String getProducer() {
		return producer;
	}

	public Date getInStockDate() {
		return inStockDate;
	}

	public Date getToday() {
		return today;
	}
}
