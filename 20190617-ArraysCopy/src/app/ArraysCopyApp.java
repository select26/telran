package app;

import java.util.Arrays;
import java.util.Random;

public class ArraysCopyApp {

	private static final int NUM_NUM = 20;
	static Random gen = new Random();

	public static void main(String[] args) {
		int[] arr = new int[NUM_NUM];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = 10 + gen.nextInt(10);
		}
		System.out.println(Arrays.toString(arr));
//		int[] arr2 = Arrays.copyOf(arr, 25);
//		System.out.println(Arrays.toString(arr2));
//		System.out.println(Arrays.toString(Arrays.copyOfRange(arr, 5, 10)));
		System.out.println("------------------------------------------------");
//		int[] dest = new int[NUM_NUM / 2];
//		System.arraycopy(arr, 3, dest, 5, 3);
//		System.out.println(Arrays.toString(dest));
		
		System.out.println(Arrays.toString(remove(arr, 1)));
	}
	
	public static int[] remove(int[] arr, int index) {
		int[] dst = new int[arr.length-1];
		System.arraycopy(arr, 0, dst, 0, index);
		System.arraycopy(arr, index+1, dst, index, arr.length-index-1);
		return dst;
	}
}
