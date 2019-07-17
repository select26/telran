package library;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import dto.Author;
import dto.Book;
import dto.Publisher;
import enumerations.PublisherCountry;
import enumerations.Title;

public interface ILibrary {
	
	// books natural order: authors -> title -> publishing date -> price
	
	boolean addBook(Book book);
	void fillLibrary (int numBooks);
	
	Book getBookByISBN(long isbn);
	Iterable<Book> getAllBooks();
	
	List<Book> getAllBooksAsList();
	Set<Book> getAllBooksAsSet();
	Stream<Book> getAllBooksAsStream();
	
	Iterable<Book> getAllBooksOfAuthor(Author author);
	Iterable<Book> getAllBooksByTitle(Title title);
	Iterable<Book> getAllBooksInPublishingDatesRange(LocalDate from, LocalDate to); // to inclusive
	Iterable<Book> getAllBooksByPublisher(Publisher publisher);
	Iterable<Book> getAllBooksByPublisherCountry(PublisherCountry country);	
	Iterable<Book> getAllBooksInPriceRange(double minPrice, double maxPrice);
	
	Iterable<Book> getAllBooksSortedByAuthors();
	Iterable<Book> getAllBooksSortedByTitle();
	Iterable<Book> getAllBooksSortedByPublishingDate();
	Iterable<Book> getAllBooksSortedByPrice();

}
