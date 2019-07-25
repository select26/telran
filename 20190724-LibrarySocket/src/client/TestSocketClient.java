package client;

import java.io.IOException;

import dto.Book;
import exceptions.WrongLinesException;
import library.Library;
import library.LibraryMaps;

public class TestSocketClient {

	private static final int NUM_BOOKS = 5;

	public static void main(String[] args) throws IOException, WrongLinesException {
		
//		Library lib = new LibraryMaps();
//		lib.fillLibrary(NUM_BOOKS);
//		
//		for (Book book : lib.getAllBooks())System.out.println(book);
		TCP_Client_Single.tcpSimpleClient();
		
	}

}
