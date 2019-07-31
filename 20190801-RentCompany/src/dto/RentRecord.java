package dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class RentRecord implements Serializable{

	private String 		regNumber;
	private long 		licenseId;
	private LocalDate 	rentDate;
	private LocalDate 	returnDate;
	private int 		rentDays;
	private int 		damages;
	private int 		tankPersent;
	private double 		cost;

	
}
