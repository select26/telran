package config;

import java.time.LocalDate;

public class Config {
	
	public static final int MAX_AUTHORS_NUMBER = 3;
	public static final LocalDate MIN_PUBLISHING_DATE = LocalDate.of(2000, 1, 1);
	public static final LocalDate MAX_PUBLISHING_DATE = LocalDate.of(2019, 12, 31);
	public static final double MIN_PRICE = 100.;
	public static final double MAX_PRICE = 1000.;
	
}
