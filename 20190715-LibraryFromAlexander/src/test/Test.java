package test;

import java.util.TreeMap;
import java.util.stream.Collectors;

import com.sun.xml.internal.ws.developer.MemberSubmissionAddressing.Validation;

import dto.Author;
import dto.Book;
import dto.Publisher;
import enumerations.AuthorLastName;
import enumerations.AuthorName;
import enumerations.PublisherCountry;
import enumerations.PublisherName;
import enumerations.Title;
import exception.WrongBookDataException;
import library.Library;
import library.LibraryMaps;
import utils.Serialiser;
import utils.Validators;

public class Test {

	private static final int NUM_BOOKS = 3;

	public static void main(String[] args) throws WrongBookDataException {
		
		/*Library lib = new LibraryMaps();
		lib.fillLibrary(NUM_BOOKS);*/
		
		Library lib = LibraryMaps.of(NUM_BOOKS);
		
		/*TreeMap<String, Long> test = lib.getAllBooksAsStream()
				                      .collect(Collectors.groupingBy(
				                    		  book -> book.getPublisher().getCountry(),
				                    		  TreeMap<String, Long> :: new,
				                    		  Collectors.counting()	  
				                    		  ));
		for (String country : test.keySet()) 
			System.out.println(country+": "+test.get(country));*/
		
		for(Book book : lib.getAllBooksSortedByAuthors())
			System.out.println(book);
			
		Book book = lib.getAllBooks().iterator().next();
		System.out.println(Validators
							.dateValidator
							.test((book.getPublishingDate().toString())));
		System.out.println(Validators
							.isbnValidator
							.test(Long.toString(book.getIsbn())));
		
		System.out.println(Serialiser.BookToCsv(book));
		String str = "9463523539492;[Fisher Samuel, Fisher Thomas, Piper Robert];Sky and Mount;2004-06-07;France, Red star;363.29";
		System.out.println(Serialiser.csvToBook(str));
	}

}
