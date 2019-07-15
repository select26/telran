package utils;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import dto.Author;
import dto.Book;
import dto.Publisher;

public class Comparators {
	
	public static Comparator<Book> isbnBookComparator = 
			(book1, book2) -> Long.compare(book1.getIsbn(), book2.getIsbn());
			
	public static Comparator<Author> authorComparator = 
					(Author author1, Author author2) -> author1.toString().compareTo(author2.toString());
	public static Comparator<Book> authorsBookComparator = 
			(book1, book2) -> compareAuthorSets(book1.getAuthors(), book2.getAuthors());
	
	
	public static Comparator<Book> titleBookComparartor =
			(book1, book2) -> book1.getTitle().getValue().compareTo(book2.getTitle().getValue());
	public static Comparator<Book> publishingDateBookComparator = 
			(book1, book2) -> book1.getPublishingDate().compareTo(book2.getPublishingDate());
	public static Comparator<Book> priceBookComparator = 
			(book1, book2) -> Double.compare(book1.getPrice(), book2.getPrice());
	
	public static Comparator<Publisher> publisherNameComparator = 
					(publisher1, publisher2) -> publisher1.getName().compareTo(publisher2.getName());	
	public static Comparator<Publisher> publisherCountryComparator = 
					(publisher1, publisher2) -> publisher1.getCountry().compareTo(publisher2.getCountry());				
	public static Comparator<Publisher> publisherComparator = publisherCountryComparator
														 .thenComparing(publisherNameComparator);
	
	public static Comparator<Book> naturalBookComparator =
			 authorsBookComparator
			.thenComparing(titleBookComparartor)
			.thenComparing(publishingDateBookComparator)
			.thenComparing(priceBookComparator)
			.thenComparing(isbnBookComparator);
	
	
	private static int compareAuthorSets(Set<Author> authorSet1, Set<Author> authorSet2) {
		Iterator<Author> authorIterator1 = authorSet1.iterator();
		Iterator<Author> authorIterator2 = authorSet2.iterator();
		int comparingResult = 0;
		while(authorIterator1.hasNext() && authorIterator2.hasNext()) {
			comparingResult = authorComparator.compare(authorIterator1.next(), authorIterator2.next());
			if (comparingResult != 0)return comparingResult;
		}
		return authorSet1.size() - authorSet2.size();
	}
	
	

}
