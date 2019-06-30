package model;

import java.util.Comparator;
import java.util.Iterator;

public class MyTreeSetRangeIteratorI<T> implements Iterator<T>{
	
	private Node<T> current;
	private T max;
	private Comparator<T> comparator;
	
	public MyTreeSetRangeIteratorI (Node<T> root, T min, T max, Comparator<T> comparator) {
		this.max = max;
		this.comparator = comparator;
		if (root != null) current = getStart(root, min);
	}

	@Override
	public boolean hasNext() {
		return current != null && comparator.compare(current.getData(), max) < 0;
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
	
	private Node<T> getStart(Node<T> node, T min){

		int compareResult = comparator.compare(min, node.getData());
		
		if (compareResult == 0)return node;
		
		if (compareResult < 0) {
			Node<T> left = node.getLeft();
 			if(left == null)return node;
 			Node<T> leftStart = getStart(left, min);
			return comparator.compare(min, leftStart.getData()) > 0 ? node : leftStart;
		}
		
		else {
			Node<T> right = node.getRight();
			if(right == null)return node;
 			Node<T> rightStart = getStart(right, min);
			return comparator.compare(min, rightStart.getData()) > 0 ? node : rightStart;
		}
	}
}
