package test;

import java.io.IOException;
import dto.Book;
import exceptions.WrongLinesException;
import library.Library;
import library.LibraryMaps;

public class Test {

	private static final int NUM_BOOKS = 5;

	public static void main(String[] args) throws IOException, WrongLinesException {
		
		Library lib = new LibraryMaps();
		lib.fillLibrary(NUM_BOOKS);
		
		for (Book book : lib.getAllBooks())System.out.println(book);
		
		//Library lib = LibraryMaps.of(NUM_BOOKS);
		
		
		/*TreeMap<String, Long> test = lib.getAllBooksAsStream()
				                      .collect(Collectors.groupingBy(
				                    		  book -> book.getPublisher().getCountry(),
				                    		  TreeMap<String, Long> :: new,
				                    		  Collectors.counting()	  
				                    		  ));
		for (String country : test.keySet()) 
			System.out.println(country+": "+test.get(country));*/
		
		/*for(Book book : lib.getAllBooksSortedByAuthors())
			System.out.println(book);*/
		
		//Book book = lib.getAllBooks().iterator().next();
		/*System.out.println(Validators
				.authorsValidator
				.test(book.getAuthors().toString().replaceAll("[\\[\\]]","")));*/
		/*System.out.println(Validators
						.titleValidator
						.test(book.getTitle().getValue()));*/
		/*System.out.println(Validators
		.dateValidator
		.test(book.getPublishingDate().toString()));*/
		/*System.out.println(Validators
		.publisherValidator
		.test(book.getPublisher().toString()));*/
		
		//System.out.println(Serializers.bookToCSV(book));
		//String csv = "2221460027717;[Fisher John, Fisher Thomas, Smith Samuel];Wind and Rain;2011-09-26;Germany, Blue star;966.57";
		//System.out.println(Serializers.csvToBook(csv));
		
//		LibraryMaps.of(10).toCSV("libraryDB.txt", false);	
/*		Library libCSV = new LibraryMaps();
		
		try {
			libCSV.fromCSV("libraryDB.txt");
		} catch (WrongLinesException e) {
			System.err.print(e);
			System.err.println(e.getLinesSkept()+" lines skept");
		}
		
		for (Book book : libCSV.getAllBooks())System.out.println(book);
*/		

	}

}
