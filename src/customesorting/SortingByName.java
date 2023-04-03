package customesorting;

import java.util.Comparator;

import sdbms.Student;

public class SortingByName implements Comparator<Student> 
{
	public int compare(Student x,Student y) {
		return x.getName().compareTo(y.getName());
}
}
