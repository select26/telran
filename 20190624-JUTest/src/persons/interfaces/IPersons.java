package persons.interfaces;

import persons.Person;

public interface IPersons {
	boolean addPerson (Person person);
	boolean removePerson(long id);
	Person getPerson(long id);
	Iterable<Person> getAllPersons();
	Person[] getPersonsByCity(String city);
	boolean updatePersonCity(long id, String city);
	int size();
}
