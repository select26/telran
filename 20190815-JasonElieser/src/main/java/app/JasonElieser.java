package app;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import dto.JsonEntity;
import dto.Person;

public class JasonElieser {
	public static void main(String[] args) throws IOException {

		ArrayList<Person> persons = new ArrayList<Person>();
		persons.add(new Person("Sasha", LocalDate.of(1988, 5, 6)));
		persons.add(new Person("Masha", LocalDate.of(1990, 2, 20)));

		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());
		//Получим jason
		String json = mapper.writeValueAsString(persons);
		System.out.println(json);
		//Получим тип класса: параметризованный по типу ArrayList
		String collection = mapper.getTypeFactory().constructCollectionType(List.class, Person.class).toCanonical();
		JsonEntity jsonEntity = new JsonEntity(json, collection);
		System.out.println(jsonEntity);
		//Обернем исходный json типом класса
		String jsonString = mapper.writeValueAsString(jsonEntity);
		System.out.println(jsonString);
		
		// Извлечем исходный класс из json
		JsonEntity jsonEntityNew = mapper.readValue(jsonString, JsonEntity.class);
		// Восстановим массив данных
		ArrayList<Person> personsEntity = mapper.readValue(jsonEntityNew.getJson(),
				mapper.getTypeFactory().constructFromCanonical(jsonEntityNew.getCollectionName()));
		
		System.out.println("jsonEntityNew: " + jsonEntityNew);
		System.out.println("personsEntity: " + personsEntity);	
		
	}

}
