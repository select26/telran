package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;
/* 
 * Этот класс сохраняет и восстанавливает из файла тип Map
 */
public class Persistent {

	public static <K, V> void saveMapToFile(Map<K, V> obj, String fileName) 				// Write to file 
			throws FileNotFoundException, IOException { 
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName, false));) {
			oos.writeObject(obj);
		}
	}
	
	@SuppressWarnings("unchecked")
	public static <K, V> Map<K, V> restoreMapFromFile(Map<K, V> obj, String fileName)		// Read from file
			throws FileNotFoundException, IOException, ClassNotFoundException { 
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));) {
			Map<K, V> map = (Map<K, V>) ois.readObject();
			return map;
		}
	}

}
