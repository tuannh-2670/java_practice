package vehicle_management;

public class Main {

	public static void main(String[] args) {
		Vehicle bike = new Bike("Demi", "Red", 2500);
		bike.tax();
		Vehicle motorbike = new Motorbike("Honda", "Blue", 7500);
		motorbike.tax();
		Vehicle truck = new Truck("Toyota", "Black", 6000);
		truck.tax();
		Vehicle bus1 = new GuestBus("Bus 1", "Yellow", 12000, 16);
		bus1.tax();
		Vehicle bus2 = new GuestBus("Bus 1", "Yellow", 8000, 4);
		bus2.tax();
	}

}
