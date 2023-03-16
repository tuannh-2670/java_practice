package studyManagement;

import java.util.ArrayList;
import java.util.List;

public abstract class Student {
	private String id;
	private String fullName;
	private String birthday;
	private int year;
	private double entryPoint;
	private List<LearningResult> results = new ArrayList<LearningResult>();

	public Student(String id, String fullName, String birthday, int year, double entryPoint,
			List<LearningResult> results) {
		this.id = id;
		this.fullName = fullName;
		this.birthday = birthday;
		this.year = year;
		this.entryPoint = entryPoint;
		this.results = results;
	}

	public void displayMediumScore() {
		for (LearningResult result : results) {
			System.out.println(
					"Diem trung binh " + result.getSemester() + " cua " + fullName + ": " + result.getMediumScore());
		}
	}

	public double getHighestMediumScore() {
		double highestScore = 0;
		for (LearningResult result : this.getResults()) {
			if (result.getMediumScore() > highestScore) {
				highestScore = result.getMediumScore();
			}
		}
		return highestScore;
	}

	public void displayInfo() {
		System.out.println("Student Info:");
		System.out.println("Id: " + id);
		System.out.println("Fullname: " + fullName);
		System.out.println("Entry year: " + year);
		System.out.println("Entry point: " + entryPoint);
	}

	public String getId() {
		return id;
	}

	public String getFullName() {
		return fullName;
	}

	public String getBirthday() {
		return birthday;
	}

	public int getYear() {
		return year;
	}

	public double getEntryPoint() {
		return entryPoint;
	}

	public List<LearningResult> getResults() {
		return results;
	}
}
