package app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class NIOTestApp {

	public static void main(String[] args) throws IOException {
		File file = new File("person.txt");
		FileInputStream fis = new FileInputStream(file);
		BufferedReader br = new BufferedReader(new InputStreamReader(fis));
		String str = "";

		str = br.readLine();
		while (str != null) {
			System.out.println("Line: " + str);
			str = br.readLine();
		}
	}
}
