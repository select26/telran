package model;

public class BDLinkedList<T> extends MyAbsLinkedList<T> {

	@Override
	public void add(T data) {
		NodeBD<T> node = new NodeBD<T>(data);
		
		if(head == null)head = node;
		else {
			node.setPrev((NodeBD<T>) tail);
			tail.setNext(node);
			}
		tail = node;
		size++;	
	}

	@Override
	public void addFirst(T data) {
		NodeBD<T> node = new NodeBD<T>(data);
		if (head == null) tail = node;
		else {
			node.setNext(head);
			((NodeBD<T>) head).setPrev(node);								//??????
		}
		head = node;
		size++;
	}

	@Override
	public boolean addByIndex(int index, T data) {
		if (index <0 || index > size) return false;
		if (index == 0) addFirst(data);
		else if (index == size) add(data);
		else{
			NodeBD<T> node = new NodeBD<T> (data);
			NodeBD<T> target = (NodeBD<T>) getNodeByIndex(index);
			NodeBD<T> prev = target.getPrev();
			node.setNext(target);
			node.setPrev(prev);
			prev.setNext(node);
			target.setPrev(node);
			size++;
		}
		return true;
	}

	@Override
	public T removeFirst() {
		if(head == null) return null;
		
		NodeBD<T> next = (NodeBD<T>) head.getNext();			//?????????
		if (next == null) tail = null;
		else next.setPrev(null);
		
		T result = head.getData();
		eliminate(head);
		head = next;
		size--;
		return result;
	}

	@Override
	public T removeLast() {
		if(tail == null) return null;
		
		NodeBD<T> prev = ((NodeBD<T>) tail).getPrev();							//????????
		if (prev == null) head = null;
		else prev.setNext(null);
		
		T result = tail.getData();
		eliminate(tail);
		tail = prev;
		size--;
		return result;
	}

	@Override
	public T remove(int index) {
		if (index <0 || index >= size) return null;
		if (index == 0) return removeFirst();
		if (index == size-1) return removeLast();
		
		NodeBD <T> tmp = (NodeBD<T>) getNodeByIndex(index);
		T result = tmp.getData();
		tmp.getPrev().setNext(tmp.getNext());
		((NodeBD<T>) tmp.getNext()).setPrev(tmp.getPrev());				//??????
		
		eliminate(tmp);
		size--;
		
		return result;
	}

	@Override
	public boolean remove(T data) {
		NodeBD<T> victim = (NodeBD<T>) head;									//??????
		while (victim != null){
		
			if (victim.getData().equals(data)){
				if (victim == head) return removeFirst() != null;
				if (victim == tail) return removeLast() != null;
				
				victim.getPrev().setNext(victim.getNext());
				((NodeBD<T>) victim.getNext()).setPrev(victim.getPrev());		//
				
				eliminate(victim);
				size--;
				return true;
			}
			victim = (NodeBD<T>) victim.getNext();								//
		}
		return false;
		}

	@Override
	protected void eliminate(NodeAbs<T> tmp) {
		((NodeBD<T>) tmp).setPrev(null);														//?????
		tmp.setNext(null);
		tmp.setData(null);
	}

}
