package library;

import java.time.LocalDate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.Stream.Builder;

import dto.Author;
import dto.Book;
import dto.Publisher;
import enumerations.PublisherCountry;
import enumerations.Title;

public class LibraryStreams extends Library{

//	Builder<Book> libBuilder = Stream.builder();
	
	@Override
	public boolean addBook(Book book) {
		boolean result = library.put(book.getIsbn(), book) != null;
//		indexAuthor.add(book.getAuthors().toString(), book);
//		indexTitle.add(book.getTitle().toString(), book);
//		indexPublisher.add(book.getPublisher().toString(), book);
//		indexPublishingDate.add(book.getPublishingDate(), book);
//		indexPublisherCountry.add(book.getPublisher().getCountry(), book);
//		indexPrice.add(book.getPrice(), book);
	
//		libBuilder.accept(book);
		return result;
	}

//	@Override
//	public Book getBookByISBN(long isbn) {
//		libBuilder.build().filter((Book book) -> book.getIsbn()==isbn)
//		;
//	}

	@Override
	public Iterable<Book> getAllBooksOfAuthor(Author author) {
		return library.values()
					.stream()
					.filter(b -> b.getAuthors().toString().contains(author.toString()))
					.collect(Collectors.toList());
	}

	@Override
	public Iterable<Book> getAllBooksByTitle(Title title) {
		return library.values()
					.stream()
					.filter(b -> b.getTitle().toString().contains(title.toString()))
					.collect(Collectors.toList());
	}
	
	@Override
	public Iterable<Book> getAllBooksInPublishingDatesRange(LocalDate from, LocalDate to) {
		return library.values()
				.stream()
				.filter(b -> b.getPublishingDate().isAfter(from) || b.getPublishingDate().isBefore(to))
				.collect(Collectors.toList());
	}

	@Override
	public Iterable<Book> getAllBooksByPublisher(Publisher publisher) {
		return library.values()
				.stream()
				.filter(b -> b.getPublisher().toString().equals(publisher.toString()))
				.collect(Collectors.toList())
				;
	}

	@Override
	public Iterable<Book> getAllBooksByPublisherCountry(PublisherCountry country) {
		return library.values()
				.stream()
				.filter(b -> b.getPublisher().getCountry().toString().equals(country.toString()))
				.collect(Collectors.toList())
				;
	}

	@Override
	public Iterable<Book> getAllBooksInPriceRange(double minPrice, double maxPrice) {
		return library.values()
				.stream()
				.filter(b -> Double.compare(b.getPrice(), minPrice) >= 0 || 
							Double.compare(b.getPrice(), maxPrice) <= 0)
				.collect(Collectors.toList())
				;
	}

	@Override
	public Iterable<Book> getAllBooksSortedByAuthors() {
		
		return null;
	}

	@Override
	public Iterable<Book> getAllBooksSortedByTitle() {
		
		return null;
	}

	@Override
	public Iterable<Book> getAllBooksSortedByPublishingDate() {
		
		return null;
	}

	@Override
	public Iterable<Book> getAllBooksSortedByPrice() {
		
		return null;
	}

}
