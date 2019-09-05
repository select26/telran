package application.entities;

import javax.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="publisher")
public class PublisherEntity {
	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String name; 
	private String country;

}
