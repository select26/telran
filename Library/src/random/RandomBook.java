package random;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

import config.Config;
import dto.Author;
import dto.Book;
import dto.Publisher;
import enumerations.AuthorLastName;
import enumerations.AuthorName;
import enumerations.PublisherCountry;
import enumerations.PublisherName;
import enumerations.Title;
import randomlib.RandomLib;

public class RandomBook {

	public static Book randomBook() {
//	private long isbn;  							// 13 digits
//	private Set<Author> authors;
//	private Title title;
//	private LocalDate publishingDate;
//	private Publisher publisher;
//	private double price;        					// 2 digits after dot
		Book book = new Book();
		book.setIsbn(randomIsbn());
		book.setAuthors(randomAuthorsSet());
		book.setPublishingDate(randomPublishingDate());
		book.setPrice(randomPrice());
		book.setTitle(randomTitle());
		book.setPublisher(randomPublisher());
		return book;
	}
	
	public static long randomIsbn() {
		return (long) RandomLib.nextDoubleRange(1000000000000L, 7999999999999L);
	}

	public static LocalDate randomPublishingDate () {
		return RandomLib.randomLocalDate(Config.MIN_PUBLISHING_DATE, Config.MAX_PUBLISHING_DATE);
	}
	
	public static double randomPrice() {
		return ( (int) (RandomLib.nextDoubleRange(Config.MIN_PRICE, Config.MAX_PRICE) * 100) ) / 100.;
	}
	
	public static Set<Author> randomAuthorsSet() {
		int maxAutors = RandomLib.nextIntRange(1, Config.MAX_AUTHORS_NUMBER+1);
		LinkedHashSet<Author> authors = new LinkedHashSet<>();
		for (int i = 0; i < maxAutors; i++) {
			authors.add(randomAutor());
		}
		return authors;
	}

	private static Author randomAutor() {
		Author author = new Author();
		author.setFirstName(AuthorName.values()[RandomLib.nextIntRange(0, AuthorName.values().length-1)].toString());
		author.setLastName(AuthorLastName.values()[RandomLib.nextIntRange(0, AuthorLastName.values().length-1)].toString());
//		author.setFirstName("Vasisualy");
//		author.setLastName("Lokhankin");
		return author;
	}
	
	private static Title randomTitle() {
		return Title.values()[RandomLib.nextIntRange(0, Title.values().length-1)];
	}
	
	private static Publisher randomPublisher() {
		String randomPublisherName = randomPublisherName();
		String randomPublisherCountry = randomPublisherCountry();
		return new Publisher(randomPublisherName, randomPublisherCountry);
	}
	private static String randomPublisherName() {
		return PublisherName.values()[RandomLib.nextIntRange(0, (PublisherName.values().length-1))].toString();
	}
	
	private static String randomPublisherCountry() {
		return PublisherCountry.values()[RandomLib.nextIntRange(0, (PublisherCountry.values().length-1))].toString();
	}
}
