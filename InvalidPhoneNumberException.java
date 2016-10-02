
public class InvalidPhoneNumberException extends Exception {
	
	public InvalidPhoneNumberException(String message) {
		super("Invalid phone number:" + message);
		
	}

}
