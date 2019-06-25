package model;

public abstract class MyAbsLinkedList<T> implements MyAbsList<T>{
	protected NodeAbs<T> head = null;
	protected NodeAbs<T> tail = null;
	protected int size = 0;

	@Override
	public abstract void add(T data);

	@Override
	public abstract void addFirst(T data);

	@Override
	public abstract boolean addByIndex(int index, T data);
	
	@Override
	public void addLast(T data) {
		add (data);
	}

	protected NodeAbs<T> getNodeByIndex(int index) {		//Оптимизировать для двунапр списка
		NodeAbs<T> result = head;
		int counter = 0;
		while (counter < index){
			result = result.getNext();
			counter++;
		}
		return result;
	}

	@Override
	public int indexOf(T data) {
		NodeAbs<T> result = head;
		for (int i = 0; i < size; i++) {
			if (result.getData().equals(data)) return i;
			result = result.getNext();
		}
		return -1;
	}

	@Override
	public boolean contains(T data) {
		return indexOf(data)>=0;
	}

	@Override
	public T get(int index) {
		return (index <0 || index >= size)?	null : getNodeByIndex(index).getData();
	}

	@Override
	public T detFirst() {
		return head == null ? null : head.getData();
	}

	@Override
	public T detLast() {
		return tail == null ? null : tail.getData();
	}

	@Override
	public boolean set(int index, T data) {
		if (index<0 || index>=size) return false;
		getNodeByIndex(index).setData(data);
		return true;
	}

	@Override
	public abstract T removeFirst();
	
	@Override
	public abstract T removeLast();

	@Override
	public abstract T remove(int index);

	@Override
	public abstract boolean remove(T data);
		
		
	@Override
	public void eliminateAll() {
		NodeAbs <T> current = head;
		NodeAbs <T> next;
		while (current != null){
			next = current.getNext();
			eliminate(current);
			current = next;
			size --;
		}
		head = null;
		tail = null;
		size = 0;
	}

	protected abstract void eliminate(NodeAbs<T> node);
	
	@Override
	public int size() {
		return size;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		NodeAbs<T> node = head;
		while (node !=null){
			sb.append(node.getData() + " ");
			node = node.getNext();
		}
		return "[" + sb.toString().trim() + "]";
	}


}
