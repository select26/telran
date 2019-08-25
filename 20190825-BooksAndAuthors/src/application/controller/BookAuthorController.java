package application.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import application.entities.AuthorEntity;
import application.entities.BookEntity;
import application.model.IBookAuthorModel;

@RestController
public class BookAuthorController {
	
	@Autowired
	IBookAuthorModel model;
	
	@PostMapping(value="/addBook")
	public boolean addBook(@RequestParam(name="title") String title) {
		return model.addBook(new BookEntity(title));
	}
	
	@PostMapping(value="/addAuthor")
	public boolean addAuthor(@RequestParam(name="name") String name) {
		return model.addAuthor(new AuthorEntity(name));
	}
	
	@PostMapping(value="/setAuthor")
	public boolean setAuthor(@RequestParam(name="book") String book_title,
			                 @RequestParam(name="author") String author_name) {
		return model.setAuthor(book_title, author_name);
	}
	
	@GetMapping(value="/getBooksByAuthor")
	public Set<BookEntity> getBooksByAuthor( @RequestParam(name="author") String author_name){
		return model.getAuthorBooks(author_name);
	}
	
	@GetMapping(value="/getAuthorsByBook")
	public Set<AuthorEntity> getAuthorsByBook( @RequestParam(name="book") String book_title){
		return model.getBookAuthors(book_title);
	}
	
	@PostMapping(value="/deleteBook")
	public boolean deleteBook( @RequestParam(name="book") String book_title) {
		return model.deleteBook(book_title);
	}
	
	@PostMapping(value="/deleteAuthor")
	public boolean deleteAuthor( @RequestParam(name="author") String author_name) {
		return model.deleteAuthor(author_name);
	}
}
