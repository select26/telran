package util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Map;

public class Persistent {

	public static <K, V> void Save(Map<K, V> obj, String fileName) throws FileNotFoundException, IOException { // Write to file

		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName, false));) {
			for (Map.Entry<K, V> entry : obj.entrySet())
				oos.writeObject(entry);
			
//			for (Map.Entry<K, V> entry : map.entrySet())
//			    action.accept(entry.getKey(), entry.getValue());
		}
	}
	
	public static <K, V> void Restore(Map<K, V> obj, String fileName) throws FileNotFoundException, IOException { // Read from file

		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName));) {
//			for (Map.Entry<K, V> entry : obj.entrySet())
//				oos.writeObject(entry);
			obj.put
			Book book = (Book)ois.readObject();
			
		}
	}

	
}
