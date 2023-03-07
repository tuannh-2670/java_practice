package police_vehicle_management;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class VehicleManagement {
	private static List<Vehicle> vehicleList = new ArrayList<Vehicle>();

	public static void main(String[] args) {
		VehicleOwner tuan = new VehicleOwner("204120020022", "Nguyen Huu Tuan", "tuan@gmail.com");
		VehicleOwner tuanA = new VehicleOwner("204120022023", "Nguyen Van Tuan A", "tuanA@gmail.com");
		VehicleOwner tuanB = new VehicleOwner("204120023024", "Nguyen Anh Tuan B", "tuanB@gmail.com");
		
		// Add vehicles successfully:
		addVehicle(new Car("A5501", "Honda", 2022, "Red", tuan, 4, "2 engine"));
		addVehicle(new Car("A5502", "Honda", 2023, "Blue", tuanA, 4, "1 engine"));
		addVehicle(new Car("A5503", "Honda", 2019, "Black", tuanB, 4, "3 engine"));
		addVehicle(new Truck("A4501", "Toyota", 2020, "Red", tuanA, "2 tons"));
		addVehicle(new Truck("A4502", "Toyota", 2021, "White", tuanB, "4 tons"));
		addVehicle(new Motobike("A3501", "Suzuki", 2020, "Yellow", tuanB, "125cc"));
		addVehicle(new Motobike("A3502", "Suzuki", 2021, "Pink", tuan, "155cc"));

		// Add vehicles failed:
		addVehicle(new Car("A5501", "Honda", 2022, "Red", tuan, 4, "2 engine"));
		addVehicle(new Car("A5501", "Honda", 2025, "Red", tuan, 4, "2 engine"));
		addVehicle(new Car("A5501", "Porches", 2022, "Red", tuan, 4, "2 engine"));

		// Find vehicle by vehicle number:
		findVehicleByNumber("A5501");

		// Find vehicle by id of owner:
		findVehicleByOnwerId("2041200230");

		// Delete vehicles by producer:
		System.out.println("**Delete Suzuki vehicles:");
		deleteVehiclesByProducer("Suzuki");

		// The most vehicles producer:
		mostVehiclesProducer();

		// Sort vehicles by vehicleNumber:
		sortVehiclesByNumber();

		// List quantity of management vehicles:
		listVehiclesByType();
	}

	public static void addVehicle(Vehicle vehicle) {
		System.out.println("**Adding vehicle");
		if (vehicle.isValidVehicle()) {
			vehicleList.add(vehicle);
			System.out.println("Result: Add vehicle successfully");
		} else {
			System.out.println("Result: Add vehicle failed");
		}
	}

	public static void findVehicleByNumber(String vehicleNumber) {
		for (Vehicle vehicle : vehicleList) {
			if (vehicle.getVehicleNumber() == vehicleNumber) {
				System.out.println("**Vehicle by number - " + vehicle.getVehicleNumber());
				vehicle.displayInfo();
			}
		}
	}

	public static void findVehicleByOnwerId(String id) {
		for (Vehicle vehicle : vehicleList) {
			if (vehicle.getVehicleOnwer().getId() == id) {
				System.out.println("**Vehicle by onwer id - " + vehicle.getVehicleOnwer().getId());
				vehicle.displayInfo();
			}
		}
	}

	public static void deleteVehiclesByProducer(String producer) {
		int vehicleListLength = vehicleList.size();
		System.out.println("Vehicles list before delete: " + vehicleListLength);
		for (int i = 0; i < vehicleListLength; i++) {
			if (vehicleList.get(i).getProducer() == producer) {
				System.out.println("Delete vehicle: " + vehicleList.get(i).getVehicleNumber() + " successfully");
				vehicleList.remove(i);
				vehicleListLength -= 1;
				i -= 1;
			}
		}
		System.out.println("Vehicles list after delete: " + vehicleList.size());
	}

	public static void mostVehiclesProducer() {
		Hashtable<String, Integer> hashMap = new Hashtable<String, Integer>();
		hashMap.put("Honda", 0);
		hashMap.put("Suzuki", 0);
		hashMap.put("Toyota", 0);
		hashMap.put("Yamaha", 0);
		for (Vehicle vehicle : vehicleList) {
			if (vehicle.getProducer() == "Honda") {
				hashMap.put("Honda", hashMap.get("Honda") + 1);
			} else if (vehicle.getProducer() == "Suzuki") {
				hashMap.put("Suzuki", hashMap.get("Suzuki") + 1);
			} else if (vehicle.getProducer() == "Toyota") {
				hashMap.put("Toyota", hashMap.get("Toyota") + 1);
			} else {
				hashMap.put("Yamaha", hashMap.get("Yamaha") + 1);
			}
		}
		String mostVehiclesProducer = null;
		int maxValue = Integer.MIN_VALUE;
		for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
			if (entry.getValue() > maxValue) {
				maxValue = entry.getValue();
				mostVehiclesProducer = entry.getKey();
			}
		}
		System.out.println("**The most vehicles producer is " + mostVehiclesProducer);
	}

	public static void sortVehiclesByNumber() {
		Collections.sort(vehicleList, new Comparator<Vehicle>() {
			@Override
			public int compare(Vehicle o1, Vehicle o2) {
				return o1.getVehicleNumber().compareTo(o2.getVehicleNumber());
			}
		});
		System.out.println("**The vehicles after sorting by number:");
		System.out.println(Collections.singletonList(vehicleList));
	}

	public static void listVehiclesByType() {
		Hashtable<String, Integer> hashMap = new Hashtable<String, Integer>();
		hashMap.put("Car", 0);
		hashMap.put("Motobike", 0);
		hashMap.put("Truck", 0);
		for (Vehicle vehicle : vehicleList) {
			if (vehicle instanceof Car) {
				hashMap.put("Car", hashMap.get("Car") + 1);
			} else if (vehicle instanceof Motobike) {
				hashMap.put("Motobike", hashMap.get("Motobike") + 1);
			} else {
				hashMap.put("Truck", hashMap.get("Truck") + 1);
			}
		}
		System.out.println("List quantity of vehicles by type: " + hashMap);
	}
}
