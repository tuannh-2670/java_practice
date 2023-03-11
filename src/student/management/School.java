package student.management;

import java.util.ArrayList;
import java.util.List;

public class School {
	private List<Student> studentList = new ArrayList<Student>();

	public void addStudent(Student student) {
		studentList.add(student);
	}

	public List<Student> getStudentList() {
		return studentList;
	}
}
