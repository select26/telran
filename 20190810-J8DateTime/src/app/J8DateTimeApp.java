package app;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Locale;
import java.util.Random;
import java.util.stream.Stream;

import randomlib.RandomLib;

public class J8DateTimeApp {

	public static void main(String[] args) {
		
		LocalDate now = LocalDate.now();
//		LocalDate now = LocalDate.of(1980, 9, 15);
//		System.out.println(now);
//		System.out.println(now.getDayOfWeek());
//		now = now.withMonth(8).withDayOfMonth(14).withYear(1976);
//		System.out.println(now);
//		System.out.println(now.with(ChronoField.MONTH_OF_YEAR,1));
//		System.out.println(now.with(Month.JULY).with(DayOfWeek.MONDAY));
		
//		LocalDate ago = now.minus(200, ChronoUnit.DECADES);
//		System.out.println(ago);
		
//		LocalDate now = LocalDate.now();
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(
//				"dd MMMM yyyy G, EEEE", new Locale("ru")
//				);
//		System.out.println(now.format(formatter));
//		System.out.println(LocalDate.parse("10 июля 2019 н.э., среда", formatter));
//		
//		LocalDate birthbay = LocalDate.of(1976, 8, 14);
//		Period p = Period.between(birthbay, now);
//		System.out.println(p.get(ChronoUnit.YEARS) + "y " + 
//						p.get(ChronoUnit.MONTHS) + "m " + 
//						p.get(ChronoUnit.DAYS) + "d");
//		System.out.println(now.minus(p));
		
		System.out.println(RandomLib.randomLocalDate(LocalDate.of(2001, 01, 01), LocalDate.of(2005, 01, 01)));
		Stream.generate(()->RandomLib.randomLocalDate(LocalDate.of(2001, 01, 01), LocalDate.of(2002, 02, 01)))
					.limit(20)
					.sorted()
					.forEach(c->System.out.println(c));
		System.out.println();
		System.out.println(now);
		System.out.println(now.with(TemporalAdjusters.next(DayOfWeek.SUNDAY)));
		System.out.println(now.with(TemporalAdjusters.dayOfWeekInMonth(3, DayOfWeek.TUESDAY)));
	}
	
//	public LocalDate nextWorkDay (LocalDate, num) {
//		
//	}
	
//	static Random gen = new Random();
//	public static LocalDate randomLocalDate(LocalDate begin, LocalDate end) {
//		long beginDays = begin.toEpochDay();
//		long endDays = end.toEpochDay();
//		int diapazon = (int) (endDays - beginDays);
//		return LocalDate.ofEpochDay(beginDays + gen.nextInt(diapazon));
//	}
}
