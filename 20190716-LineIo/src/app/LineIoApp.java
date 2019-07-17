package app;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

public class LineIoApp {

	public static void main(String[] args) throws IOException {
		
		try (
			PrintWriter pw = new PrintWriter(new FileWriter("text1.txt",false));
			){
				pw.println("Jili u babusi");
				pw.println("Dva veselih gusya");
				pw.println("Odin sery, drugoy bely");
				pw.println("Dva veselih gusya");
			};
			
			
		try (
			PrintWriter pw = new PrintWriter(new FileWriter("text1.txt",true));
			){
//				pw.append("cddd");
				pw.println("Ups!...");
			}
		
		try {
			Stream<String> rows = Files.lines(Paths.get("text12.txt"));
			rows.forEach((s) -> System.out.println(s));
		} catch (Exception e) {
			System.out.println("File not found!");
		}
	}

}
