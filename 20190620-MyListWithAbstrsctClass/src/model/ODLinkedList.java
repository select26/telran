package model;

public class ODLinkedList <T> extends MyAbsLinkedList<T>{

	@Override
	public void add(T data) {
		NodeOD<T> node = new NodeOD<T>(data);
		
		if(head == null) head = node;
		else tail.setNext(node);
		tail = node;
		size++;		
	}

	@Override
	public void addFirst(T data) {
		NodeOD<T> node = new NodeOD<T>(data);
		node.setNext(head);
		if (head == null) tail = node;
		else node.setNext(head);
		head = node;
		size++;
	}

	@Override
	public boolean addByIndex(int index, T data) {
		if (index <0 || index > size) return false;
		if (index == 0) addFirst(data);
		else if (index == size) add(data);
		else{
			NodeOD<T> node = new NodeOD<T> (data);
			NodeOD<T> targetPrev = (NodeOD<T>) getNodeByIndex(index-1);			// ???????
			NodeOD<T> target = (NodeOD<T>) targetPrev.getNext();				// ???????
			node.setNext(target);
			targetPrev.setNext(node);
			size++;
		}
		return true;
	}

	@Override
	public T removeFirst() {
		if(head == null) return null;
		T result = head.getData();
		NodeOD<T> next = (NodeOD<T>) head.getNext();
		eliminate(head);
		head = next;
		if (next == null) tail = null;
					
		size--;
		return result;
	}

	@Override
	public T removeLast() {
		if(tail == null) return null;
		T result = tail.getData();
		if (head == tail){
			eliminate(tail);
			head = null;
			tail = null;
		}
		else {
			NodeOD<T> prev = (NodeOD<T>) getNodeByIndex(size-2);				// Откуда кастинг??????
			prev.setNext(null);
			eliminate(tail);
			tail = prev;
		}
		size--;
		return result;
	}

	@Override
	public T remove(int index) {
		if (index <0 || index >= size) return null;
		if (index == 0) return removeFirst();
		if (index == size-1) return removeLast();
				
		NodeOD <T> prev = (NodeOD<T>) getNodeByIndex(index-1);					//??????
		NodeOD <T> tmp = (NodeOD<T>) prev.getNext();
		T result = tmp.getData();
		prev.setNext(tmp.getNext());
		
		eliminate(tmp);
		size--;
		return result;
	}

	@Override
	public boolean remove(T data) {
		if (head == null) return false;
		if (head.getData().equals(data)){
			removeFirst();
			return true;
		}
		
		NodeOD<T> prev = (NodeOD<T>) head;
		NodeOD<T> victim;
		
		do {
			victim = (NodeOD<T>) prev.getNext();
			if (victim == null) break;
			if (victim.getData().equals(data)){
				prev.setNext(victim.getNext());
				eliminate(victim);
				if (victim == tail) prev = (NodeOD<T>) tail;
				size--;
				return true;
			}
			prev = victim;
		} while (prev != null);
		return false;
	}

	@Override
	protected void eliminate(NodeAbs<T> node) {
		if (node == null) return; 
		node.setNext(null);
		node.setData(null);
	}

}
