package utils;

import java.time.LocalDate;
import java.util.Arrays;
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
import exceptions.WrongBookDataException;

public class Serializers {
	
	public static Map<String,Title> titleHM = 
			Arrays.stream(Title.values())
				.collect(Collectors.toMap(
						(Title title) -> title.getValue(), 
						(Title title) -> title));
	public static Map<String, PublisherName> publisherNameHM = 
			Arrays.stream(PublisherName.values())
				.collect(Collectors.toMap(
						(PublisherName name) -> name.getValue(), 
						(PublisherName name) -> name));
	
	public static String bookToCSV(Book book) {
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
		if (fields.length != 6)
			throw new WrongBookDataException("number of fields; "+csv);
		
		for (String s : fields) s = s.trim();
		
		String errors = "";
		
		long isbn = 0;
		if (Validators.isbnValidator.test(fields[0])) {
			isbn = Long.parseLong(fields[0]);
		}
		else {
			errors = errors+"isbn;";
		}
		
		Set<Author> authors = null;
		fields[1] = fields[1].replaceAll("[\\[\\]]","");
		if (Validators.authorsValidator.test(fields[1])) {
			authors = new TreeSet<>();
			String[] authorsStrings = fields[1].split(", ?");
			for (String author : authorsStrings) {
				String[] names = author.split(" ");
				authors.add(new Author(AuthorName.valueOf(names[1]),
									   AuthorLastName.valueOf(names[0])));
				
			}
		}
		else {
			errors = errors+"authors;";
		}
		
		Title title = null;
		if (Validators.titleValidator.test(fields[2])) {
			title = titleHM.get(fields[2]);
		}
		else {
			errors = errors+"title;";
		}
		
		LocalDate publishingDate = null;
		if (Validators.dateValidator.test(fields[3])) {
			publishingDate = LocalDate.parse(fields[3]);
		}
		else {
			errors = errors+"edition date;";
		}
		
		Publisher publisher = null;
		if (Validators.publisherValidator.test(fields[4])) {
			String[] publisherData = fields[4].split(", ?");
			publisher = new Publisher(publisherNameHM.get(publisherData[1]),
					                  PublisherCountry.valueOf(publisherData[0]));
		}
		else {
			errors = errors+"publisher;";
		}
		
		double price = 0.;
		if (Validators.priceValidator.test(fields[5])) {
			price = Double.parseDouble(fields[5]);
		}
		else {
			errors = errors+"price;";
		}
		
		if (!errors.isEmpty()) throw new WrongBookDataException(errors+csv);
		
		return new Book(
				isbn,
				authors,
				title,
				publishingDate,
				publisher,
				price
			);
		

		
	}

}
