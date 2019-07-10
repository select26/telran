package app;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.TreeSet;
import java.util.stream.Stream;

import javax.swing.text.DateFormatter;

import sun.util.calendar.ZoneInfo;

public class TimeZoneApp {

	public static void main(String[] args) {

//		for(String s: new TreeSet<String>(ZoneId.getAvailableZoneIds())) System.out.println(s);
		String timeFormat = "dd MMMM yyyy, HH:mm zz VV";
		ZoneId zId = ZoneId.of("Asia/Omsk");
		ZonedDateTime zdt = ZonedDateTime.now(zId);
//		System.out.println(zdt.toInstant().toEpochMilli());
		System.out.println(zdt.format(DateTimeFormatter.ofPattern(timeFormat)));

		System.out.println(ZonedDateTime
							.now(ZoneId.of("Asia/Novosibirsk"))
								.format(DateTimeFormatter
									.ofPattern(timeFormat)));
	}

}
