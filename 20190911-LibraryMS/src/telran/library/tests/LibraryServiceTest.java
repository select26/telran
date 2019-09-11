package telran.library.tests;

import static org.junit.Assert.*;
import java.time.LocalDate;
import java.util.*;

import org.junit.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import telran.library.ApplTest;
import telran.library.dto.*;
import telran.library.service.interfaces.ILibrary;
@SpringBootApplication(scanBasePackages="telran.library")
class LibraryServiceTest {
	
	ConfigurableApplicationContext configurableApplicationContext;
	
	private static final long 	ISBN1 = 1;
	private static final int 	PUBLISHING_YEAR1 = 2010;
	private static final String PUBLISHER_NAME1 = "publisher1";
	private static final String TITLE1 = "name1";
	private static final int 	AMOUNT1 = 10;
	private static final SubjectBook SUBJECT1 = SubjectBook.LITERATURE;
	private static final String LANGUAGE1 = "en";
	private static final int 	MAX_DAYS1 = 20;

	private static final String PUBLISHER_COUNTRY1 = "country2";
	private static final String AUTHOR_NAME1 = "autnorname1";
	private static final String AUTHOR_COUNTRY1 = "country1";
	private static final long 	READER_ID = 1;
	private static final String READER_NAME1 = "Mosche";
	private static final String READER_PHONE1 = "1234567";
	private static final String READER_MAIL1 = "mosche@gmail.com";
	private static final String READER_ADDRESS1 = "address1";
	private static final LocalDate READER_BIRTHDATE1 = LocalDate.of(1970, 01, 01);

	ILibrary library;
	Set<String> authors1=new HashSet<>(Arrays.asList(AUTHOR_NAME1));
	Book book1 = new Book(ISBN1, 
			PUBLISHING_YEAR1, PUBLISHER_NAME1,
			authors1, TITLE1, AMOUNT1,
			SUBJECT1, LANGUAGE1, MAX_DAYS1);
	
	PublisherAuthor publisher1=new  PublisherAuthor(PUBLISHER_NAME1, PUBLISHER_COUNTRY1);
	PublisherAuthor author1=new  PublisherAuthor(AUTHOR_NAME1, AUTHOR_COUNTRY1);
	Reader reader1 = new Reader(READER_ID, READER_NAME1, READER_PHONE1, 
								READER_MAIL1, READER_ADDRESS1, READER_BIRTHDATE1);
	
	@BeforeClass
	static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	static void tearDownAfterClass() throws Exception {
	}

	@Before
	void setUp() throws Exception {
		// получим экземпляр класса ILibrary (при помощи @SpringBootApplication(scanBasePackages="telran.library") строим все дерево )
		configurableApplicationContext = SpringApplication.run(ApplTest.class);
		library = configurableApplicationContext.getBean(ILibrary.class);
		library.addAuthor(author1);
		library.addPublisher(publisher1);
		library.addBookItem(book1);
		library.addReader(reader1);
	}

	@After
	void tearDown() throws Exception {
		configurableApplicationContext.close();
	}

	@Test
	void testAddBookItem() {
		assertEquals(LibReturnCode.BOOK_ALREADY_EXISTS, library.addBookItem(book1));

		Book book2 = new Book(ISBN1+1, PUBLISHING_YEAR1, "publisher2", authors1, TITLE1, 5, SUBJECT1, LANGUAGE1, MAX_DAYS1);
		assertEquals(LibReturnCode.OK, library.addBookItem(book2));
	}

	@Test
	void testAddBookExemplar() {
		fail("Not yet implemented");
	}

	@Test
	void testGetBookItem() {
		fail("Not yet implemented");
	}

	@Test
	void testMoveToArchive() {
		fail("Not yet implemented");
	}

	@Test
	void testRemoveExemplar() {
		fail("Not yet implemented");
	}

	@Test
	void testLostExemplar() {
		fail("Not yet implemented");
	}

	@Test
	void testAddReader() {
		fail("Not yet implemented");
	}

	@Test
	void testGetReader() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateReaderEmail() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateReaderPhone() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateReaderAddress() {
		fail("Not yet implemented");
	}

	@Test
	void testAddPublisher() {
		fail("Not yet implemented");
	}

	@Test
	void testGetPublisherByName() {
		fail("Not yet implemented");
	}

	@Test
	void testGetPublishersByCountry() {
		fail("Not yet implemented");
	}

	@Test
	void testGetPublisherByBook() {
		fail("Not yet implemented");
	}

	@Test
	void testAddAuthor() {
		fail("Not yet implemented");
	}

	@Test
	void testGetAuthorsByName() {
		fail("Not yet implemented");
	}

	@Test
	void testGetAuthorsByCountry() {
		fail("Not yet implemented");
	}

	@Test
	void testGetAuthorsByBook() {
		fail("Not yet implemented");
	}

	@Test
	void testPickupBook() {
		fail("Not yet implemented");
	}

	@Test
	void testReturnBook() {
		fail("Not yet implemented");
	}

	@Test
	void testFindRecordsByBook() {
		fail("Not yet implemented");
	}

	@Test
	void testFindRecordsByReader() {
		fail("Not yet implemented");
	}

	@Test
	void testFindRecordsByReturnDate() {
		fail("Not yet implemented");
	}

	@Test
	void testFindOpenRecords() {
		fail("Not yet implemented");
	}

	@Test
	void testGetBooksNotPickedUp() {
		fail("Not yet implemented");
	}

	@Test
	void testIsExistBookInArchive() {
		fail("Not yet implemented");
	}

	@Test
	void testGetDelayedBooksByReader() {
		fail("Not yet implemented");
	}

	@Test
	void testGetReadersDelayingBooks() {
		fail("Not yet implemented");
	}

	@Test
	void testObject() {
		fail("Not yet implemented");
	}

	@Test
	void testGetClass() {
		fail("Not yet implemented");
	}

	@Test
	void testHashCode() {
		fail("Not yet implemented");
	}

	@Test
	void testEquals() {
		fail("Not yet implemented");
	}

	@Test
	void testClone() {
		fail("Not yet implemented");
	}

	@Test
	void testToString() {
		fail("Not yet implemented");
	}

	@Test
	void testNotify() {
		fail("Not yet implemented");
	}

	@Test
	void testNotifyAll() {
		fail("Not yet implemented");
	}

	@Test
	void testWaitLong() {
		fail("Not yet implemented");
	}

	@Test
	void testWaitLongInt() {
		fail("Not yet implemented");
	}

	@Test
	void testWait() {
		fail("Not yet implemented");
	}

	@Test
	void testFinalize() {
		fail("Not yet implemented");
	}

}
