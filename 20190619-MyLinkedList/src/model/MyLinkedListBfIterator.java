package model;

import java.util.Iterator;

public class MyLinkedListBfIterator<T> implements Iterator<T> {

	Node<T> current, head;
	boolean revers = false;
	boolean jump = false;
	boolean end = true;
	
	public MyLinkedListBfIterator (Node<T> head) {
		super();
		this.current = head;
		this.head = head;
	}
	
	@Override
	public boolean hasNext() {
//		if (current.getPrev()!= head) return true;
//		else return false;
		return end;
	}
	
	@Override
	public T next() {
		T res = current.getData();
		if (revers) {
			if (current.getPrev()==head) end = false; 
			current = current.getPrev().getPrev();
			
		} else if (current.getNext()== null) {
			if (jump) current = current.getPrev().getPrev();
			else {
				current = current.getPrev();
			}
			revers = true;
		} else if (current.getNext().getNext() != null) current = current.getNext().getNext();
		else { 
			current = current.getNext();
			jump = true;
		}
		
		return res;
	}
}
