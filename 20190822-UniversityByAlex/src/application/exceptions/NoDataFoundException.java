package application.exceptions;

@SuppressWarnings("serial")
public class NoDataFoundException extends RuntimeException {

	public NoDataFoundException(String msg) {
		super(msg);
	}
}
