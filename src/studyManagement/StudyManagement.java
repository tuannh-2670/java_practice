package studyManagement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
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
		List<Student> mathStudents = new ArrayList<Student>();
		mathStudents.add(tuan);
		mathStudents.add(an);
		mathStudents.add(new RegularStudent("T003", "Nguyen Van A", "10/10/2000", 2018, 24.5, aResult));
		mathStudents.add(new RegularStudent("T004", "Nguyen Van B", "10/10/2000", 2018, 20, bResult));

		Department math = new Department("Math", mathStudents);
		countRegularStudent(math);

		// Tìm ra sinh viên có điểm đầu vào cao nhất của mỗi khoa:
		List<LearningResult> cResult = new ArrayList<LearningResult>();
		List<LearningResult> dResult = new ArrayList<LearningResult>();
		cResult.add(new LearningResult("Hoc ki 1", 7));
		dResult.add(new LearningResult("Hoc ki 1", 5));

		List<Student> historyStudents = new ArrayList<Student>();
		historyStudents.add(new RegularStudent("T006", "Nguyen Van C", "10/09/2000", 2018, 24.5, cResult));
		historyStudents.add(new RegularStudent("T007", "Nguyen Van D", "16/0/2000", 2018, 20, dResult));
		Department history = new Department("History", historyStudents);

		List<Department> departments = new ArrayList<Department>();
		departments.add(history);
		departments.add(math);

		departments.forEach(department -> findHighestEntryPoint(department));

		// Lấy ra danh sách các sinh viên tại chức tại nơi liên kết đào tạo cho trước:
		List<LearningResult> exampleResult = new ArrayList<LearningResult>();
		exampleResult.add(new LearningResult("Hoc ki 1", 8.5));
		exampleResult.add(new LearningResult("Hoc ki 2", 7));
		List<Student> students = new ArrayList<Student>();
		students.add(tuan);
		students.add(an);
		students.add(new InserviceStudent("T010", "Han Lap", "10/05/2001", 2017, 23, exampleResult, "Hoi An"));
		students.add(new InserviceStudent("T011", "Tieu Viem", "09/04/2002", 2017, 24.5, exampleResult, "Hoi An"));

		getInserviceStudentByPlace(students, "Hoi An");

		// Lấy ra sinh viên có điểm trung bình ở học kỳ gần nhất từ 8.0 trở lên:
		getGoodStudent(students);

		// Tìm ra sinh viên có điểm trung bình học kỳ cao nhất:
		getHighestScoreStudent(students);

		// Sắp xếp sinh viên giảm dần theo năm vào học:
		sortStudentByYear(students);

		// Thống kê sinh viên theo năm vào học:
		getSumStudentByYear(students);
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
		for (Student student : department.getStudents()) {
			if (student instanceof RegularStudent) {
				count += 1;
			}
		}
		System.out.println("So sinh vien tai chuc cua khoa " + department.getName() + ": " + count);
	}

	public static void findHighestEntryPoint(Department department) {
		if (department.getStudents().size() == 0) {
			System.out.println("Khoa khong co sinh vien");
		} else {
			double highestPoint = 0;
			List<Student> highestPointStudent = new ArrayList<Student>();
			for (Student student : department.getStudents()) {
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

	public static void getInserviceStudentByPlace(List<Student> students, String place) {
		System.out.println("Danh sach sinh vien tai chuc tai " + place + ":");
		int count = 0;
		for (Student student : students) {
			if (student instanceof RegularStudent) {
				continue;
			} else if (student instanceof InserviceStudent
					&& ((InserviceStudent) student).getTrainingPlace() == place) {
				student.displayInfo();
				count += 1;
			}
		}
		if (count == 0) {
			System.out.println("Khong co sinh tai chuc nao tai " + place);
		}
	}

	public static void getGoodStudent(List<Student> students) {
		System.out.println("Danh sach sinh vien co diem >= 8.0 trong hoc ky gan nhat: ");
		int count = 0;
		for (Student student : students) {
			if (student.getResults().get(student.getResults().size() - 1).getMediumScore() >= 8.0) {
				student.displayInfo();
				count += 1;
			}
		}
		if (count == 0) {
			System.out.println("Khong co sinh nao co diem >= 0 trong hoc ky gan nhat.");
		}
	}

	public static void getHighestScoreStudent(List<Student> students) {
		double highestPoint = 0;
		List<Student> highestScoreStudent = new ArrayList<Student>();
		for (Student student : students) {
			if (student.getHighestMediumScore() > highestPoint) {
				highestPoint = student.getHighestMediumScore();
				highestScoreStudent.clear();
				highestScoreStudent.add(student);
			} else if (student.getHighestMediumScore() == highestPoint) {
				highestScoreStudent.add(student);
			}
		}
		System.out.println("Co " + highestScoreStudent.size() + " sinh vien co diem trung binh cao nhat:");
		highestScoreStudent.forEach((student) -> {
			student.displayInfo();
			System.out.println("Diem trung binh: " + student.getHighestMediumScore());
		});
	}

	public static void getSumStudentByYear(List<Student> students) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < students.size(); i++) {
			map.put(students.get(i).getYear(), 0);
		}
		students.forEach((student) -> {
			map.keySet().forEach((value) -> {
				if (value == student.getYear()) {
					map.put(student.getYear(), map.get(student.getYear()) + 1);
				}
			});
		});
		System.out.println("Thong ke sinh vien theo nam hoc : " + map);
	}
	
	public static void sortStudentByYear(List<Student> students) {
		System.out.println("Danh sach sinh vien giam dan theo nam hoc:");
		Collections.sort(students, new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				return o2.getYear() - o1.getYear();
			}
		});
		students.forEach(student -> student.displayInfo());
	}
}
