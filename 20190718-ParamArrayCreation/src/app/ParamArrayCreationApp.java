package app;

import java.lang.reflect.Array;

public class ParamArrayCreationApp {

	public static void main(String[] args) {

	}

	public static <T> T[] clone(T[] array){
//		Class<?> classObject = array.getClass();
		T[] arr = (T[]) Array.newInstance(array.getClass().getComponentType(), array.length);
		for (int i = 0; i < arr.length; i++)	arr[i] = array[i];
		return arr;
	}
}
