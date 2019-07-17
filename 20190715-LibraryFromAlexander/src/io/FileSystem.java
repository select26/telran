package io;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import dto.Book;
import library.Library;
import utils.Serialiser;

public class FileSystem {

	public static boolean dbToCsv(Library lib, String path, boolean appendFlag) {
		
		Stream<Book> streamBooks = lib.getAllBooksAsStream();
		try (
			PrintWriter pw = new PrintWriter(new FileWriter(path, appendFlag)); 	
			){
			streamBooks
			.map(book -> Serialiser.BookToCsv(book))
			.forEach((c) -> pw.println(c));
			return true;
		}
		catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	public static ArrayList<Book> getFromCsv(String path) {
		return Files.lines(Paths.get(path))
				.map((line) -> {
					return Serialiser.csvToBook(line);
				} catch (Exception e) {
					System.out.println("Error reading from file!");
				}
				.collect(Collectors.toCollection(ArrayList<Book>::new);
	}
}
