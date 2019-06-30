package model;

public class MyStack<T> implements IMyStack<T> {

	private MyUdiLinkedList<T> stack = new MyUdiLinkedList<T>();
	
	
	@Override
	public void push(T data) {
		stack.addFirst(data);
	}

	@Override
	public T peek() {
		return stack.getFirst();
	}

	@Override
	public T pop() {
		return stack.removeFirst();
	}

	@Override
	public int deep(T data) {
		int res = stack.indexOf(data);
		return res < 0 ? -1 : res + 1;  
	}

	@Override
	public int size() {
		return stack.size();
	}
}
