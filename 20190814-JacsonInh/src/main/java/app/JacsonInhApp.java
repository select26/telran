package app;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import dto.Child;
import dto.Employee;
import dto.Person;
import lombok.ToString;
@ToString(callSuper = true)

public class JacsonInhApp {

	public static void main(String[] args) throws IOException {
		
		Person[] persons = {
				new Child("Dodik",LocalDate.of(2006, 5, 18),"Creek"),
				new Employee("Vasya",LocalDate.of(1986, 8, 1), 7500.)
		};
		System.out.println(Arrays.toString(persons));
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());
		String json = mapper.writeValueAsString(persons);
		System.out.println(json);
		Person[] deserialized = 
				mapper.readValue(json, Person[].class);
		System.out.println(Arrays.toString(deserialized));
	}

}
