package app;

import java.util.Iterator;
import java.util.Random;

import model.MyArrayList;
import model.MyArrayListOutOfBounds;

public class MyArrayListApp {

	private static final int NUM_NUM = 20;
	static Random gen = new Random(12345);
	
	public static void main(String[] args) {
		MyArrayList<Integer> mali = new MyArrayList<>(); 
		for (int i = 0; i < NUM_NUM; i++) mali.add(gen.nextInt(10));
//		System.out.println(mali);
//		System.out.println(mali.get(5));
//		System.out.println(mali.set(666, 8));
//		System.out.println(mali);
//		mali.add(888, 10);
		System.out.println(mali);
		System.out.println("---------------------------------------");
//		System.out.println(mali.contains(6666));
//		System.out.println("capacity before: " + mali.getCapacity());
//		mali.trim();
//		System.out.println("capacity after:  " + mali.getCapacity());
//		mali.shuffle();
//		System.out.println(mali);
//		mali.trim();
		System.out.println(mali.getCapacity() + " \t" + mali.getSize());
//		mali.remove(22);
		mali.removeRange(0, 3);
		System.out.println(mali);
//		Iterator<Integer> it = mali.iterator();
//		for (int i = 0; i < NUM_NUM; i++) {
////			System.out.print("  " + it.next());
//			int res = 0;
//			try {
//				res = it.next();
//				System.out.println(res);
//			} catch (Exception e) {
//				System.out.println(e.getMessage());
//			}
//		}

		try {
			mali.add(333, 22);
		} catch (MyArrayListOutOfBounds e) {
			System.err.println(e.getMessage());
			System.err.println("index: " + e.getIndex());
			System.err.println("size: " + e.getSize());
		}

		System.out.println(mali);
	}

}
