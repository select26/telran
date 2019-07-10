package app;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.TemporalAdjusters;

public class nextWorkDay {
	
	private static DayOfWeek nonWorkingDay = DayOfWeek.SATURDAY;
	
	public static void main(String[] args) {
		System.out.println(adjustTo (LocalDate.now(), 8) );
	}
	
	public static LocalDate adjustTo (LocalDate date, int num) {
		int numOfWeeks = num / 6;
		if (num < 6) {
			for (long i = date.toEpochDay(); i <= date.toEpochDay() + num; i++)
				if (LocalDate.ofEpochDay(i).getDayOfWeek().equals(nonWorkingDay)) numOfWeeks++;
		}

//		if (Period.between(date, date.with(TemporalAdjusters.next(nonWorkingDay))).getDays()<6) 
//			numOfWeeks++;
		
		LocalDate newDate = date.plusDays(num + numOfWeeks);
		if (newDate.getDayOfWeek().equals(nonWorkingDay)) newDate = newDate.plusDays(1); 
		return newDate;
	}

}
