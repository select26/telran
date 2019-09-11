package application.entities;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import application.enums.Subject;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="isbn")
@Data
@Entity
@Table(name="book")
public class BookEntity {
	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long	isbn;
	private int		year;
	private String	title;
	private int		amountInLibrary;
	private int		shelf;
	private Subject	subject;
	private String	language;
	private int 	maxDaysInUse;
	private LocalDate archivingDate;
	@ManyToOne									// many books, one publisher
	private PublisherEntity 	publisher;
	@ManyToMany									// many books, many authors
	private	Set<AuthorEntity> 	authors;
	@OneToMany(mappedBy="book")
	Set<RecordEntity>			records;
}
