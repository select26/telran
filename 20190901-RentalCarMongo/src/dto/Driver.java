package dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Driver {

	private int		tz;
	private String name;
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate birthDate;
}
