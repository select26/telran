package persons.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import persons.Person;

public class PersonTests {
	private static final int ID1 = 123;
	private static final String NAME1 = "Moshe Dayan";
	private static final String CITY1 = "Haifa";
	private static final String NAME2 = "Vasya Colupaev";
	private static final String CITY2 = "Cala4insk";
	Person person1;
	@Before
	public void setUp() throws Exception {
		person1 = new Person(ID1, NAME1, CITY1);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testPerson() {
//		fail("Not yet implemented");
		Person person2 = new Person(ID1, NAME1, CITY1);
//		assertEquals(person1, person2);
		assertNotEquals(person1, 5);
	}

	@Test
	public void testGetName() {
		assertEquals(NAME1, person1.getName());
	}

	@Test
	public void testSetName() {
		person1.setName(NAME2);
		assertEquals(NAME2, person1.getName());
	}

	@Test
	public void testGetCity() {
		assertEquals(CITY1, person1.getCity());
	}

	@Test
	public void testSetCity() {
		person1.setCity(CITY2);
		assertEquals(CITY2, person1.getCity());
	}

	@Test
	public void testGetId() {
		assertEquals(ID1, person1.getId());
	}

}
