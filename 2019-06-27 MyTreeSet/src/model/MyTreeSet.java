package model;

import java.util.Comparator;

public class MyTreeSet<T> implements ITreeSet<T> {
	
	private Node<T> root;
	private int size;
	private Comparator<T> comparator;

	public MyTreeSet(Comparator<T> comparator) {
		super();
		this.comparator = comparator;
	}

	@Override
	public boolean add(T data) {
		if (root == null) {
			root = new Node<T>(data);
			size++;
			return true;
		}
		
		Node<T> current = root;
		int compareResult;
		while (true) {
			compareResult = comparator.compare(current.getData(), data);
			if (compareResult == 0) return false;
			if (compareResult > 0) {
				if (current.getLeft() == null) break;
				current = current.getLeft();
			}else {
				if (current.getRight() == null) break;
				current = current.getRight();
			}
		}
		
		Node<T> node = new Node<T>(data);
		node.setParent(current);
		if (compareResult > 0) current.setLeft(node);
		else current.setRight(node);
		size++;
		
		return true;
	}

	@Override
	public boolean contains(T data) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(T data) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int deep() {
		return subTreeDeep(root);
	}

	private int subTreeDeep(Node<T> node) {
		return node == null ? 0 :
			Integer.max(subTreeDeep(node.getLeft()), 
				           subTreeDeep(node.getRight())) +1;
	}

	@Override
	public int size() {
		return size;
	}

}
