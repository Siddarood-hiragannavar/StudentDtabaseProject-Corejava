package sdbms;
import java.util.Scanner;

import customeexception.InvalidChoiceException;

public class Solution {
	public static void main(String[] args) {
		System.out.println("WELCOME TO STUDENT MANAGEMENT SYSTEM");
		Scanner Scan=new Scanner(System.in);
		StudentManagementSystem s1= new StudentManagementSystemImpl();
		while (true)
		{
			System.out.println("1:to addStudent\n2:displayStudent\n3:DisplayAllStudents\n4:removeStuent\n5:removeAllStudents\n6:updateStudent\n7:countStudent");
			System.out.println("\n8:sortStudent\n9:findStudentWithHighestMarks\n10: findStudentWithLowestMarks");
			System.out.println("\11:enter the choice");
			int choice=Scan.nextInt();
			switch(choice)
			{
			case 1:
				s1.addStudent();

				break;

			case 2:
				s1.DisplayStudent();
				break;
			case 3:
				s1.DisplayAllStudents();
				break;
			case 4:
				s1.removeStudent();
				break;
			case 5:
				s1.removeAllStudents();
				break;
			case 6:
				s1.UpdateStudent();
				break;
			case 7:
				s1.CountStudent();
				break;
			case 8:
				s1.sortStudent();
				break;
			case 9:
				s1.findStudentWithHighestMarks();
				break;
			case 10:
				s1.findStudentWithLowestMarks();
			case 11:
				System.exit(0);
				break;
			default:
				System.out.println("Invalid Choice");
				try {
					String message="invalid choice kindly enter valid exception";
					throw new  InvalidChoiceException(message);
					
				}catch(Exception e) {
					System.out.println(e.getMessage());
				}

			}
			System.out.println(".......................");

		}

	}

}
