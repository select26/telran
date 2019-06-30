package model;

import java.util.Iterator;

public class MyTreeSetIteratorI<T> implements Iterator<T> {

	private Node<T> current;
	
	public MyTreeSetIteratorI (Node<T> root) {
		if (root != null) current = root.getLeftmost();
	}

	@Override
	public boolean hasNext() {
		return current != null;
	}

	@Override
	public T next() {
		T res = current.getData();
		if (current.getRight() != null)current=current.getRight().getLeftmost();
		else {
			if (current.isLeftChild())current = current.getParent();
			else {
				while(current.isRightChild())current = current.getParent();
				current = current.getParent();
			}
		}
		return res;
	}	

}
