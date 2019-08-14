package app;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import dto.Person;

public class JacsonGenericsApp {

	public static void main(String[] args) throws IOException {
		ArrayList<Person> persons =new ArrayList<Person>();
		persons.add(new Person("Sasha", LocalDate.of(1988, 5, 6)));
		persons.add(new Person("Masha", LocalDate.of(1990, 2, 20)));
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());
		ObjectWriter ow = 
				mapper.writerFor(new TypeReference<ArrayList<Person>>() {/*пустой анон. класс для указания типа родителя*/});  
		/* Получим generic-класс, которым параметризован класс
		 * console: com.fasterxml.jackson.core.type.TypeReference<java.util.ArrayList<dto.Person>>
		 */
		System.out.println((new TypeReference<ArrayList<Person>>() {}).getClass().getGenericSuperclass());
		String json = mapper.writeValueAsString(persons);
		System.out.println(json);
		ArrayList<Person> deserialized = 
				mapper.readValue(json, persons.getClass());
		System.out.println(deserialized);

	}

}
