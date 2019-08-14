package dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
//@ToString(callSuper = true)

//@JsonTypeInfo(use = Id.CLASS)
public class Person {
	private String 		name;
	private LocalDate	birthday;
}
