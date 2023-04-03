package customesorting;

import java.util.Comparator;

import sdbms.Student;

public class SortStudentById implements Comparator<Student> {
	public int compare(Student x,Student y) {
		return x.getId().compareTo(y.getId());
		
	}

}
//x->object to be Inserted & -> already existing object
//for SString comparison,we are compareTo()present in String Class.
