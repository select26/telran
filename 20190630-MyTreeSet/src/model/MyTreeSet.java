package model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

/*
 Conditional for rebalancing tree:
 1. size > N min
 2. level > (1+coeff) (Log2(size) + 1)
 3. balanced == true;
 */

public class MyTreeSet<T> implements ITreeSet<T> {

	private static final int MIN_BALANCE = 100;
	private static final double BALANCE_COEFF = 0.2;
	private Node<T> root;
	private int size;
	private Comparator<T> comparator;
	private boolean balanced = true;
	
	public MyTreeSet() {
		super();
		comparator = (Comparator<T>) Comparator.naturalOrder();
	}

	public MyTreeSet(Comparator<T> comparator) {
		super();
		this.comparator = comparator;
	}

	@Override
	public boolean add(T data) {
		int level = 1;
		if (root == null) {
			root = new Node<T>(data);
			size++;
//			System.out.println("data: " + data + ",\tlevel: " + level);
			return true;
		}
		level = 2;
		Node<T> current = root;
		int compareResult;
		while (true) {
			compareResult = comparator.compare(current.getData(), data);
			if (compareResult == 0)
				return false;
			if (compareResult > 0) {
				if (current.getLeft() == null)
					break;
				current = current.getLeft();
			} else {
				if (current.getRight() == null)
					break;
				current = current.getRight();
			}
			level++;
		}
//		System.out.println("data: " + data + ",\tlevel: " + level);

		Node<T> node = new Node<T>(data);
		node.setParent(current);
		if (compareResult > 0)
			current.setLeft(node);
		else
			current.setRight(node);
		size++;

		if (needBalance(level)) {
			granBalance();
		}
		
		return true;
	}

	private double log2(int num){
		int i = 0;
		for (; (1<<i) < num; i++){}
		return (double) i;
	}
	
	private boolean needBalance(int limit) {
		return 	balanced && 
				( size > MIN_BALANCE ) && 
				( 1. + BALANCE_COEFF )* log2(limit)+1 < size;
	}
	
	@Override
	public boolean contains(T data) {
		return getNodeByData(data) != null;
	}

	private Node<T> getNodeByData(T data) {
		if (root == null)
			return null;

		Node<T> current = root;
		int compareResult;
		while (true) {
			compareResult = comparator.compare(current.getData(), data);
			if (compareResult == 0)
				return current;
			if (compareResult > 0) {
				if (current.getLeft() == null)
					return null;
				current = current.getLeft();
			} else {
				if (current.getRight() == null)
					return null;
				current = current.getRight();
			}
		}
	}

	@Override
	public boolean remove(T data) {
		Node<T> toBeRemoved = getNodeByData(data);

		if (toBeRemoved == null)
			return false;

		if (toBeRemoved.getLeft() == null)
			removeLeftDisable(toBeRemoved);
		else if (toBeRemoved.getRight() == null)
			removeRightDisable(toBeRemoved);
		else {
			Node<T> victim = toBeRemoved.getRight().getLeftmost();
			toBeRemoved.setData(victim.getData());
			removeLeftDisable(victim);
		}
		size--;
		return true;
	}

	private void removeRightDisable(Node<T> node) {
		if (node == root) root = root.getLeft();
		else {
			Node<T> left = node.getLeft();
			Node<T> parent = node.getParent();
			if (node.isLeftChild()) parent.setLeft(left);
			else parent.setRight(left);

			if (left != null) left.setParent(parent);
		}
	}

	private void removeLeftDisable(Node<T> node) {
		if (node==root) root = root.getRight();
		else {
			Node<T> right = node.getRight();
			Node<T> parent = node.getParent();
			if (node.isLeftChild()) parent.setLeft(right);
			else parent.setRight(right);
			
			if (right != null) right.setParent(parent);
		}
	}

	private void granBalance() {
		ArrayList<T> alt = new ArrayList<>();
		for (T t : this) alt.add(t);
		root = null;								// clear tree
		size = 0;									// tree's size = zero
		unbalanced();
		putSubArray(alt, 0, alt.size()-1);
		balanced();
	}
	
	private void putSubArray(ArrayList<T> array, int min, int max) {
		
		if (max-min < 2) {
			add(array.get(min));
			if (max!= min) add(array.get(max));
		} else {
			int middle = min + (max - min)/2;
			add(array.get(middle));
			putSubArray(array, min, middle-1);
			putSubArray(array, middle+1, max);
		}
	}
	
	public void balanced() {
		balanced = true;
	}

	public void unbalanced() {
		balanced = false;
	}
	
	@Override
	public int deep() {
		return subTreeDeep(root);
	}

	private int subTreeDeep(Node<T> node) {
		return node == null ? 0 : Integer.max(subTreeDeep(node.getLeft()), subTreeDeep(node.getRight())) + 1;
	}

	@Override
	public int size() {
		return size;
	}

	public Iterator<T> iterator() {
		return new MyTreeSetIteratorI<>(root);
	}

	public Iterator<T> rangeIterator(T min, T max) {
		return new MyTreeSetRangeIteratorI<>(root, min, max, comparator);
	}

	public Iterator<T> recursiveIterator() {
		return new MyTreeSetIteratorR<>(root);
	}
}
