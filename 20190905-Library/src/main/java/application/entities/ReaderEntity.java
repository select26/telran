package application.entities;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="readers")
public class ReaderEntity {
	@Id
	private long	id;
	private String	fullName;
	private String 	phone;
	private String	email;
	private String	address;
	private LocalDate birthDate;
	
	@OneToMany(mappedBy="reader")
	Set<RecordEntity> records;
}
