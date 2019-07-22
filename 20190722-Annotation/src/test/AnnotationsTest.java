package test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;

import annotations.ClassAnnotation;
import annotations.FieldAnnotation;
import annotations.MethodAnnotation;
import annotations.ParameterAnnotation;
import example.Example;
import example.ExampleChild;

public class AnnotationsTest {
	public static void main(String[] args) throws NoSuchFieldException, SecurityException, NoSuchMethodException {
		Example e = new Example();
		Class eClass = e.getClass();
		
		// class annotation
		System.out.println("ClassAnnotation");
		System.out.println("***************");
		Annotation aClass = eClass.getAnnotation(ClassAnnotation.class);
		System.out.println("id = "+(((ClassAnnotation) aClass).id()));
		String[] names = ((ClassAnnotation) aClass).names();
		System.out.println("arr = "+Arrays.toString(names));			
		System.out.println();
		
		// field annotation
		System.out.println("FieldAnnotation");
		System.out.println("***************");
		Annotation aField = eClass.getDeclaredField("word").getAnnotation(FieldAnnotation.class);
		System.out.println("length ="+((FieldAnnotation) aField).length());
		System.out.println();
		
		// method annotation
		System.out.println("MethodAnnotation");
		System.out.println("***************");
		Annotation aMethod = eClass.getDeclaredMethod("foo", int.class).getAnnotation(MethodAnnotation.class);
		System.out.println("access = "+((MethodAnnotation) aMethod).access());
		System.out.println();
		
		// parameter annotation
		System.out.println("ParameterAnnotation");
		System.out.println("***************");
		Parameter[] parameters = eClass.getDeclaredMethod("foo", int.class).getParameters();
		for (Parameter parameter : parameters) {
			if(parameter.getName().equals("arg0")) {
				Annotation aParameter = parameter.getDeclaredAnnotation(ParameterAnnotation.class);
				System.out.println("negativesAllowed = "+((ParameterAnnotation) aParameter).negativesAllowed());
			}
		}
		System.out.println();
	
	
	Class eChildClass = ExampleChild.class;
	System.out.println("ChildClassAnnotation");
	System.out.println(Arrays.toString(eChildClass.getAnnotations()));
	
	}
}
