package studyManagement;

import java.util.List;

public class InserviceStudent extends Student {
	private String trainingPlace;

	public InserviceStudent(String id, String fullName, String birthday, int year, double entryPoint,
			List<LearningResult> resultList, String trainingPlace) {
		super(id, fullName, birthday, year, entryPoint, resultList);
		this.trainingPlace = trainingPlace;
	}

	public String getTrainingPlace() {
		return trainingPlace;
	}
}
