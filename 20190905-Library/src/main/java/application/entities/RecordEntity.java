package application.entities;

import java.time.LocalDate;
import javax.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="recordId")
@ToString(exclude={"book","reader"})
@Data
@Entity
@Table(name="records")
public class RecordEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int 		recordId;
	LocalDate	datePickingUp;
	LocalDate	dateOfReturning;
	int			daysDelayed;
	boolean		bookIsLost;
	@ManyToOne
	BookEntity	book;
	@ManyToOne
	ReaderEntity reader;
	
}
