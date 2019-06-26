package model;

import java.util.ArrayList;

public class MyHashSet<T> implements IHashSet<T>{

	private static final int INITIAL_N = 4;
	private static final double DEFAULT_LOADFACTOR = 0.75;
	
	private int size = 0;
	private ArrayList<ArrayList<T>> hs = new ArrayList<>();
	private int n= INITIAL_N;								// number of buckets is 1 << n
	private double loadfactor =  DEFAULT_LOADFACTOR;
	
	public MyHashSet() {
//		n = INITIAL_N;
		int numShelves = 1<<n;
		for (int i = 0; i < numShelves; i++) hs.add(new ArrayList<T>());
	}
	
	@Override
	public boolean add(T data) {
		if ((1<<n) * loadfactor < size) duplicateShelvs();	// expand array size
		
		ArrayList<T> alt = hs.get(getNumShelv(data));
		if (alt.contains(data)) return false;				// if already have
		alt.add(data);
		size++;
		return true;
	}

	private void duplicateShelvs() {
		n++;
		int initialSize = hs.size();
		for (int i=0; i < initialSize; i++) {
			ArrayList<T> alt = hs.get(i);
			ArrayList<T> novice = new ArrayList<T>();
			for (int j=0; j< alt.size(); j++) {
				T data = alt.get(j);
				if ( (data.hashCode() & (1<<n)) !=0 ) {
					novice.add(data);
					alt.remove(data);
				}
			}
			hs.add(novice);
		}
	}

	private int getNumShelv(T data) {
		return data.hashCode() & ((1<<n)-1);				// last 4 bits from hashCode
	}

	@Override
	public boolean contains(T data) {
		ArrayList<T> alt = hs.get(getNumShelv(data));
		if (alt.contains(data))	return true;
		else return false;
	}

	@Override
	public boolean remove(T data) {
		ArrayList<T> alt = hs.get(getNumShelv(data));
		if (alt.remove(data)) {
			size--;
			return true;
		}
		else return false;
	}

	@Override
	public int size() {
		
		return size;
	}
	
	public void display() {
		int numShelvs = (1<<n);
		for (int i = 0; i < numShelvs; i++) {
			System.out.println(i + ": " + hs.get(i));
		}
	}
	
}
