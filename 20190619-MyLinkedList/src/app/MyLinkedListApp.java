package app;

import java.text.NumberFormat;
import java.util.Iterator;

import model.MyLinkedList;
import model.MyUdiLinkedList;

public class MyLinkedListApp {

	public static void main(String[] args) {

		MyLinkedList<Integer> m = new MyLinkedList<Integer>();

		m.add(3);
		m.add(11);
		m.addLast(-8);
		m.addFirst(4); 
//		m.addFirst(-2);
//		m.addFirst(6);
//		m.addByIndex(3, 111);
//		
		System.out.println(m);
//		System.out.println(m.indexOf(6));
//		m.removeFirst();
//		m.removeLast();
//		System.out.println(m);
//		m.eleminateAll();
		m.addLast(22);
		m.add(98);
		System.out.println(m);
		
//		Iterator<Integer> it = m.iterator();
//		while (it.hasNext()) {
//			System.out.print(it.next() + " ");
//		}
		
		for (Integer i : m) {
			System.out.print(i + " ");
		}
		System.out.println();
		Iterator<Integer> bb = m.backIterator();
		while(bb.hasNext()) System.out.print(bb.next() + " ");
		
		System.out.println();
		Iterator<Integer> bf  = m.bfIterator();
		while(bf.hasNext()) System.out.print(bf.next() + " ");
		
//		Runtime runtime = Runtime.getRuntime();
//
//		NumberFormat format = NumberFormat.getInstance();
//				
//		StringBuilder sb = new StringBuilder();
//		long maxMemory = runtime.maxMemory();
//		long allocatedMemory = runtime.totalMemory();
//		long freeMemory = runtime.freeMemory();
//
//		sb.append("free memory: " + format.format(freeMemory / 1024) + "\n");
//		sb.append("allocated memory: " + format.format(allocatedMemory / 1024) + "\n");
//		sb.append("max memory: " + format.format(maxMemory / 1024) + "\n");
//		sb.append("total free memory: " + format.format((freeMemory + (maxMemory - allocatedMemory)) / 1024) + "\n");
//		System.out.println(sb.toString());
		}

}
