package customeexception;

public class InvalidChoiceException extends RuntimeException{

	String message;
	
	public InvalidChoiceException(String message ) {
		this.message=message;
	}
	  public String getMessage() {
		  return message;
		  
	  }

}
