package app;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import dto.Employee;

import dto.Person;

public class ClassReflectionApp {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		Person person = new Person();
		
//		Class<?> myClass = person.getClass();
//		for (java.lang.reflect.Method m : myClass.getMethods()) System.out.println(m);
//		
//		Class<?> myClass2 = Person.class;
//		Class<?> myClass3 = Class.forName("dto.Person");
//		System.out.println(myClass3);
//
//		Person personNew = (Person) myClass.newInstance();
//		System.out.println(personNew);
//		
//		System.out.println(myClass.getSuperclass().getName());
		
//		Class<?> primitiveBoolean = boolean.class;
//		System.out.println(primitiveBoolean.getTypeName());
//		Class<?> wrippingBoolean = Boolean.class;
//		System.out.println(wrippingBoolean.getTypeName());
		
		Class<?> classObject = Object.class;
		Class<?> classPerson = Person.class;
		Class<?> classEmployee = Employee.class;
		
		Employee employee = new Employee();
		System.out.println("employee " + employee);
		
		Object object = classObject.cast(employee);
		System.out.println("object " + object);
		
		Person person1 = (Person) classPerson.cast(object);
		System.out.println("person " + person1);

		for(Field m : classEmployee.getDeclaredFields()) System.out.println(m); 
		
		Method method = classPerson.getDeclaredMethod("setName", String.class, String.class);
		method.setAccessible(true);
		method.invoke(person, "pupkin", "zarubkin");
		classPerson.getDeclaredMethod("setHobby", String.class)
							.invoke(person, "jumping");
		classPerson.getDeclaredMethod("foo", int.class)
							.invoke(null, 333);
		System.out.println(person);
		Constructor constructor = (Constructor) classPerson
							.getDeclaredConstructor(String.class, String.class);
		constructor.setAccessible(true);
		System.out.println(constructor.newInstance("Vasusualy","Lockhankin"));
	}

}
