package model;

import java.util.Iterator;

public class MyLinkedListBackIterator<T> implements Iterator<T> {
	Node<T> current;
	
	public MyLinkedListBackIterator (Node<T> tail) {
		super();
		this.current = tail;
	}

	@Override
	public boolean hasNext() {
		
		return current != null;
	}

	@Override
	public T next() {
		T res = current.getData();
		current = current.getPrev();
		return res;
	}

}
