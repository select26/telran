package enumerations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.TreeMap;
import java.util.stream.Collectors;

import library.Library;

public class Enumerations {
	
	public static TreeMap<Double, PublisherCountry> PROBABILITIES_MAP = new TreeMap<>();
	public static ArrayList<Class> ENUMS = Library.enumClasses(); 
	
	
	public static PublisherCountry[] PUBLISHER_COUNTRIES = PublisherCountry.values(); 
	public static PublisherName[] PUBLISHER_NAMES = PublisherName.values();
	public static AuthorName[] AUTHOR_NAMES = AuthorName.values();
	public static AuthorLastName[] AUTHOR_LAST_NAMES = AuthorLastName.values();
	public static Title[] TITLES = Title.values();
	
	public static HashSet<String> AUTHOR_LAST_NAMES_HS = 
			Arrays.stream(AUTHOR_LAST_NAMES)
			.map(a -> a.toString())
			.collect(Collectors.toCollection(HashSet<String> :: new));
	public static HashSet<String> AUTHOR_NAMES_HS = 
			Arrays.stream(AUTHOR_NAMES)
			.map(a -> a.toString())
			.collect(Collectors.toCollection(HashSet<String> :: new));
	public static HashSet<String> TITLES_HS = 
			Arrays.stream(TITLES)
			.map(t -> t.getValue())
			.collect(Collectors.toCollection(HashSet<String> :: new));
	public static HashSet<String> PUBLISHER_COUNTRIES_HS = 
			Arrays.stream(PUBLISHER_COUNTRIES)
			.map(a -> a.toString())
			.collect(Collectors.toCollection(HashSet<String> :: new));
	public static HashSet<String> PUBLISHER_NAMES_HS = 
			Arrays.stream(PUBLISHER_NAMES)
			.map(t -> t.getValue())
			.collect(Collectors.toCollection(HashSet<String> :: new));
	
	
	static {
		double sumProbabilities = 0;
		for (PublisherCountry country : PUBLISHER_COUNTRIES) {
			sumProbabilities = sumProbabilities + country.getValue();
			PROBABILITIES_MAP.put(sumProbabilities, country);
		}
	}


}
