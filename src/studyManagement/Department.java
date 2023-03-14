package studyManagement;

import java.util.ArrayList;
import java.util.List;

public class Department {
	private String name;
	private List<Student> students = new ArrayList<Student>();

	public Department(String name, List<Student> students) {
		this.name = name;
		this.students = students;
	}

	public String getName() {
		return name;
	}

	public List<Student> getStudents() {
		return students;
	}
}
