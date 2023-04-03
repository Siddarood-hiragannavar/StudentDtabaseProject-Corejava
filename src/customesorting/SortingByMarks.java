package customesorting;

import java.util.Comparator;

import sdbms.Student;

public class SortingByMarks implements  Comparator<Student>{
	public int compare(Student x,Student y) {
		return x.getMarks()-(y.getMarks());
}
}
