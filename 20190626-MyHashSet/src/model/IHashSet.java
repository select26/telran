package model;

public interface IHashSet<T> extends Iterable<T>{

	boolean add(T data);
	boolean contains(T data);
	boolean remove(T data);
	int size();
}
