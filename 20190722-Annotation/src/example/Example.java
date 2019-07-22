package example;

import annotations.ClassAnnotation;
import annotations.FieldAnnotation;
import annotations.MethodAnnotation;
import annotations.ParameterAnnotation;

@ClassAnnotation(id = 12345, names = {"Sasha","Sominsky"})
public class Example {
	@FieldAnnotation(length = 5)
	private String word= "Some word";

	
	@MethodAnnotation(access = true)
	void foo(@ParameterAnnotation(negativesAllowed=false) int val) {}
}
