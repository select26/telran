package app.docs;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import dto.RentRecord;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection="rc_records")								// Annotation for MongoDB
public class RentRecordDoc {
	@Id
	private String		car;
	private int			driver;
	private LocalDate 	rentDate;
	private LocalDate 	returnDate;
	private int 		rentDays;
	private int			tankPersent;
	private double		totalPrice;
	
	public RentRecordDoc(RentRecord record) {
		this.car	= record.getCar().toString();
		this.driver	= Integer.parseInt(record.getDriver().toString());
		this.rentDate	= record.getRentDate();
		this.returnDate	= record.getReturnDate();
		this.rentDays	= record.getRentDays();
		this.tankPersent = record.getTankPersent();
		this.totalPrice	= record.getTotalPrice();
		
	}
}
