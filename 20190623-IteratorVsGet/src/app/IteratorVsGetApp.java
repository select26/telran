package app;

import java.util.Iterator;
import java.util.LinkedList;

public class IteratorVsGetApp {

	private static final int NUM_NUM = 100_000;

	public static void main(String[] args) {
		LinkedList<Integer> ll = new LinkedList<>();
		for (int i = 0; i < NUM_NUM; i++) ll.add(1);
		
		int size = ll.size();
		long t1 = System.currentTimeMillis();
		
		for (int i = 0; i < size; i++) ll.get(i);				//using for
		long t2 = System.currentTimeMillis();
		System.out.println("Usial for + get: \t" + (t2 - t1));
		
		int a;
		t1 = System.currentTimeMillis();
				for(Integer i: ll) {a=0;}						//using foreach + next
		t2 = System.currentTimeMillis();
		System.out.println("Usial foreach + next: \t" + (t2 - t1));
/*
		Iterator<Integer> bb = ll
		t1 = System.currentTimeMillis();
//		for(Integer i: ll) {a=0;}						//using foreach + next
		while (ll.)
		t2 = System.currentTimeMillis();
		System.out.println("Usial foreach + next: \t" + (t2 - t1));
*/
	}

}
