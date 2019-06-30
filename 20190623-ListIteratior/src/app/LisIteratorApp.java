package app;

import java.util.ArrayList;
import java.util.ListIterator;

public class LisIteratorApp {

	private static final int NUM_NUM = 20;

	public static void main(String[] args) {
		
		ArrayList<Integer> ali = new ArrayList<>();
		
		for (int i = 0; i < NUM_NUM; i++) ali.add(10+i);

		ListIterator<Integer> lit = ali.listIterator();
		System.out.println(ali);
//		System.out.println(lit.previous());
//		System.out.println(lit.hasNext());
//		lit.previous();
//		lit.previous();
//		lit.next();
//		lit.next();
//		lit.next();
//		lit.remove();
//		System.out.println(lit.nextIndex());
//		System.out.println(lit.previousIndex());
		while(lit.hasNext()) {
			int i = lit.next();
			lit.set(i*i);
		}
		System.out.println(ali);
	}
	

}
