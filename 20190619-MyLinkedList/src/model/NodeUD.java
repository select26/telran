package model;

public class NodeUD<T> {

	private T data;
	private NodeUD<T> next = null;
	
	public NodeUD(T data) {
		super();
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public NodeUD<T> getNext() {
		return next;
	}

	public void setNext(NodeUD<T> next) {
		this.next = next;
	}
	
}
