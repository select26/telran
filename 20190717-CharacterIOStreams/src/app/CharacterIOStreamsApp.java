package app;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CharacterIOStreamsApp {
	
	public static void main(String[] args) throws IOException {

		String key = "supersercretkey(°Ї°)";
		String msg = "Price upper one billion dollars will be Ok!";

//		chiper(msg, key, "msg.txt");
		System.out.println(dechiper("msg.txt", key) );
	}

	public static void chiper(String original, String key, String path) throws IOException {
		char[] origChars = original.toCharArray();
		char[] keyChars = key.toCharArray();
		
		char[] result = new char[origChars.length];
		for (int i = 0; i < origChars.length; i++) {
			result[i] = (char) (origChars[i] ^ keyChars[i % keyChars.length]);
		}
//		System.out.println(Arrays.toString(result));
		try (
			FileWriter fw = new FileWriter(path);	
			){
			fw.write(result);
		}
	}
	
	public static String dechiper(String path, String key) throws FileNotFoundException, IOException {
		
		File file = new File(path);
		int len = 0;
		if (file.exists()) len = (int) file.length();
		else throw new IOException("File " + path + " not found!");

		char[] result = new char[len];  
		
		try(
			FileReader fr = new FileReader(path);
			){
			fr.read(result);
		}
		
		char[] keyChars = key.toCharArray();
		StringBuilder res = new StringBuilder();
		for (int i = 0; i < result.length; i++) {
			res = res.append((char)(result[i] ^ keyChars[i % keyChars.length]));
		}

		return res.toString();
	}
	
	// Разобраться!!!!
	//
	//
	public static void cypher(String origFilePath, String key) throws IOException {

        byte[] origBytes = Files.readAllBytes(Paths.get(origFilePath));

        byte[] keyChars = key.getBytes();

        byte[] result = new byte[origBytes.length];

        for (int i = 0; i < origBytes.length; i++) {
            result[i] = (byte) (origBytes[i] ^ keyChars[i % keyChars.length]);
        }

        try (FileOutputStream stream = new FileOutputStream(origFilePath)) {
            stream.write(result);
        }
    }
}
