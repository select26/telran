package library;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Stream;

import dto.Book;
import exceptions.WrongBookDataException;
import exceptions.WrongLinesException;
import io.FileSystemIO;
import utils.Randoms;

public abstract class Library implements ILibrary {

	protected HashMap<Long, Book> isbnHM = new HashMap<>();
	protected ArrayList<Book> books = new ArrayList<>();

	public boolean addBook(Book book) {
		long isbn = book.getIsbn();
		if (isbnHM.containsKey(isbn)) return false;
		books.add(book);
		isbnHM.put(isbn, book);
		return true;
	}
	
	public void fillLibrary (int numBooks) {
		for (int i = 0; i < numBooks; i++)addBook(Randoms.getRandomBook());
	}
	
	public Book getBookByISBN(long isbn) {
		return isbnHM.get(isbn);
	}
	
	public Iterable<Book> getAllBooks(){
		return books;
	}

	public List<Book> getAllBooksAsList(){
		return new ArrayList<Book>(books);
	}
	
	public Set<Book> getAllBooksAsSet(){
		return new TreeSet<Book>(books);
	}
	public Stream<Book> getAllBooksAsStream(){
		return books.stream();
	}
	
	public boolean toCSV(String path) throws IOException {
		return FileSystemIO.dbToCSV(this, path, false);
	}
	
	public boolean toCSV(String path, boolean appendFlag) throws IOException {
		return FileSystemIO.dbToCSV(this, path, appendFlag);
	}
	
	public void fromCSV(String path) throws IOException, WrongLinesException {
		ArrayList<Book> fromCSV = new ArrayList<>();
		
		try {
			fromCSV = FileSystemIO.getFromCSV(path);
		} catch (WrongLinesException e) {
			fromCSV = e.getResult();
			throw e;
		}
		finally {
			for(Book book : fromCSV)addBook(book);
		}
	}
	
	public boolean toBinFile(String dbFilename) {
		try (
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(dbFilename, false)); 
			){
		for(Book book : getAllBooks()) oos.writeObject(book);
		} catch (IOException e) {
			return false;
		}
		return true;
	}
	
	public boolean fromBinFile(String dbFilename) throws FileNotFoundException, IOException, ClassNotFoundException {
		try (
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(dbFilename));
				){
				boolean flag = true;
				while(flag){
					try {
						Book book = (Book)ois.readObject();
//						System.out.println(book);
						addBook(book);
					} catch (EOFException e) {
						flag = false;
//						return false;
//						break;
					}
				}
				return flag;
		}
	}
}
