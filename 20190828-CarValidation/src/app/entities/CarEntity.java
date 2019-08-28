package app.entities;

import javax.persistence.*;
import lombok.*;

@NoArgsConstructor
@Getter @Setter

@Entity
@Table(name="CarValidation")
public class CarEntity {

	@Id
	@Column(length=100)
	private String 	model;
	
	private int 	year;
	private double	engine;
	private boolean	ac;
}
