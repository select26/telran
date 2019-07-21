package app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

import dto.Person;

public class ClassReflectionsExerciseApp {

	public static void main(String[] args) throws SecurityException, ClassNotFoundException, InstantiationException, IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException {
		Class<?> myClass = Class.forName("dto.Person"); 
		String[] paramsType = new String[4];
		String[] paramsName = new String[4];
		int i = 0;
		String tmp = "";
		for(Field m : myClass.getDeclaredFields()) {
//			System.out.println(m);
//			System.out.print(m.toString().split(" ")[1] + "\t");				//Type
//			paramsType[i] = m.toString().split(" ")[1];
			paramsType[i] = m.getType().toString();								//Type
//			System.out.print(paramsType[i] + "\t");
//			System.out.println(m.toString().split(" ")[2].split("\\.")[2]);		//Name
//			System.out.println(m.getName() + "!!!");
//			paramsName[i] = m.toString().split(" ")[2].split("\\.")[2];
			paramsName[i] = m.getName();										//Name
			String substr1 = paramsName[i].substring(0, 1).toUpperCase();
			String substr2 = paramsName[i].substring(1);
			paramsName[i] = "set" + substr1 + substr2; 
			System.out.println(paramsName[i]);
			i++;
		}
				
		File file = new File("person.txt");
        FileInputStream fis = new FileInputStream(file);
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));
        String str = "";

        str = br.readLine();
        
        Person newPerson = (Person) myClass.newInstance();
		String[] params = str.split(";");
		i = 0;
		for (String p : params) {
			System.out.println(p.trim());
			if (paramsType[i].toLowerCase().contains("boolean")) {
				Method m = myClass.getDeclaredMethod(paramsName[i], boolean.class);
				m.setAccessible(true);
				m.invoke(newPerson, Boolean.parseBoolean(p.trim()));
			} else if (paramsType[i].toLowerCase().contains("string")) {
				Method m = myClass.getDeclaredMethod(paramsName[i], String.class);
				m.setAccessible(true);
				m.invoke(newPerson, p.trim());
			} else if (paramsType[i].toLowerCase().contains("double")) {
				Method m = myClass.getDeclaredMethod(paramsName[i], double.class);
				m.setAccessible(true);
				Double d = Double.parseDouble(p.trim());
				m.invoke(newPerson, d);
			} else if (paramsType[i].toLowerCase().contains("int")) {
				Method m = myClass.getDeclaredMethod(paramsName[i], int.class);
				m.setAccessible(true);
				int a = (int)Integer.parseInt(p.trim());
				m.invoke(newPerson, a);
			} 
			i++;
		}
        System.out.println(newPerson.getName() + "\t" + newPerson.getAge() + "\t" + newPerson.getHeight() + "\t" + newPerson.isMarriage());
	}


}
