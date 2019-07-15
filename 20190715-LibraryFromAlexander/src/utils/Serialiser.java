package utils;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import dto.Author;
import dto.Book;
import dto.Publisher;
import enumerations.AuthorLastName;
import enumerations.AuthorName;
import enumerations.PublisherCountry;
import enumerations.PublisherName;
import enumerations.Title;
import exception.WrongBookDataException;

public class Serialiser {
	
	public static Map<String, Title> titleHM = 
			Arrays.stream(Title.values())
					.collect(Collectors.toMap(
							(Title title) -> title.getValue(), 
							(Title title) -> title));

	public static Map<String, PublisherName> publisherNameHM = 
			Arrays.stream(PublisherName.values())
					.collect(Collectors.toMap(
							(PublisherName name) -> name.getValue(), 
							(PublisherName name) -> name));

	
	public static String BookToCsv(Book book) {
		return
				book.getIsbn() + ";" +
				book.getAuthors() + ";" + 
				book.getTitle().getValue() + ";" +
				book.getPublishingDate() + ";" +
				book.getPublisher() + ";" +
				book.getPrice();
	}
	
	public static Book csvToBook(String csv) throws WrongBookDataException {
		String[] fields = csv.split(";");
		
		for (String s : fields) s = s.trim();
		
		if (fields.length != 6) 
			throw new WrongBookDataException("number of fields: " + csv); 
		long isbn = 0;
		if (Validators.isbnValidator.test(fields[0]))
			isbn = Long.parseLong(fields[0]);
		else {
			throw new WrongBookDataException("wrong isbn: " + csv);
		}
		
		Set<Author> authors = null;
		fields[1] = fields[1].replaceAll("[\\[\\]]", "");	 
		if (Validators.authorsValidator.test(fields[0])){
			authors = new TreeSet<>();
			String[] authorsString = fields[1].split(",?");
			for(String author : authorsString){
				String[] names = author.split(" ");
				authors.add(new Author(AuthorName.valueOf(names[1]),
								AuthorLastName.valueOf(names[0]))	);
			}
		}
		else {
//			throw new WrongBookDataException("wrong author: " + csv);
		}
		
		Title title = null;
		if (Validators.titleValidator.test(fields[2])){
			title = titleHM.get(fields[2]);
		}
		else {
			throw new WrongBookDataException("wrong title: " + csv);
		}		
		
		LocalDate editionDate = null;
		if (Validators.dateValidator.test(fields[3])){
			editionDate = LocalDate.parse(fields[3]);
		}
		else {
			throw new WrongBookDataException("wrong PublisherDate: " + csv);
		}		

		Publisher publisher = null;
		if (Validators.publisherValidator.test(fields[4])){
			String[] publisherTmpData = fields[4].split(", ?");
			publisher = new Publisher(
						publisherNameHM.get(publisherTmpData[1]),
						PublisherCountry.valueOf(publisherTmpData[0])
						);
		}
		else {
			throw new WrongBookDataException("wrong publisher: " + csv);
		}		
		
		double price = 0;
		if (Validators.priceValidator.test(fields[5])) {
			price = Double.parseDouble(fields[5]);
		}
		else {
			throw new WrongBookDataException("wrong price: " + csv);
		}		
		
		return new Book(
				isbn,
				authors,
				title,
				editionDate,
				publisher,
				price
				);
	}
}
