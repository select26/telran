package exception;

@SuppressWarnings("serial")
public class WrongBookDataException extends Exception{

	public WrongBookDataException(String msg) {
		super(msg);
	}
	
}
