package exceptions;

@SuppressWarnings("serial")
public class WrongBookDataException extends Exception{
	
	public WrongBookDataException(String msg) {
		super(msg);
	}

}
