package utils;

import java.util.Arrays;
import java.util.function.Predicate;
import java.util.regex.Pattern;

import config.Config;
import enumerations.AuthorLastName;
import enumerations.AuthorName;
import enumerations.PublisherCountry;
import enumerations.PublisherName;
import enumerations.Title;

public class Validators {
	
	public static String AUTHOR_LAST_NAMES = 
				Arrays.stream(AuthorLastName.values())
			      .map(a -> a.toString())
			      .reduce((r,s)->r = r + s).orElse("");
	public static String AUTHOR_NAMES = 
				Arrays.stream(AuthorName.values())
			      .map(a -> a.toString())
			      .reduce((r,s)->r = r + s).orElse("");
	public static String TITLES = 
			Arrays.stream(Title.values())
		      .map(t -> t.getValue())
		      .reduce((r,s)->r = r + s).orElse("");
	public static String COUNTRIES = 
			Arrays.stream(PublisherCountry.values())
		      .map(a -> a.toString())
		      .reduce((r,s)->r = r + s).orElse("");
	public static String PUBLISHER_NAMES = 
			Arrays.stream(PublisherName.values())
		      .map(t -> t.getValue())
		      .reduce((r,s)->r = r + s).orElse("");
	
	private static String isbnRegExp = "[1-9]\\d{12}";
	
	private static String dateRegExp = 
			"[12]\\d{3}-"
			+ "((0[1-9])|(1[0-2]))-"
			+ "((0[1-9])|([12]\\d)|(3[01]))";
	private static String priceRegExp = "\\d+[\\.,]\\d{0,2}";
	private static String authorsRegExp = 
			"((\\w+) (\\w+), ?){0,"+(Config.MAX_AUTHORS_NUMBER - 1)+"}"+"(\\w+) (\\w+)";
	
	public static Predicate<String> dateValidator = 
			(date) -> Pattern.matches(dateRegExp, date) &&
			          date.compareTo(Config.MIN_PUBLISHING_DATE.toString()) >= 0 &&
			          date.compareTo(Config.MAX_PUBLISHING_DATE.toString()) < 0;
	public static Predicate<String> isbnValidator = 
			(isbn) -> Pattern.matches(isbnRegExp, isbn); 
	public static Predicate<String> authorValidator =
			(author)->{
				String[] names = author.split(" ");
				return AUTHOR_LAST_NAMES.indexOf(names[0]) >= 0 &&
						AUTHOR_NAMES.indexOf(names[1]) >= 0;
			};
	public static Predicate<String >authorsValidator = 
			(authorsSet) -> {
				if(!Pattern.matches(authorsRegExp, authorsSet)) return false;
				String[] authors = authorsSet.split(", ?");
				for (String author : authors) {
					if (!authorValidator.test(author)) return false;
				}
				return true;
			};
	public static Predicate<String> titleValidator = 
			(title) -> title.length() != 0 && TITLES.indexOf(title) >= 0;
	public static Predicate<String> publisherValidator =
			(publisherString) -> {
				String[] names = publisherString.split(", ?");
				System.out.println(names[0]);
				System.out.println(names[1]);
				return COUNTRIES.indexOf(names[0]) >= 0 &&
						PUBLISHER_NAMES.indexOf(names[1]) >= 0;
			};

	public static Predicate<String> priceValidator = 
			(price) -> {
				if (Pattern.matches(priceRegExp, price)) {
					double priceDouble = Double.parseDouble(price);
					return priceDouble >= Config.MIN_PRICE && priceDouble < Config.MAX_PRICE;
				}
				else {return false;}
			};
	
}
