package application.exceptions;

@SuppressWarnings("serial")
public class NoStudentsException extends RuntimeException {
	
	public NoStudentsException(String msg) {
		super(msg);
	}

}
