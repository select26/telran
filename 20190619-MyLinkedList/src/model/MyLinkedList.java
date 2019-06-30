package model;

import java.util.Iterator;
import java.util.ListIterator;

public class MyLinkedList<T> implements MyList<T>, Iterable<T> {

	private Node<T> head = null;
	private Node<T> tail = null;
	private int size = 0;

	public Node<T> getHead() {
		return head;
	}

	public void setHead(Node<T> head) {
		this.head = head;
	}

	public Node<T> getTail() {
		return tail;
	}

	public void setTail(Node<T> tail) {
		this.tail = tail;
	}

	@Override
	public void add(T data) {
		Node<T> node = new Node<T>(data);

		if (head == null)
			head = node;
		else {
			node.setPrev(tail);
			tail.setNext(node);
		}
		tail = node;
		size++;
	}

	@Override
	public void addFirst(T data) {
		Node<T> node = new Node<>(data);
		if (head == null) {
			tail = node;
		} else {
			node.setNext(head);
			head.setPrev(node);
		}
		head = node;
		size++;
	}

	@Override
	public void addLast(T data) {
		add(data);
	}

	@Override
	public boolean addByIndex(int index, T data) {
		if (index<0 || index>size) return false;
		if (index == 0 ) addFirst(data);
		else if (index == size) add(data);
		else {
			Node<T> node = new Node<>(data);
			
			Node<T> target = getNodeByIndex(index);
			Node<T> prev = target.getPrev();
			
			node.setNext(target);
			node.setPrev(prev);
			target.setPrev(node);
			prev.setNext(node);
			
			size++;
		}
		return true;
	}

	private Node<T> getNodeByIndex(int index) {
//		if (index==0) return head;
//		if (index==size) return tail;
		Node<T> result = head;
		int counter = 0;
		while (counter < index) {
			result = result.getNext();
			counter++;
		}
		return result;
	}

	@Override
	public int indexOf(T data) {
		Node<T> result = head;
//		int counter = 0;
		for (int i = 0; i < size; i++) {
			if (result.getData().equals(data)) return i;
			result = result.getNext();
		}
		return -1;
	}

	@Override
	public boolean contains(T data) {
		return indexOf(data) >= 0;
	}

	@Override
	public T get(int index) {
		return (index < 0 || index >= size) ? null : getNodeByIndex(index).getData();
	}

	@Override
	public T getFirst() {
		return head == null ? null : head.getData();
	}

	@Override
	public T getLast() {
		return tail == null ? null : tail.getData();
	}

	@Override
	public boolean set(int index, T data) {
		if (index < 0 || index >= size)	return false;
		getNodeByIndex(index).setData(data);
		return true;
	}

	@Override
	public T removeFirst() {
		if (head == null ) return null;
		Node<T> tmp = head;
		head = head.getNext();
		head.setPrev(null);
		size--;
		return tmp.getData();
	}

	@Override
	public T removeLast() {
		Node<T> tmp = tail;
		tail = tail.getPrev();
		tail.setNext(null);
		size--;
		return tmp.getData();
	}

	@Override
	public T removeByIndex(int index) {
		if (index<0 || index>=size) return null;
		if (index==0) return removeFirst();
		if (index==size-1) return removeLast();
		
		Node<T> tmp = getNodeByIndex(index);
//		if (index<size-1) tmp.getPrev().setNext(tmp.getNext()); else tmp.getPrev().setNext(null); 
//		if (index<size-1) tmp.getNext().setPrev(tmp.getPrev()); 
		tmp.getPrev().setNext(tmp.getNext()); 
		tmp.getNext().setPrev(tmp.getPrev()); 
		size--;
		return tmp.getData();
	}

	@Override
	public boolean remove(T data) {
		Node<T> victim = head;
		while (victim != null){
		
			if (victim.getData().equals(data)){
				if (victim == head) return removeFirst() != null;
				if (victim == tail) return removeLast() != null;
				
				victim.getPrev().setNext(victim.getNext());
				victim.getNext().setPrev(victim.getPrev());
				
				elemenate(victim);
				size--;
				return true;
			}
			victim = victim.getNext();
		}
		return false;
	}

	@Override
	public void eleminateAll() {
		Node<T> tmp = head;
		Node<T> tmp2;
		for (int i = 0; i < size; i++) {
			tmp2 = tmp.getNext();
			tmp.setPrev(null);
			tmp.setNext(null);		
			tmp.setData(null);
			tmp = tmp2;
		}
		head = null;
		tail = null;
		size = 0;
	}

	@Override
	public int size() {
		return size;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Node<T> node = head;
		while (node != null) {
			sb.append(node.getData() + " ");
			node = node.getNext();
		}
		return "[" + sb.toString().trim() + "]";
	}
	
	private void elemenate(Node<T> node) {
		if (node!=null) {
			node.setNext(null);
			node.setData(null);
		}
	}

	@Override
	public Iterator<T> iterator() {
		return new  MyLinkedListIterator(head);
	}
	
	public Iterator<T> backIterator() {
		return new MyLinkedListBackIterator(tail);
	}
	
	public Iterator<T> bfIterator() {
		return new MyLinkedListBfIterator(head);
	}

	public ListIterator<T> listIterator() {
		return new MyLinkedListListIterator(this);
	}
}
