package telran.library.domain.entities;
import lombok.*;
import telran.library.dto.Book;
import telran.library.dto.SubjectBook;

import javax.persistence.*;

import java.time.LocalDate;
import java.util.Set;

@NoArgsConstructor
@EqualsAndHashCode(of = "isbn")
@ToString(exclude = {"authors", "publisher", "records"})
@Getter

@Entity
@Table(name = "books")
public class BookEntity {
    @Id
    long isbn;
    int publishingYear;
    String title;
    @Setter int amountInLibrary; //setter
    @Setter int shelf;//setter
    @Enumerated(EnumType.STRING)
    SubjectBook subject;
    String language;
    @Setter int maxDaysInUse; //setter
    @Setter LocalDate archivingDate; //setter
    @ManyToMany
    Set<AuthorEntity> authors;

    @ManyToOne
    PublisherEntity publisher; 

    @OneToMany(mappedBy = "book")
    Set<RecordEntity> records;

	public BookEntity(long isbn, int publishingYear, String title, int amountInLibrary, int shelf, SubjectBook subject,
			String language, int maxDaysInUse, Set<AuthorEntity> authors, PublisherEntity publisher) {
		super();
		this.isbn = isbn;
		this.publishingYear = publishingYear;
		this.title = title;
		this.amountInLibrary = amountInLibrary;
		this.shelf = shelf;
		this.subject = subject;
		this.language = language;
		this.maxDaysInUse = maxDaysInUse;
		this.authors = authors;
		this.publisher = publisher;
	}

	public BookEntity(Book book, Set<AuthorEntity> authors, PublisherEntity publisherEntity) {
		super();
		this.isbn=book.getIsbn();
		this.publishingYear = book.getPublishingYear();
		this.title = book.getTitle();
		this.amountInLibrary = book.getAmountInLibrary();
		this.shelf = 0;
		this.subject = book.getSubject();
		this.language = book.getLanguage();
		this.maxDaysInUse = book.getMaxDaysInUse();
		this.authors = authors;
		this.publisher = publisherEntity;
	}
    
}
