package library;

import java.time.LocalDate;

import dto.Author;
import dto.Book;
import dto.Publisher;
import enumerations.PublisherCountry;
import enumerations.Title;
import maplist.HashListMap;
import maplist.TreeListMap;

public class LibraryMaps extends Library{
	
	private TreeListMap<Author, Book> authorTM = new TreeListMap<>();
	private TreeListMap<String, Book> titleTM = new TreeListMap<>();
	private TreeListMap<LocalDate, Book> dateTM = new TreeListMap<>();
	private HashListMap<Publisher, Book> publisherHM = new HashListMap<>();
	private HashListMap<String, Book> countryHM = new HashListMap<>();
	private TreeListMap<Double, Book> priceTM = new TreeListMap<>();
	
	public static LibraryMaps of(int numBooks) {
		
		LibraryMaps lib = new LibraryMaps();
		lib.fillLibrary(numBooks);
		return lib;
	}
	
	@Override
	public boolean addBook(Book book) {
		
		if (!super.addBook(book)) return false;
		
		for (Author author : book.getAuthors())authorTM.add(author, book);
		titleTM.add(book.getTitle().getValue(), book);
		dateTM.add(book.getPublishingDate(), book);
		publisherHM.add(book.getPublisher(), book);
		countryHM.add(book.getPublisher().getCountry(), book);
		priceTM.add(book.getPrice(), book);
		
		return true;
	}

	@Override
	public Iterable<Book> getAllBooksOfAuthor(Author author) {
		return authorTM.get(author);
	}

	@Override
	public Iterable<Book> getAllBooksByTitle(Title title) {
		return titleTM.get(title.getValue());
	}

	@Override
	public Iterable<Book> getAllBooksInPublishingDatesRange(LocalDate from, LocalDate to) {
		return dateTM.getInRange(from, to);
	}

	@Override
	public Iterable<Book> getAllBooksByPublisher(Publisher publisher) {
		return publisherHM.get(publisher);
	}

	@Override
	public Iterable<Book> getAllBooksByPublisherCountry(PublisherCountry country) {
		return countryHM.get(country.toString());
	}

	@Override
	public Iterable<Book> getAllBooksInPriceRange(double minPrice, double maxPrice) {
		return priceTM.getInRange(minPrice, maxPrice);
	}

	@Override
	public Iterable<Book> getAllBooksSortedByAuthors() {
		return authorTM.getAll();
	}

	@Override
	public Iterable<Book> getAllBooksSortedByTitle() {
		return titleTM.getAll();
	}

	@Override
	public Iterable<Book> getAllBooksSortedByPublishingDate() {
		return dateTM.getAll();
	}

	@Override
	public Iterable<Book> getAllBooksSortedByPrice() {
		return priceTM.getAll();
	}

}
