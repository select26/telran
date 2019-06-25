package app;

import java.sql.Array;
import java.util.Arrays;
import java.util.Random;

import randomlib.RandomLib;

public class RandomApp {

	private static final int NUM_NUM = 100;
	private static final int BOUND = 10;
	static Random gen = new Random();  
	public static void main(String[] args) {

		int[] arr = new int[BOUND];
		for (int i = 0; i < NUM_NUM; i++) {
//			System.out.println(gen.nextInt());
//			System.out.println(gen.nextInt(BOUND));
//			arr[gen.nextInt(BOUND)]++;
			System.out.println(RandomLib.nextDoubleRange(10., 50.));
//			System.out.println(gen.nextDouble());
		}
		
//		System.out.println(Arrays.toString(arr));
		
	}

}
