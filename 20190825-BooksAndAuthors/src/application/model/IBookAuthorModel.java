package application.model;

import java.util.Set;

import application.entities.AuthorEntity;
import application.entities.BookEntity;

public interface IBookAuthorModel {
	
	public boolean addAuthor(AuthorEntity author);
	public boolean addBook(BookEntity book);
	public boolean setAuthor (String book_title, String author_name);
	public Set<AuthorEntity> getBookAuthors(String book_title);
	public Set<BookEntity> getAuthorBooks(String author_name);
	public boolean deleteBook(String book_title);
	public boolean deleteAuthor(String author_name);

}
