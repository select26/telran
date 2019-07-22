package utils;

import java.util.function.Predicate;
import java.util.regex.Pattern;
import config.Config;
import enumerations.Enumerations;

public class Validators {
/*	
	public static HashSet<String> AUTHOR_LAST_NAMES = 
				Arrays.stream(AuthorLastName.values())
			      .map(a -> a.toString())
			      .collect(Collectors.toCollection(HashSet<String> :: new));
	public static HashSet<String> AUTHOR_NAMES = 
				Arrays.stream(AuthorName.values())
			      .map(a -> a.toString())
			      .collect(Collectors.toCollection(HashSet<String> :: new));
	public static HashSet<String> TITLES = 
			Arrays.stream(Title.values())
		      .map(t -> t.getValue())
		      .collect(Collectors.toCollection(HashSet<String> :: new));
	public static HashSet<String> COUNTRIES = 
			Arrays.stream(PublisherCountry.values())
		      .map(a -> a.toString())
		      .collect(Collectors.toCollection(HashSet<String> :: new));
	public static HashSet<String> PUBLISHER_NAMES = 
			Arrays.stream(PublisherName.values())
		      .map(t -> t.getValue())
		      .collect(Collectors.toCollection(HashSet<String> :: new));
*/	
	private static String isbnRegExp = "[1-9]\\d{12}";
	
	private static String dateRegExp = 
			"[12]\\d{3}-"
			+ "((0[1-9])|(1[0-2]))-"
			+ "((0[1-9])|([12]\\d)|(3[01]))";
	
	private static String priceRegExp = "\\d+\\.\\d{0,2}";
	
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
				return Enumerations.AUTHOR_LAST_NAMES_HS.contains(names[0]) &&
						Enumerations.AUTHOR_NAMES_HS.contains(names[1]);
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
			(title) -> title.length() != 0 && Enumerations.TITLES_HS.contains(title);
			
			
			
	public static Predicate<String> publisherValidator =
			(publisherString) -> {
				String[] names = publisherString.split(", ?");
				return Enumerations.PUBLISHER_COUNTRIES_HS.contains(names[0]) &&
						Enumerations.PUBLISHER_NAMES_HS.contains(names[1]);
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
