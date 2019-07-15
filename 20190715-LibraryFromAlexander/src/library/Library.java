package library;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Stream;

import dto.Book;
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
}
