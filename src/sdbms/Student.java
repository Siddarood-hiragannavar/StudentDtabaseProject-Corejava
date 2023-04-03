package sdbms;

public class Student {
	private String id;
	static int count=101;
	private int age;
	private String name;
	private int marks;

	Student(int age,String name, int marks)
	{
		this.id="jsp"+count;
		this.age=age;
		this.name=name;
		this.marks=marks;
		count++;
	}
public	void setage(int age)
	{
		this.age=age;
	}
	int getAge()
	{
		return age;
		
	}
	void setName(String name)
	{
		this.name=name;
	}
	public String getName()
	{
		return name;
	}
	void setmarks(int marks)
	{
		this.marks=marks;
	}
	public int getMarks()
	{
		return marks;
	}
	public String getId()
	{
		return id;
	}
	@Override
	public String toString() {
		return "Id is:"+ id+"AGE is:"+age+"and NAME is:"+name+"MARKS are :"+marks;
		
	}
	
	}
	


