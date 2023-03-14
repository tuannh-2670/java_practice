package studyManagement;

public class LearningResult {
	private String semester;
	private double mediumScore;

	public LearningResult(String semester, double mediumScore) {
		this.semester = semester;
		this.mediumScore = mediumScore;
	}

	public String getSemester() {
		return semester;
	}

	public double getMediumScore() {
		return mediumScore;
	}
}
