package application.exceptions;

@SuppressWarnings("serial")
public class RemoveForbiddenException extends RuntimeException {
	
	public RemoveForbiddenException(String msg) {
		super(msg);
	}
}
