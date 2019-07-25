package server.app;

import java.io.IOException;

import config.IConfig;
import dto.Book;
import library.Library;
import library.LibraryMaps;
import server.response.ObjectDateRangeSelect;
import server.response.ObjectISBNSelect;
import server.response.Protocol;
import server.server.SingleThreadServer;

public class TestServerBook {

	private static final int NUM_BOOKS = 5;	
	public static Library lib = new LibraryMaps();
	
	public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {

		
		lib.fillLibrary(NUM_BOOKS);
		
		for (Book book : lib.getAllBooks())System.out.println(book);
		
		System.out.println("Dont forget to launch the client side");
		(new SingleThreadServer(IConfig.PORT, IConfig.ONE_THREAD_PROTOCOL)).go();
	}

}
