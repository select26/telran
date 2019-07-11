
package library;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import dto.Author;
import dto.Book;
import dto.Publisher;
import enumerations.PublisherCountry;
import enumerations.Title;
import maplist.TreeListMap;
import random.RandomBook;

public class LibraryMaps extends Library{

//	HashMap<Long, Book> library = new HashMap<>();
	
	TreeListMap<String,Book> tst = new TreeListMap<>();
	
	@Override
	public boolean addBook(Book book) {
		boolean result = library.put(book.getIsbn(), book) != null;
		indexAuthor.add(book.getAuthors().toString(), book);
		indexTitle.add(book.getTitle().toString(), book);
		indexPublisher.add(book.getPublisher().toString(), book);
		indexPublishingDate.add(book.getPublishingDate(), book);
		indexPublisherCountry.add(book.getPublisher().getCountry(), book);
		indexPrice.add(book.getPrice(), book);
		return result;
	}

//	@Override
//	public void fillLibrary(int numBooks) {
//		Book newBook;
//		for (int i = 0; i < numBooks; i++) {
//			newBook = RandomBook.randomBook();
//			addBook(newBook);
//		}
//	}
//
//	@Override
//	public Book getBookByISBN(long isbn) {
//		return library.get(isbn);
//	}

//	@Override
//	public Iterable<Book> getAllBooks() {
//		
//		return null;
//	}

//	@Override
//	public List<Book> getAllBooksAsList() {
//		
//		return null;
//	}

//	@Override
//	public Set<Book> getAllBooksAsSet() {
//		
//		return null;
//	}

//	@Override
//	public Stream<Book> getAllBooksAsStream() {
//		
//		return null;
//	}

	@Override
	public Iterable<Book> getAllBooksOfAuthor(Author author) {
		return indexAuthor.get(author.toString()) ;
	}

	@Override
	public Iterable<Book> getAllBooksByTitle(Title title) {
		return indexTitle.get(title.toString());
	}

	@Override
	public Iterable<Book> getAllBooksInPublishingDatesRange(LocalDate from, LocalDate to) {
		return indexPublishingDate.getInRange(from, to);
	}

	@Override
	public Iterable<Book> getAllBooksByPublisher(Publisher publisher) {
		return indexPublisher.get(publisher.toString());
	}

	@Override
	public Iterable<Book> getAllBooksByPublisherCountry(PublisherCountry country) {
		return indexPublisherCountry.get(country.toString());
	}

	@Override
	public Iterable<Book> getAllBooksInPriceRange(double minPrice, double maxPrice) {
		return indexPrice.getInRange(minPrice, maxPrice);
	}

	@Override
	public Iterable<Book> getAllBooksSortedByAuthors() {
		return indexAuthor.getAll();
	}

	@Override
	public Iterable<Book> getAllBooksSortedByTitle() {
		return indexTitle.getAll();
	}

	@Override
	public Iterable<Book> getAllBooksSortedByPublishingDate() {
		return indexPublishingDate.getAll();	
	}

	@Override
	public Iterable<Book> getAllBooksSortedByPrice() {
		return indexPrice.getAll();
	}

}

