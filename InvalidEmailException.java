
public class InvalidEmailException extends Exception {
	
	public InvalidEmailException(String message) {
		super("Invalid email address:" + message);
	}

}
