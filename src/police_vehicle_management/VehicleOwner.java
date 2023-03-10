package police_vehicle_management;

public class VehicleOwner {
	private String id;
	private String fullname;
	private String email;

	public VehicleOwner(String id, String fullname, String email) {
		this.id = id;
		this.fullname = fullname;
		this.email = email;
	}
	
	public void displayInfo() {
		System.out.println("Owner info:");
		System.out.println("\t Id:" + this.id);
		System.out.println("\t Full name: " + this.fullname);
		System.out.println("\t Email: " + this.email);
	}

	public String getId() {
		return id;
	}

	public String getFullname() {
		return fullname;
	}

	public String getEmail() {
		return email;
	}
}
