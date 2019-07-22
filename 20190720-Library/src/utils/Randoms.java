package utils;

import java.time.LocalDate;

import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import config.Config;
import dto.Author;
import dto.Book;
import dto.Publisher;
import enumerations.AuthorLastName;
import enumerations.AuthorName;
import enumerations.Enumerations;
import enumerations.PublisherCountry;
import enumerations.PublisherName;
import enumerations.Title;
import randomlib.RandomLib;

public class Randoms {
	
	/*static TreeMap<Double, PublisherCountry> PROBABILITIES_MAP = new TreeMap<>();
	static PublisherCountry[] PUBLISHER_COUNTRIES = PublisherCountry.values(); 
	static PublisherName[] PUBLISHER_NAMES = PublisherName.values();
	static AuthorName[] AUTHOR_NAMES = AuthorName.values();
	static AuthorLastName[] AUTHOR_LAST_NAMES = AuthorLastName.values();
	static Title[] TITLES = Title.values();
	
	static {
		double sumProbabilities = 0;
		for (PublisherCountry country : PUBLISHER_COUNTRIES) {
			sumProbabilities = sumProbabilities + country.getValue();
			PROBABILITIES_MAP.put(sumProbabilities, country);
		}
	}*/
	
	public static Publisher getRandomPublisher() {
		return new Publisher(
				RandomLib.randomOfArray(Enumerations.PUBLISHER_NAMES),
				Enumerations.PROBABILITIES_MAP.higherEntry(RandomLib.gen.nextDouble()).getValue());
	}
	
	public static Author getRandomAuthor() {
		return new Author (RandomLib.randomOfArray(Enumerations.AUTHOR_NAMES),
							RandomLib.randomOfArray(Enumerations.AUTHOR_LAST_NAMES));
	}
	
	public static Title getRandomTitle() {
		return RandomLib.randomOfArray(Enumerations.TITLES);
		
	}

	public static TreeSet<Author> getRandomAuthors(){
		int numAuthors = RandomLib.nextIntRange(1, Config.MAX_AUTHORS_NUMBER);
		TreeSet<Author> result = new TreeSet<>();
		while (result.size() < numAuthors) result.add(getRandomAuthor());
		return result;
	}
	
	public static Book getRandomBook() {
		long randomIsbn = RandomLib.nextLongRange(1000000000000L, 9999999999999L);
		Set<Author> randomAuthors = getRandomAuthors();
		Title randomTitle = getRandomTitle();
		LocalDate randomPublishingDate = RandomLib.randomLocalDate(Config.MIN_PUBLISHING_DATE, Config.MAX_PUBLISHING_DATE);
		Publisher randomPublisher = getRandomPublisher();
		double randomPrice = RandomLib.nextDoubleRange(Config.MIN_PRICE, Config.MAX_PRICE);
		randomPrice = ((int)(randomPrice*100.))/100.;
		
		return new Book(
				randomIsbn,
				randomAuthors,
				randomTitle,
				randomPublishingDate,
				randomPublisher,
				randomPrice	
			);
	}
}
