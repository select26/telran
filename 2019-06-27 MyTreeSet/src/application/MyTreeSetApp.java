package application;

import java.util.Comparator;
import java.util.Random;

import model.MyTreeSet;


public class MyTreeSetApp {

	private static final int NUM_NUM = 10000;
	static Random gen = new Random();
	
	public static void main(String[] args) {
		MyTreeSet<Integer> mtsi = 
				new MyTreeSet<Integer>(Comparator.naturalOrder());
		
		for (int i = 0; i < NUM_NUM; i++)mtsi.add(i);
		System.out.println(mtsi.size());
		System.out.println(mtsi.deep());
	}

}
