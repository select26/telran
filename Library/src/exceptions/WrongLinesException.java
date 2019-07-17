package exceptions;

import java.util.ArrayList;

import dto.Book;

public class WrongLinesException extends Exception{
	
	private int linesSkept;
	private ArrayList<Book> result;
	private String msg;
	
	public WrongLinesException(int linesSkept, ArrayList<Book> result, String msg) {
		super(msg);
		this.linesSkept = linesSkept;
		this.result = result;
	}

	public int getLinesSkept() {
		return linesSkept;
	}

	public ArrayList<Book> getResult() {
		return result;
	}

}
