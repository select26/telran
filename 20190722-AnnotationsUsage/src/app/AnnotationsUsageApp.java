package app;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import annotations.*;
import dto.Person;
import parsers.GetRequestParser;
import parsers.IParser;
import parsers.Parsers;

public class AnnotationsUsageApp {

//	public static final Map<Class<?>, Method> PARSERS = primitivesMap();  
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		String data = "name=Sasha&id=123456&salary=167.87";
		createAndOutputClass(data, Person.class, new GetRequestParser());
	}

	public static void createAndOutputClass(String data, Class clazz, IParser parser) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Map<String, Class>  types 	= new HashMap<>(); 
		Map<String, Method> getters = new HashMap<>();
		Map<String, Method> setters = new HashMap<>();
		Map<String, String> values 	= parser.parse(data);
//		Map<String, String> values 	= new HashMap<>();
		
		for (Field field : clazz.getDeclaredFields()) 
			types.put(field.getName(), field.getType());
		
		Annotation annotation;
		for (Method method : clazz.getDeclaredMethods()) {
			annotation = method.getAnnotation(Getter.class);
			if (annotation != null)
				getters.put(((Getter)annotation).field(), method);
			
			annotation = method.getAnnotation(Setter.class);
			if (annotation != null)
				setters.put(((Setter)annotation).field(), method);
		}
//		System.out.println("types: " + types);
//		System.out.println("getters: " + getters);
//		System.out.println("setters: " + setters);
		
//		String[] pairs = data.split("&");
//		for (String pair: pairs) {
//			String [] property = pair.split("=");
//			values.put(property[0], property[1]);
//		}
//		System.out.println(values);
		
		Object object = clazz.newInstance();
		for (String field : values.keySet()) {
//			System.out.println( PARSERS.get(types.get(field)).invoke(null, values.get(field)) );
			setters.get(field).invoke(object,
					Parsers.PARSERS.get(types.get(field)).invoke(null, values.get(field)) );
		}
//		System.out.println(object);
		
		for (String field : values.keySet()) {
			System.out.print( field + ": " +getters.get(field).invoke(object) + "\t");
		}
		
	}
}
