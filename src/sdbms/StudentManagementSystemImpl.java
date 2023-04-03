package sdbms;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import customeexception.InvalidChoiceException;
import customeexception.StudentNotFoundException;
import customesorting.SortStudentById;
import customesorting.SortingByAge;
import customesorting.SortingByMarks;
import customesorting.SortingByName;
public class StudentManagementSystemImpl implements StudentManagementSystem {
	Scanner scan=new Scanner(System.in);//Scanner class for class
	Map<String,Student> db=new LinkedHashMap<String,Student>();//reference variable is Map and object is LinkedHashMap


	@Override
	public void addStudent() {
		//accepting age
		System.out.println("enter the age");
		int age=scan.nextInt();
		//acccepting name
		System.out.println("enter the name");
		String name=scan.next();
		//accepting marks
		System.out.println("enter the marks");
		int marks=scan.nextInt();
		Student std=new  Student(age,name,marks);//creating student object   
		db.put(std.getId(), std);
		System.out.println("student record inserted succesfully");
		System.out.println("your student id is "+std.getId());


	}
	@Override
	public void DisplayStudent() {
		System.out.println("enter the student id");
	  String id =scan.next();
		id=id.toUpperCase();//String is immutable so weshould store it in id
		//System.out.println("");
		if(db.containsKey(id)==true)
			//get the value (student Object )& invoke getId()
		{
			Student std=db.get(id);
			System.out.println("student details:");
			System.out.println("................");
			System.out.println("Id:"+std.getId());
			System.out.println("Id:"+std.getAge());
			System.out.println("Id:"+std.getName());
			System.out.println("Id:"+std.getMarks());
			//printing reference as toString() is Overriden 
			//System.out.println(std);
		}
		else
		{
			try{
				String message="student with Id "+id+" not found";
				throw new StudentNotFoundException(message);
				}
			catch(Exception e) {
				System.err.println(e.getMessage());
			}
			
		}
	}
	@Override
	public void  DisplayAllStudents(){
		if(db.size()>0){//if (db.isEmpty())
			System.out.println("student record are as follows:");
			System.out.println("-------------------------------");
			Set<String>keys=db.keySet();//jsp101,jsp102,jsp103
			for(String key :keys){
				System.out.println(db.get(key));
			}
		}
		else {
			try {
				String message="student Records not found";
				throw new StudentNotFoundException(message);
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}

	}
	@Override
	public void removeStudent() {
		//Accepting Student Id->toUpperCase()
		System.out.println("enter the stdent id");
		String id =scan.next();
		id=id.toUpperCase();
		if(db.containsKey(id)==true)
			//get the value (student Object )& invoke getId()
		{
			System.out.println("Student record Found:");
			System.out.println(db.get(id));//printing student object
			db.remove(id);
			System.out.println("student record Deleted Successfully");
			
		}
		else {
			try{
				String message="student with Id "+id+" not found";
				throw new StudentNotFoundException(message);
				}
			catch(Exception e) {
				System.err.println(e.getMessage());
			}
		}
	}
	@Override
	public void removeAllStudents() {
		if(db.size()>0){
			System.out.println("no of student records:"+ db.size());
			db.clear();
			System.out.println("all student records deleted successfully");
		}
		else{
			try{
				String message="no student record to delete";
				throw new StudentNotFoundException(message);
			}
			catch(Exception e) {
				System.err.println(e.getMessage());
			}
		}


	}
	@Override
	public void  UpdateStudent() {
		System.out.println("enter the id");
		String id=scan.next();
		id=id.toUpperCase();
		if(db.containsKey(id))
		{
			Student std=db.get(id);//getting the student object based on id
			//Logic to update
			System.out.println("to Update 1:age\n2:update Name\n3:Update marks");
			int choice=scan.nextInt();
			switch(choice)
			{
			case 1:
				System.out.println("enter the age");
				int age=scan.nextInt();
				std.setage(age);
				//acccepting age
				System.out.println("age updated Successfully");
				break;
		
			case 2:
				System.out.println("enter the name");
				String name=scan.next();
				std.setName(name);
				//accepting name
				System.out.println("name updated successfully");
				break;
				
			case 3:
				System.out.println("enter the marks");
				int marks=scan.nextInt();
				std.setmarks(marks);
				System.out.println("marks updated successfully");
				break;
				default:
					System.out.println("Invalid choice");
			}
			
			
			
		}
		else {
			try{
				String message="student with Id "+id+" not found";
				throw new StudentNotFoundException(message);
				}
			catch(Exception e) {
				System.err.println(e.getMessage());
			}
			
		}

	}
	@Override
	public void CountStudent() {
		System.out.println("number of students"+db.size());

	}
	public void sortStudent() {
		if(db.isEmpty()) {
		//converting map into keyset()
		Set<String> keys=db.keySet();
		//reference of list & object of arraylist Storing objects
		List<Student>list=new ArrayList<Student>();
		//traversing the keys
		for(String key :keys) {
			list.add(db.get(key));//getting Student object & adding in list
		}
		System.out.println("1:Sort student by Id\n2:Sort by age");
		System.out.println("3:Sort Student by name\n4: Sort Student by marks");
		System.out.println("enter choice");
		int choice=scan.nextInt();
		switch(choice) {
		case 1: 
			Collections.sort(list,new SortStudentById());
		display(list);
			break;
		case 2:
			Collections.sort(list,new SortingByName());
			display(list);
			break;
			
		case 3:
			Collections.sort(list,new SortingByMarks());
			display(list);
				break;
		
		case 4:
			Collections.sort(list,new SortingByAge());
			display(list);
				break;
				
		default:
			try {
				String message="invalid choice kindly enter valid choice";
				throw new InvalidChoiceException (message);
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
			}
		}
			else{
				try {
				String message="No sufficcient students records to sort";
				throw new StudentNotFoundException (message);
				
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}

			}
	}
	//Traversing a list of Student objects
	private static void display(List<Student>list)
	{
		for(Student s:list) {
			System.out.println(s);
			
		}
		
	}
		@Override	
	public void findStudentWithHighestMarks() {
			Set<String>keys=db.keySet();
			List<Student>list=new ArrayList<Student>();
			for(String key:keys) {
				list.add(db.get(key));//getting student object & adding in list
			}
			Collections.sort(list,new SortingByMarks());
			System.out.println("student with the highest Marks:");
			System.out.println(list.get(list.size()-1));
			
			
				
			
		

	}
		@Override
	public void findStudentWithLowestMarks() {
			Set<String>keys=db.keySet();
			List<Student>list=new ArrayList<Student>();
			for(String key:keys) {
				list.add(db.get(key));//getting student object & adding in list
			}
			Collections.sort(list,new SortingByMarks());
			System.out.println("student with the highest Marks:");
			System.out.println(list.get(0));

	}

}
