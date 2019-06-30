package model;

import java.util.ArrayList;
import java.util.Iterator;

public class MyHashSetIterator<T> implements Iterator<T> {
	
	private Iterator<ArrayList<T>> outerIterator;
	private Iterator<T> innerIterator ;
	
	public MyHashSetIterator(ArrayList<ArrayList<T>> hashSet) {
		outerIterator = hashSet.iterator();
		takeNextInnerIterator();
	}
	
	public boolean hasNext() {
		return outerIterator.hasNext() || innerIterator.hasNext();
	}
	
	public T next() {
		T res = innerIterator.next();
		if (!innerIterator.hasNext() && outerIterator.hasNext())takeNextInnerIterator();
		return res;
	}
	
	private void takeNextInnerIterator(){
		do{
			innerIterator = outerIterator.next().iterator();
		}while (outerIterator.hasNext() && !innerIterator.hasNext());
	}	


}
