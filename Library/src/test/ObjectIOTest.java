package test;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import dto.Book;
import exceptions.WrongLinesException;
import library.Library;
import library.LibraryMaps;
import library.LibraryStreams;

public class ObjectIOTest {

	private static final int NUM_BOOKS = 5;
	private static final String dbFilename = "lib.dta";

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		
		LibraryStreams lib = new LibraryStreams();
//		lib.fillLibrary(NUM_BOOKS);
//		Write to file
//		try (
//			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(dbFilename, false)); 
//				){
//			for(Book book : lib.getAllBooks()) oos.writeObject(book);
////			oos.writeObject(lib.getAllBooks());
//		}
		// Read from file			
//		try (
//			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(dbFilename));
//			){
//			while(true){
//				try {
//					Book book = (Book)ois.readObject();
//					System.out.println(book);
//					lib.addBook(book);
//				} catch (EOFException e) {
//					break;
//				}
//			}
//		}
		System.out.println();
		lib.fromBinFile(dbFilename);
		for(Book b : lib.getAllBooks()) System.out.println(b);
	}

}
