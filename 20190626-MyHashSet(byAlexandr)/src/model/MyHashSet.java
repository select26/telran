package model;

import java.util.ArrayList;
import java.util.Iterator;

public class MyHashSet<T> implements IHashSet<T>{
	
	private static final int INITIAL_N = 4;
	private static final double DEFAULT_LOADFACTOR = 0.75;

	private ArrayList<ArrayList<T>> hs = new ArrayList<>();
	private int n = INITIAL_N;   // number of "shelves" is 1 << n 
	private int size = 0;
	private double loadFactor = DEFAULT_LOADFACTOR;
	
	public MyHashSet() {
		int numShelves = (1 << n);
		for (int i = 0; i < numShelves; i++ ) hs.add(new ArrayList<T>());
	}
	
	@Override
	public boolean add(T data) {
		
		if ((1 << n)*loadFactor < size) duplicateShelves();
		
		ArrayList<T> alt = hs.get(getNumShelf(data));
		if (alt.contains(data)) return false;
		alt.add(data);
		size++;
		return true;
	}

	private void duplicateShelves() {
		
		n++;
		
		int initialSize = hs.size();
		for(int i=0; i < initialSize; i++) {
			ArrayList<T> alt = hs.get(i);
			ArrayList<T> novice = new ArrayList<>();
			for (int j = 0; j < alt.size(); j++) {
				T data = alt.get(j);
				if ((data.hashCode() & (1 << n)) != 0){
					novice.add(data);
					alt.remove(data);
				}
			}
			hs.add(novice);
		}	
	}

	private int getNumShelf(T data) {
		return data.hashCode() & ((1 << n) - 1);
	}

	@Override
	public boolean contains(T data) {
		return hs.get(getNumShelf(data)).contains(data);
	}

	@Override
	public boolean remove(T data) {
		boolean result = hs.get(getNumShelf(data)).remove(data);
		if (result) size--;
		return result;
	}

	@Override
	public int size() {
		return size;
	}
	
	public void display() {
		int numShelves = (1 << n);
		for (int i = 0; i< numShelves; i++)
			System.out.println(i+": "+hs.get(i));
	}

	@Override
	public Iterator<T> iterator() {
		
		return new MyHashSetIterator<T>(hs);
	}

	
}
