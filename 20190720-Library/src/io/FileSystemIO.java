package io;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import dto.Book;
import exceptions.WrongBookDataException;
import exceptions.WrongLinesException;
import library.Library;
import utils.Serializers;

public class FileSystemIO {
	
	public static boolean dbToCSV(Library lib, String path, boolean appendFlag) throws IOException {
		Stream<Book> streamBooks = lib.getAllBooksAsStream();
		try (
			PrintWriter pw = new PrintWriter(new FileWriter(path, appendFlag))
			){
			 streamBooks
			.map(Serializers::bookToCSV)
			.forEach(pw::println);
			 return true;
		}
	}
	
	public static ArrayList<Book> getFromCSV(String path) throws IOException,  WrongLinesException{
		
		ArrayList<String> lines =
			Files.lines(Paths.get(path))
			 .collect(Collectors.toCollection(ArrayList<String>:: new));
		
		ArrayList<Book> result = new ArrayList<>();
		StringBuilder wrongLines = new StringBuilder();
		int wrongLinesCounter = 0;
		for (String csv : lines) {
			try {
				result.add(Serializers.csvToBook(csv));
			} catch (WrongBookDataException e) {
				wrongLines.append(e.getMessage()+"\n");
				wrongLinesCounter++;
			}
		}
//		String wrongLinesString = wrongLines.toString();
		if (wrongLinesCounter != 0) 
			throw new WrongLinesException(
					wrongLinesCounter,
					result,
					"\n"+wrongLines.toString());
		else return result;
	}
}
