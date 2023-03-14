package studyManagement;

import java.util.ArrayList;
import java.util.List;

public class StudyManagement {

	public static void main(String[] args) {
		List<LearningResult> tuanResult = new ArrayList<LearningResult>();
		List<LearningResult> anResult = new ArrayList<LearningResult>();
		tuanResult.add(new LearningResult("Hoc ki 1", 9.5));
		tuanResult.add(new LearningResult("Hoc ki 2", 9));
		anResult.add(new LearningResult("Hoc ki 1", 8.5));
		anResult.add(new LearningResult("Hoc ki 2", 7));

		Student tuan = new RegularStudent("T001", "Nguyen Huu Tuan", "10/10/2000", 2018, 28, tuanResult);
		Student an = new InserviceStudent("T002", "Chu Van An", "20/10/2000", 2018, 28, anResult, "Da Nang");

		// Kiểm tra loại sinh viên:
		checkStudentType(tuan);
		checkStudentType(an);

		// Hiển thị điểm trung bình của sinh viên:
		tuan.displayMediumScore();
		an.displayMediumScore();

		// Xác định số sinh viên chính quy của khoa:
		List<LearningResult> aResult = new ArrayList<LearningResult>();
		List<LearningResult> bResult = new ArrayList<LearningResult>();
		aResult.add(new LearningResult("Hoc ki 1", 7.5));
		bResult.add(new LearningResult("Hoc ki 1", 6.5));
		List<Student> mathStudentList = new ArrayList<Student>();
		mathStudentList.add(tuan);
		mathStudentList.add(an);
		mathStudentList.add(new RegularStudent("T003", "Nguyen Van A", "10/10/2000", 2018, 24.5, aResult));
		mathStudentList.add(new RegularStudent("T004", "Nguyen Van B", "10/10/2000", 2018, 20, bResult));

		Department math = new Department("Math", mathStudentList);
		countRegularStudent(math);

		// Tìm ra sinh viên có điểm đầu vào cao nhất của mỗi khoa:
		List<LearningResult> cResult = new ArrayList<LearningResult>();
		List<LearningResult> dResult = new ArrayList<LearningResult>();
		cResult.add(new LearningResult("Hoc ki 1", 7));
		dResult.add(new LearningResult("Hoc ki 1", 5));

		List<Student> historyStudentList = new ArrayList<Student>();
		historyStudentList.add(new RegularStudent("T006", "Nguyen Van C", "10/09/2000", 2018, 24.5, cResult));
		historyStudentList.add(new RegularStudent("T007", "Nguyen Van D", "16/0/2000", 2018, 20, dResult));
		Department history = new Department("History", historyStudentList);

		List<Department> departmentList = new ArrayList<Department>();
		departmentList.add(history);
		departmentList.add(math);

		departmentList.forEach(department -> findHighestEntryPoint(department));
	}

	public static void checkStudentType(Student student) {
		if (student instanceof RegularStudent) {
			System.out.println(student.getFullName() + " la sinh vien chinh quy");
		} else if (student instanceof InserviceStudent) {
			System.out.println(student.getFullName() + " la sinh vien tai chuc");
		}
	}

	public static void countRegularStudent(Department department) {
		int count = 0;
		for (Student student : department.getStudentList()) {
			if (student instanceof RegularStudent) {
				count += 1;
			}
		}
		System.out.println("So sinh vien tai chuc cua khoa " + department.getName() + ": " + count);
	}

	public static void findHighestEntryPoint(Department department) {
		if (department.getStudentList().size() == 0) {
			System.out.println("Khoa khong co sinh vien");
		} else {
			double highestPoint = 0;
			List<Student> highestPointStudent = new ArrayList<Student>();
			for (Student student : department.getStudentList()) {
				if (student.getEntryPoint() > highestPoint) {
					highestPoint = student.getEntryPoint();
					highestPointStudent.clear();
					highestPointStudent.add(student);
				} else if (student.getEntryPoint() == highestPoint) {
					highestPointStudent.add(student);
				}
			}
			System.out.println("Co " + highestPointStudent.size() + " sinh vien co diem dau vao cao nhat khoa "
					+ department.getName() + " la:");
			highestPointStudent.forEach(student -> student.displayInfo());
		}
	}
}
