package model;

public class NodeBD<T> extends NodeAbs<T> {
	private NodeBD<T> prev = null;
	
	public NodeBD (T data) {
		super(data);
	}
	
	public NodeBD () {
		super();
	}

	public NodeBD<T> getPrev() {
		return prev;
	}

	public void setPrev(NodeBD<T> prev) {
		this.prev = prev;
	}
	

}
