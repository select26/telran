package application;

import java.util.Random;

import model.MyHashSet;

public class MyHashSetAppAl {

	private static final int NUN_NUM = 12;
	static Random gen = new Random();
	public static void main(String[] args) {
		MyHashSet<Integer> hsi = new MyHashSet<>();
		for (int i=0; i < NUN_NUM; i++)hsi.add(gen.nextInt(1000));

		hsi.display();
		System.out.println("*******************");
		hsi.add(-666);
		hsi.add(-777);
		hsi.display();
		System.out.println(hsi.size());
		/*System.out.println(hsi.contains(50));
		System.out.println(hsi.remove(50));
		hsi.display();
		System.out.println(hsi.size());*/

		for (Integer i: hsi) System.out.print(i + " ");
		System.out.println();
		
	}

}
