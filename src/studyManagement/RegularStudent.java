package studyManagement;

import java.util.List;

public class RegularStudent extends Student {

	public RegularStudent(String id, String fullName, String birthday, int year, double entryPoint,
			List<LearningResult> resultList) {
		super(id, fullName, birthday, year, entryPoint, resultList);
	}
}
