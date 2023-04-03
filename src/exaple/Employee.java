package exaple;

public class Employee {
	
		 String id;//rule-1-> consider a count variable
		 static int count=101;
		 
		 Employee() {
			this.id="jspider"+count;//rule-2->initialize the count variable
			count++;//rule-3->increment the counter variable
		}
public static void main(String[] args) {
	Employee e1=new Employee();
	Employee e2=new Employee();
	Employee e3=new Employee();
	System.out.println(e1.id+"\n"+e2.id+"\n"+e3.id);
	
			
	
}

}

