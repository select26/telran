package model;

import java.util.Iterator;

public class MyArrayListIterator<T> implements Iterator<T> {

	private MyArrayList<T> mal;
	private int current = 0;
	
	public MyArrayListIterator(MyArrayList<T> mal) {
		super();
		this.mal = mal;
	}

	@Override
	public boolean hasNext() {
		return current < mal.size();
	}

	@Override
	public T next() {
	
		return mal.get(current++);
	}

}
