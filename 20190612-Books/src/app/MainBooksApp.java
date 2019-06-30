package app;

import lib.BooksLib;

public class MainBooksApp {

	private static final int MAX_BOOK = 10;

	public static void main(String[] args) {
		BooksLib[] book	= new BooksLib[MAX_BOOK];
		for (int i = 0; i < book.length; i++) {
			book[i] = BooksLib.randomBook();
		}

		for (int i = 0; i < book.length; i++) {
			System.out.println(book[i]);
		}
	}

}
