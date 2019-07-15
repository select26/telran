package app;

import dto.Book;
import enumerations.AuthorName;
import random.RandomBook;
import randomlib.RandomLib;

public class TestApp {

	public static void main(String[] args) {

//		Book book = RandomBook.randomBook();
//		System.out.println(book);
		
		for (int i = 0; i < 15; i++) {
			System.out.println(RandomBook.randomBook());
		}
		
	}



}
