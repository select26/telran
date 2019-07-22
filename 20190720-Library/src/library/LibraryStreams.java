package library;

import java.time.LocalDate;
import java.util.TreeSet;
import java.util.stream.Collectors;

import dto.Author;
import dto.Book;
import dto.Publisher;
import enumerations.PublisherCountry;
import enumerations.Title;
import utils.Comparators;

public class LibraryStreams extends Library{
	
	public static LibraryStreams of(int numBooks) {
		
		LibraryStreams lib = new LibraryStreams();
		lib.fillLibrary(numBooks);
		return lib;
	}

	@Override
	public Iterable<Book> getAllBooksOfAuthor(Author author) {
		return books.stream()
			  .filter(book -> book.getAuthors().contains(author))
			  .collect(Collectors.toCollection(TreeSet<Book> :: new));
		
	}

	@Override
	public Iterable<Book> getAllBooksByTitle(Title title) {
		return books.stream()
				  .filter(book -> book.getTitle() == title)
				  .collect(Collectors.toCollection(TreeSet<Book> :: new));
	}

	@Override
	public Iterable<Book> getAllBooksInPublishingDatesRange(LocalDate from, LocalDate to) {
		return books.stream()
				  .filter(book -> book.getPublishingDate().isAfter(from.minusDays(1)) &&
						          book.getPublishingDate().isBefore(to.plusDays(1)))
				  .collect(Collectors.toCollection(TreeSet<Book> :: new));
	}

	@Override
	public Iterable<Book> getAllBooksByPublisher(Publisher publisher) {
		return books.stream()
				  .filter(book -> book.getPublisher().equals(publisher))
				  .collect(Collectors.toCollection(TreeSet<Book> :: new));
	}

	@Override
	public Iterable<Book> getAllBooksByPublisherCountry(PublisherCountry country) {
		return books.stream()
				  .filter(book -> book.getPublisher().getCountry().equals(country.toString()))
				  .collect(Collectors.toCollection(TreeSet<Book> :: new));
	}

	@Override
	public Iterable<Book> getAllBooksInPriceRange(double minPrice, double maxPrice) {
		return books.stream()
				  .filter(book -> book.getPrice() >= minPrice && book.getPrice() <= maxPrice)
				  .collect(Collectors.toCollection(TreeSet<Book> :: new));
	}

	@Override
	public Iterable<Book> getAllBooksSortedByAuthors() {	
		return books.stream()
					.sorted(Comparators.authorsBookComparator
							.thenComparing(Comparators.naturalBookComparator))
					.collect(Collectors.toCollection(TreeSet<Book> :: new));
	}

	@Override
	public Iterable<Book> getAllBooksSortedByTitle() {
		return books.stream()
				.sorted(Comparators.titleBookComparartor
						.thenComparing(Comparators.naturalBookComparator))
				.collect(Collectors.toCollection(TreeSet<Book> :: new));
	}

	@Override
	public Iterable<Book> getAllBooksSortedByPublishingDate() {
		return books.stream()
				.sorted(Comparators.publishingDateBookComparator
						.thenComparing(Comparators.naturalBookComparator))
				.collect(Collectors.toCollection(TreeSet<Book> :: new));
	}

	@Override
	public Iterable<Book> getAllBooksSortedByPrice() {
		return books.stream()
				.sorted(Comparators.priceBookComparator
						.thenComparing(Comparators.naturalBookComparator))
				.collect(Collectors.toCollection(TreeSet<Book> :: new));
	}

}
