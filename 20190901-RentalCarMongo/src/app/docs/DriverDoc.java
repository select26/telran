package app.docs;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

import dto.Driver;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection="rc_driver")								// Annotation for MongoDB
public class DriverDoc {
	@Id
	private int		tz;
	private String 	name;
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate birthDate;

	public DriverDoc (Driver driver) {
		this.tz		= driver.getTz();
		this.name	= driver.getName();
		this.birthDate = driver.getBirthDate();
	}
}
