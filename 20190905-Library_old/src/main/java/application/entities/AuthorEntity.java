package application.entities;

import java.util.Set;

import javax.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="authors")
public class AuthorEntity {
	@Id
	private String name; 
	private String country;
	@ManyToMany									// many authors, many books
	private Set<BookEntity> books; 

}
