package server.response;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import dto.Book;
import server.app.TestServerBook;

//import dto.Person;

public class ObjectISBNSelect implements Protocol {

	@Override
	public String getResponse(String request) {

		Pattern pattern = Pattern.compile("\\d{13}");
		Matcher matcher = pattern.matcher(request);
		if (matcher.matches()) {
			Book res = TestServerBook.lib.getBookByISBN(Long.parseLong(request));
			if (res == null)
				System.out.println(request + ": book not found!");
			else
				System.out.println(TestServerBook.lib.getBookByISBN(Long.parseLong(request)).toString());
			return (res == null) ? "Book not found!" : res.toString();
		} else
			return "Error input data format! Enter 13 digits for ISBN.";

	}

}
