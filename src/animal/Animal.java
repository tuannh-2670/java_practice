package animal;

public class Animal {
	private String name;
	private int age;
	private String kind;

	public Animal(String name, int age, String kind) {
		this.name = name;
		this.age = age;
		this.kind = kind;
	}

	public void displayInfo() {
		System.out.println("==Animal Info==");
		System.out.println("Name: " + this.name);
		System.out.println("Age: " + this.age);
		System.out.println("Kind: " + this.kind);
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getKind() {
		return kind;
	}
}
