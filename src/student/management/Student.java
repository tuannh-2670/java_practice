package student.management;

public class Student {
	private String fullName;
	private int age;
	private String address;
	
	public Student(String fullName, int age, String address) {
		this.fullName = fullName;
		this.age = age;
		this.address = address;
	}
	
	public void displayInfo() {
		System.out.println("===Student Info===");
		System.out.println("Full name: " + fullName);
		System.out.println("Age: " + age);
		System.out.println("Address: " + address);
	}
	
	public String getFullName() {
		return fullName;
	}

	public int getAge() {
		return age;
	}

	public String getAddress() {
		return address;
	}
}
