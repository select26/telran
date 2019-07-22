package library;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
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

	//Второй параметр определяет функционал Append: если он true, то база на диске дополняется,
	//а не перезаписывается
	public boolean toBinFile(String dbFilename, boolean appendEnable) throws FileNotFoundException, ClassNotFoundException, IOException {
		if (appendEnable) fromBinFile(dbFilename);
		return toBinFile(dbFilename);
		/*
		boolean result = false;
		if (appendEnable==true) {
			HashMap<Long, Book> tempLib = new HashMap<>(isbnHM);
			try {
				fromBinFile(dbFilename);
			} catch (Exception e) {
				return false;
			}
			result = toBinFile(dbFilename);
			isbnHM = new HashMap<>(tempLib);
		} else {
			fromBinFile(dbFilename);
		}

		return result;
		*/
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
	
	private static final String ENUM_PKG = "enumerations";
	private static final String ENUM_PATH = "src/" + ENUM_PKG + "/";
	
	public static ArrayList<Class> enumClasses() throws RuntimeException {
		ArrayList<Class> enumClasses = new ArrayList<>();
		File file = new File(ENUM_PATH);
		for (String f: file.list()) {
//			System.out.println("Checking: " + f);
			if (isEnum(f)) {
//				System.out.println(f.split("\\.")[0]);
				try {
					enumClasses.add(Class.forName(ENUM_PKG+ "." + f.split("\\.")[0]));
				} catch (ClassNotFoundException e) {
					throw new RuntimeException(e);
				}
			}
		}
		return enumClasses;
	}

	private static boolean isEnum(String filename) {
		Stream<String> lines;
		try {
			lines = Files.lines(Paths.get(ENUM_PATH + filename));
		} catch (IOException e) {
			return false;
		}
		long count = lines.filter((s) -> s.contains("public enum"))
				.count();
//		System.out.println(ENUM_PATH + filename + "\t" + count);
		lines.close();
		return (count!=0);
	}
}
