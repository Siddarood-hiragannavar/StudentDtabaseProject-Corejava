package customeexception;

public class StudentNotFoundException extends RuntimeException{
	String message;

	public StudentNotFoundException(String message){
		this.message=message;
	}
	public String getMesaage()//Override
	{
		return message;

	}


}
