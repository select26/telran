package app;

import java.io.IOException;
import java.time.LocalDate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import dto.Address;
import dto.Contact;
import dto.Person;

public class JacsonBasicApp {

	public static void main(String[] args) throws IOException {
		
		Contact contact1 = 	new Contact("Masha", "+972-3223-223");
		Contact contact2 = 	new Contact("Dasha", "+972-1223-335");
		Contact[] contacts = {contact1, contact2};

		Address address = 	new Address("Haifa", "HaHistadrut", 25, 307);
		
		Person person = 	new Person("David","Shats", address, contacts, LocalDate.of(2019, 8, 14));
		
		System.out.println(person);
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());
		String json = mapper.writeValueAsString(person);
		System.out.println(json);
		
		Person deserialised = mapper.readValue(json, person.getClass());
		System.out.println(deserialised);
	}

}
