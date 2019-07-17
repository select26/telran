package app;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class FileTestApp {

	public static void main(String[] args) throws IOException {
//		File file = new File("test1.txt");
		File file = new File("../20190715-LibraryFromAlexander/src");
//		file.createNewFile();
		for (String f: file.list()) System.out.println(f);
		
		file = new File("/c:/test2/test3/test5");
		file.mkdirs();
	}

}
