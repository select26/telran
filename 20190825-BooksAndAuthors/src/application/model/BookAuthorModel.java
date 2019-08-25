package application.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import application.entities.AuthorEntity;
import application.entities.BookEntity;
import application.repo.AuthorJpaRepository;
import application.repo.BookJpaRepository;

@Service
public class BookAuthorModel implements IBookAuthorModel {
	
	@Autowired
	AuthorJpaRepository authorRepo;
	
	@Autowired
	BookJpaRepository bookRepo;

	@Override
	public boolean addAuthor(AuthorEntity author) {
		if(authorRepo.findByName(author.getName()).size() > 0) return false;
		authorRepo.save(author);
		return true;
	}

	@Override
	public boolean addBook(BookEntity book) {
		if(bookRepo.findByTitle(book.getTitle()).size() > 0) return false;
		bookRepo.save(book);
		return true;
	}

	@Override
	public boolean setAuthor(String book_title, String author_name) {
		
		List<BookEntity> bookList = bookRepo.findByTitle(book_title);
		if (bookList.size() == 0) return false;
		
		AuthorEntity author = new AuthorEntity(author_name);
		addAuthor(author);
		
		BookEntity book = bookList.get(0);
		book.getAuthors().add(author);
		bookRepo.save(book);
		
		return true;
	}

	@Override
	public Set<AuthorEntity> getBookAuthors(String book_title) {
		List<BookEntity> bookList = bookRepo.findByTitle(book_title);
		return bookList.size() == 0 ? new HashSet<AuthorEntity>() : bookList.get(0).getAuthors();
	}

	@Override
	public Set<BookEntity> getAuthorBooks(String author_name) {
		List<AuthorEntity> authorList = authorRepo.findByName(author_name);
		return authorList.size() == 0 ? new HashSet<BookEntity>() : authorList.get(0).getBooks();
	}

	@Override
	public boolean deleteBook(String book_title) {
		List<BookEntity> bookList = bookRepo.findByTitle(book_title);
		if (bookList.size() == 0) return false;
		bookRepo.delete(bookList.get(0));
		return true;
	}

	@Override
	public boolean deleteAuthor(String author_name) {
		List<AuthorEntity> authorList = authorRepo.findByName(author_name);
		if (authorList.size() == 0) return false;
		authorRepo.delete(authorList.get(0));
		return true;
	}

}
