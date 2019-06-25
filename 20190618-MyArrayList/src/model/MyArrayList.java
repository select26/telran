package model;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;

public class MyArrayList<T> implements MyList<T> {

	static Random gen = new Random();

	private static final int DEFAULT_CAPACITY = 10;
	private Object[] array;
	private int size = 0;

	public int getSize() {
		return size;
	}

	public int getCapacity() {
		return capacity;
	}

	private int capacity = DEFAULT_CAPACITY;

	public MyArrayList() {
		array = new Object[DEFAULT_CAPACITY];
	}

	public MyArrayList(int specCapacity) {
		if (specCapacity < DEFAULT_CAPACITY)
			specCapacity = DEFAULT_CAPACITY;
		array = new Object[specCapacity];
		capacity = specCapacity;
	}

	@Override
	public void add(T data) {

		if (size == capacity)
			enlargeArray();
		array[size++] = data;
	}

	private void enlargeArray() {
		capacity = capacity * 2;
		Object[] newArray = new Object[capacity];
		System.arraycopy(array, 0, newArray, 0, size);
		array = newArray;
	}

	@Override
	public boolean add(T data, int index) {

		if (index < 0 || index >= size)
			return false;

		if (size == capacity)
			enlargeArray();
		System.arraycopy(array, index, array, index + 1, size - index);
		array[index] = data;
		size++;
		return true;
	}

	@Override
	public T get(int index) {

		if (index < 0 || index >= size)
			return null;
		return (T) array[index];
	}

	@Override
	public boolean set(T data, int index) {

		if (index < 0 || index >= size)
			return false;
		array[index] = data;
		return true;
	}

	@Override
	public int indexOf(T value) {
		for (int i = 0; i < size; i++) {
			if (array[i].equals(value))
				return i;
		}
		return -1;
	}

	@Override
	public boolean contains(T data) {
		return (indexOf(data) >= 0);
	}

	@Override
	public T remove(int index) {
		if (index < 0 || index >= size)
			return null;

		// Object[] newArray = new Object[size];
		T result = (T) array[index];
		// System.arraycopy(array, 0, array, 0, index);
		System.arraycopy(array, index + 1, array, index, size - index - 1);
		array[size - 1] = null;
		size--;
		return result;
	}

	public boolean removeRange(int begin, int end) {
		if (begin < 0 || begin >= end || end > size) {
			System.err.println("Error incoming parametrs in removeRange method!");
			return false;
		} else
			System.arraycopy(array, end , array, begin, size - end);
			size = size - (end - begin);
//			System.out.println("size: " + size );
			Arrays.fill(array, size, size + (end-begin), null);
			return true;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void trim() {
		array = Arrays.copyOf(array, size);
		capacity = size;
	}

	@Override
	public void shuffle() {
		int j;
		for (int i = 0; i < size; i++) {
			j = gen.nextInt(size);
			Object temp = array[j];
			array[j] = array[i];
			array[i] = temp;
		}
	}

	// @Override
	// public void removeRepetitions() {
	// }

	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < size; i++) {
			sb.append("  " + array[i]);
		}
		// sb.append("]");
		return "[" + sb.toString().trim() + "]";
	}

	@Override
	public Iterator<T> iterator() {
		return new MyArrayListIterator(this);
	}
	
//	public Object[] getArray() {
		
//	}
}
