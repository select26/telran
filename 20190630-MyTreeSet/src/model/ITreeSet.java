package model;

public interface ITreeSet<T> extends Iterable<T> {

	boolean add(T data);
	boolean contains(T data);
	boolean remove(T data);
	
	int deep();
	
	int size();
	
}
