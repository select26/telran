package server.response;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import dto.Book;
import server.app.TestServerBook;

public class ObjectDateRangeSelect implements Protocol {

	@Override
	public String getResponse(String request) {
		String dateRE = "[12]\\d{3}[-\\.]((0\\d)|(1[0-2]))[-\\.]((0[1-9])|([12]\\d)|(3[01]))"
				+ ","
				+ "[12]\\d{3}[-\\.]((0\\d)|(1[0-2]))[-\\.]((0[1-9])|([12]\\d)|(3[01]))";
		if (Pattern.matches(dateRE, request)) {
			System.out.println(LocalDate.now());
			LocalDate begin = null;
			LocalDate end = null;
			String[] dates = request.split(",");
			begin = LocalDate.parse(dates[0]);
			end = LocalDate.parse(dates[1]);
			// for (Book b :
			// TestServerBook.lib.getAllBooksInPublishingDatesRange(begin, end)
			// )
			// System.out.println(b.toString());
			String res = "";
			for (Book b : TestServerBook.lib.getAllBooksInPublishingDatesRange(begin, end)) {
				if (b != null) res = res + "=@=" + b.toString();
			}

			if (res.length() == 0)
				System.out.println(request + ": book not found!");
			else
				System.out.println(res);
			return (res.length() == 0) ? "Books not found!" : res;
		} else
			return "Error input data format! Enter data in format: YYYY-MM-DD,YYYY-MM-DD";
	}

}
