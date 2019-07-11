package library;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Stream;

import dto.Book;
import maplist.TreeListMap;
import random.RandomBook;

public abstract class Library implements ILibrary {
	
	protected HashMap<Long, Book> library = new HashMap<>();
	protected TreeListMap<String, Book> indexAuthor = new TreeListMap<>();
	protected TreeListMap<String, Book> indexTitle = new TreeListMap<>();
	protected TreeListMap<String, Book> indexPublisher = new TreeListMap<>();
	protected TreeListMap<LocalDate, Book> indexPublishingDate = new TreeListMap<>();
	protected TreeListMap<String, Book> indexPublisherCountry = new TreeListMap<>();
	protected TreeListMap<Double, Book> indexPrice = new TreeListMap<>();	
	
	@Override
	public void fillLibrary(int numBooks) {
		Book newBook;
		for (int i = 0; i < numBooks; i++) {
			newBook = RandomBook.randomBook();
			addBook(newBook);
		}
	}
	
	@Override
	public Book getBookByISBN(long isbn) {
		return library.get(isbn);
	}

	@Override
	public Iterable<Book> getAllBooks() {
		return getAllBooksAsList();
	}

	@Override
	public List<Book> getAllBooksAsList() {
		return new ArrayList<Book>(library.values());
	}
	
	@Override
	public Set<Book> getAllBooksAsSet() {
		return new HashSet<Book>(library.values());
	}

	@Override
	public Stream<Book> getAllBooksAsStream() {
		return library.values().stream();
	}

}
