package model;

public abstract class NodeAbs<T> {
	private T data;
	private NodeAbs <T> next = null;
	
	public NodeAbs(T data) {
		super();
		this.data = data;
		
	} 
	
	public NodeAbs() {
		super();
	}
	
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public NodeAbs<T> getNext() {
		return next;
	}
	public void setNext(NodeAbs<T> next) {
		this.next = next;
	}
	
	

}
