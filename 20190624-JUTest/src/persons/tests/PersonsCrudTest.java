package persons.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import persons.Person;
import persons.implementations.PersonsArrayList;
import persons.implementations.PersonsList;
//import persons.implementations.PersonsList;
import persons.interfaces.IPersons;

public class PersonsCrudTest {

	private static final String CITY1 = "Omsk";
	private static final String CITY2 = "Novosibirsk";
	private static final String CITY3 = "Kirov";
	private static final String CYTIN = "Kala4insk";
	private static final String NAME1 = "Andrey";
	private static final String NAME2 = "Aleksey";
	private static final String NAME3 = "Artyom";
	private static final String NAMEN = "Arseny";
	private static final int ID1 = 345232938;
	private static final int ID2 = 345232946;
	private static final int ID3 = 345232952;
	private static final int IDN = 345232961;
	Person person1;
	Person person2;
	Person person3;
	IPersons persons;
	
	@Before
	public void setUp() throws Exception {
		System.out.println("setUp running...");
		person1 = new Person(ID1, NAME1, CITY1);
		person2 = new Person(ID2, NAME2, CITY2);
		person3 = new Person(ID3, NAME3, CITY2);
		persons = new PersonsArrayList();
		persons.addPerson(person1);
		persons.addPerson(person2);
		persons.addPerson(person3);
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("tearDown running...");
	}
	
	@Test
	public void testAddPerson() {
//		fail("Not yet implemented");
		assertFalse(persons.addPerson(person1));			// try to add already existing
		Person newPerson = new Person(IDN, NAMEN, CYTIN);
		assertTrue(persons.addPerson(newPerson));
		
		assertEquals(newPerson, persons.getPerson(IDN));	// add new
	}

	@Test
	public void testRemovePerson() {
//		fail("Not yet implemented");
		assertFalse(persons.removePerson(IDN));				// remove non-existing element
		assertTrue(persons.removePerson(ID1));				// remove existing element
		assertNull(persons.getPerson(ID1));					// check, that remove
	}

	@Test
	public void testGetPerson() {
		assertNull(persons.getPerson(IDN));					// try get non-existing element
		assertEquals(person1, persons.getPerson(ID1)); 		// check existing element
	}

	@Test
	public void testGetAllPersons() {
//		fail("Not yet implemented");
		ArrayList<Person> listPersons = getListPersons(); 
		for (Person person: persons.getAllPersons()) {
			assertTrue(listPersons.contains(person));
			listPersons.remove(person);
		}
		assertTrue(listPersons.isEmpty());
	}

	private ArrayList<Person> getListPersons() {
		ArrayList<Person> res = new ArrayList<>();
		res.add(person1);
		res.add(person2);
		res.add(person3);
		return res;
	}

	@Test
	public void testGetPersonsByCity() {
		Person[] arExpected = {
				person2, person3
		};
		Person[] actual = persons.getPersonsByCity(CITY2);
		Arrays.sort(actual);
		assertArrayEquals(arExpected, actual);
	}

	@Test
	public void testUpdatePersonCity() {
		assertTrue(persons.updatePersonCity(ID3, CITY1));
		assertEquals(CITY1,	persons.getPerson(ID3).getCity());
	}

	@Test
	public void testSize() {
		assertEquals(3, persons.size());;
	}

}
