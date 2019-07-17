package app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KeyBoardInputApp {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		
//		String line = "";
//		for (;;) {
//			line = br.readLine();
//			if (line.equalsIgnoreCase("exit")) break;
//			System.out.println("Input receive: " + line);
//		}
		int choice = 10;
		do {
			System.out.println("Select item:");
			for (int i = 0; i < Language.values().length; i++) {
				System.out.print(i + ": ");
				System.out.println(Language.values()[i]);
			}
			try {
				choice = Integer.parseInt(br.readLine());
			} catch (NumberFormatException e) {	}
			
		} while (choice >= Language.values().length);
		System.out.println(choice);
		System.out.println("Your choice: " + Language.values()[choice]);
	}

}
