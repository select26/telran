package test;

import java.lang.reflect.Field;

import dto.Book;
import enumerations.Title;
import randomlib.RandomLib;
import utils.Randoms;

public class ClassReflectionTestApp {

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
//		for (Field f : Book.class.getDeclaredFields()) System.out.println(f);
		Book book = Randoms.getRandomBook();
		System.out.println(book);
		Field title = book.getClass().getDeclaredField("title");
		title.setAccessible(true);
		title.set(book, Title.SunAndMoon);
		System.out.println(book);
	}

}
