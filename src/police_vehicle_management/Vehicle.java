package police_vehicle_management;

import java.time.Year;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Vehicle {
	private String vehicleNumber;
	private String producer;
	private int year;
	private String color;
	private VehicleOwner vehicleOnwer;
	private static List<String> numberData = new ArrayList<String>();
	private static ArrayList<String> producerList = new ArrayList<String>(
			Arrays.asList("Honda", "Yamaha", "Toyota", "Suzuki"));

	public Vehicle(String vehicleNumber, String producer, int year, String color, VehicleOwner vehicleOnwer) {
		this.vehicleNumber = vehicleNumber;
		this.producer = producer;
		this.year = year;
		this.color = color;
		this.vehicleOnwer = vehicleOnwer;
	}

	public void displayInfo() {
		System.out.println("==Vehicle info:==");
		System.out.println("Number: " + this.vehicleNumber);
		System.out.println("Producer: " + this.producer);
		System.out.println("Year: " + this.year);
		System.out.println("Color: " + this.color);
		this.vehicleOnwer.displayInfo();
	}

	@Override
	public String toString() {
		return "Vehicle{" + "number=" + vehicleNumber + '\'' + ", producer=" + producer + ", year='" + year + '}'
				+ System.getProperty("line.separator");
	}

	public boolean isValidVehicle() {
		if (!isNumberExist() && isValidProducer() && isValidProducer()) {
			return true;
		}
		return false;
	}

	public boolean isNumberExist() {
		if (numberData.contains(vehicleNumber)) {
			System.out.println("\t _This vehicle number is already existed");
			return true;
		}
		numberData.add(vehicleNumber);
		return false;
	}

	public boolean isValidProducer() {
		if (producerList.contains(producer)) {
			return true;
		}
		System.out.println("\t _This producer is invalid");
		return false;
	}

	public boolean isValidYear() {
		int currentYear = Year.now().getValue();
		if (year >= 2000 && year <= currentYear) {
			return true;
		}
		System.out.println("\t _This year is invalid");
		return false;
	}

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public String getProducer() {
		return producer;
	}

	public int getYear() {
		return year;
	}

	public String getColor() {
		return color;
	}

	public VehicleOwner getVehicleOnwer() {
		return vehicleOnwer;
	}
}
