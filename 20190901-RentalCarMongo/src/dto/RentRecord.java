package dto;

import java.time.LocalDate;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RentRecord {

	private Car		car;
	private Driver	driver;
	private LocalDate rentDate;
	private LocalDate returnDate;
	private int 	rentDays;
	private int		tankPersent;
	private double	totalPrice;
	
}
