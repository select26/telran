package app;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

import comparators.EvenOddComparator;

public class UnusialComparatorApp {

	private static final int NUM_NUM = 20;
	static Random gen = new Random();
	
	public static void main(String[] args) {
		Integer[] arr = new Integer[NUM_NUM];
		for (int i = 0; i < arr.length; i++) arr[i] = gen.nextInt(1000);
		System.out.println(Arrays.toString(arr));
		
//		Arrays.sort(arr, new EvenOddComparator());
		directSearchSort(arr, new EvenOddComparator());
		System.out.println(Arrays.toString(arr));
		Arrays.sort(arr, new EvenOddComparator());
		System.out.println(Arrays.toString(arr));
	}

	public static void directSearchSort (Integer[] arr, Comparator<Integer> comparator) {
		for (int end = arr.length - 1;end > 0; end--) {
			int indexMax = 0;for (int i = 0; i <= end; i++) {
				if (comparator.compare(arr[i], arr[indexMax]) > 0) indexMax = i;
			}
			Integer pocket = arr[indexMax];
			arr[indexMax]  = arr[end];
			arr[end]	   = pocket;
		}
	}
}
