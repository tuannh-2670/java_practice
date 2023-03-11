package student.management;

public class Main {

	public static void main(String[] args) {
		School sc = new School();
		sc.addStudent(new Student("Nguyen Van A", 18, "DN"));
		sc.addStudent(new Student("Nguyen Thi B", 20, "QN"));
		sc.addStudent(new Student("Tran Van C", 23, "HCM"));
		sc.addStudent(new Student("Dang Thi D", 20, "HN"));
		sc.addStudent(new Student("Tran Van E", 23, "DN"));
		sc.addStudent(new Student("Tran Thi G", 23, "DN"));

		System.out.println("20 years old students:");
		for (Student student : sc.getStudentList()) {
			if (student.getAge() == 20) {
				student.displayInfo();
			}
		}
		System.out.println("======================");
		int count = 0;
		for (Student student : sc.getStudentList()) {
			if (student.getAge() == 23 && student.getAddress() == "DN") {
				count += 1;
			}
		}
		System.out.println("Number of students with 23 years old and Address in DN: " + count);
	}

}
