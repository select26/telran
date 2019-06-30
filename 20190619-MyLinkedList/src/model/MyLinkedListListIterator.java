package model;

import java.util.ListIterator;

public class MyLinkedListListIterator<T> implements ListIterator<T> {

	Node<T> current;
	
//	public MyLinkedListListIterator(Node<T> current) {
//		super();
//		this.current = current;
//	}

	public MyLinkedListListIterator(MyLinkedList<T> myLinkedList) {
		super();
		this.current = myLinkedList.getHead();
	}

	@Override
	public void add(T e) {
		current.setData(e);
		current = current.getNext();
	}

	@Override
	public boolean hasNext() {
		return current.getNext()!=null;
	}

	@Override
	public boolean hasPrevious() {
		return current.getPrev()!=null;
	}

	@Override
	public T next() {
		T res = current.getData();
		current = current.getNext();
		return res;
	}

	@Override
	public int nextIndex() {
		
		return 0;
	}

	@Override
	public T previous() {
		T res = current.getData();
		current = current.getPrev();
		return res;
	}

	@Override
	public int previousIndex() {
		
		return 0;
	}

	@Override
	public void remove() {

	}

	@Override
	public void set(T e) {
	}

}
