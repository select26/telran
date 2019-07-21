package app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

import dto.Person;

public class ClassReflectionsExerciseApp2 {

	public static void main(String[] args)
			throws SecurityException, ClassNotFoundException, InstantiationException, IllegalAccessException,
			IOException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException {
		Class<?> myClass = Class.forName("dto.Person");
		Class<?>[] paramsType = new Class<?>[4];
		String[] paramsName = new String[4];
		int i = 0;
		String tmp = "";
		for (Field m : myClass.getDeclaredFields()) {
			paramsType[i] = m.getType(); 									// Type
			paramsName[i] = m.getName(); 									// Name
			String substr1 = paramsName[i].substring(0, 1).toUpperCase();
			String substr2 = paramsName[i].substring(1);
			paramsName[i] = "set" + substr1 + substr2;
			System.out.println(paramsName[i]);
			i++;
		}

//		File file = new File("person.txt");
//		FileInputStream fis = new FileInputStream(file);
//		BufferedReader br = new BufferedReader(new InputStreamReader(fis));
		BufferedReader br = new BufferedReader(new FileReader("person.txt")); 
		String str = "";

		str = br.readLine();
		while (str != null) {
		System.out.println("Line: " + str);

//		Person newPerson = (Person) myClass.newInstance();
		Object newPerson = myClass.newInstance();
		String[] params = str.split(";");
		i = 0;
		for (String p : params) {
//			System.out.println(p.trim());
			Method m = myClass.getDeclaredMethod(paramsName[i], paramsType[i]);
			m.setAccessible(true);
			if (paramsType[i].toString().contains("boolean")) {
				m.invoke(newPerson, Boolean.parseBoolean(p.trim()));
			} else if (paramsType[i].toString().contains("String")) {
				m.invoke(newPerson, p.trim());
			} else if (paramsType[i].toString().contains("double")) {
				m.invoke(newPerson, Double.parseDouble(p.trim()));
			} else if (paramsType[i].toString().contains("int")) {
				m.invoke(newPerson, (int) Integer.parseInt(p.trim()));
			} else if (paramsType[i].toString().contains("byte")) {
				m.invoke(newPerson, Byte.parseByte(p.trim()));
			} else if (paramsType[i].toString().contains("short")) {
				m.invoke(newPerson, Short.parseShort(p.trim()));
			}
			i++;
		}
//		System.out.println(newPerson.getName() + "\t" + newPerson.getAge() + "\t" + newPerson.getHeight() + "\t"
//				+ newPerson.isMarriage());
		str = br.readLine();
		}
		
	}

}
