package model;

public class MyArrayListOutOfBounds extends Exception {
	private int index;
	private int size;
	
	public MyArrayListOutOfBounds(String msg, int index, int size) {
		super(msg);
		this.index = index;
		this.size = size;
	}

	public int getIndex() {
		return index;
	}

	public int getSize() {
		return size;
	}
	
	
}
