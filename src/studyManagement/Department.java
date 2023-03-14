package studyManagement;

import java.util.ArrayList;
import java.util.List;

public class Department {
	private String name;
	private List<Student> studentList = new ArrayList<Student>();

	public Department(String name, List<Student> studentList) {
		this.name = name;
		this.studentList = studentList;
	}

	public String getName() {
		return name;
	}

	public List<Student> getStudentList() {
		return studentList;
	}
}
