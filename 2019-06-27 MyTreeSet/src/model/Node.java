package model;

public class Node<T> {

	private T data;
	private Node<T> left;
	private Node<T> right;
	private Node<T> parent;
	
	public Node (T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Node<T> getLeft() {
		return left;
	}

	public void setLeft(Node<T> left) {
		this.left = left;
	}

	public Node<T> getRight() {
		return right;
	}

	public void setRight(Node<T> right) {
		this.right = right;
	}

	public Node<T> getParent() {
		return parent;
	}

	public void setParent(Node<T> parent) {
		this.parent = parent;
	}
	
	public boolean isRoot() {
		return parent == null;
	}
	
	public boolean isLeftChild() {
		return parent != null && this == parent.left;
	}
	
	public boolean isRightChild(){
		return parent != null && this == parent.right;
	}
	
	public Node<T> getLeftmost(){
		Node<T> current = this;
		while(current.left != null) current = current.left;
		return current;
	}
	

}
