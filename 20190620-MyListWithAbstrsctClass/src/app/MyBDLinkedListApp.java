package app;

//import model.MyLinkedList;
import model.BDLinkedList;

public class MyBDLinkedListApp {

	public static void main(String[] args) {
//		MyLinkedList<Integer> mlli = new MyLinkedList<>();
//		mlli.add(3);
//		mlli.add(11);
//		mlli.addLast(-8);
//		
//		mlli.addFirst(4);
//		mlli.addFirst(-2);
//		mlli.addFirst(6);
//		
//		mlli.addByIndex(3, 111);
//		
//		System.out.println(mlli);
//		System.out.println(mlli.indexOf(111));
//		mlli.removeFirst();
//		System.out.println("removeFirst " + mlli);
//		mlli.removeLast();
//		System.out.println("removeLast " + mlli);
//		mlli.remove(-1);
//		System.out.println("remove by index " + mlli);
//		mlli.remove((Integer)3);
//		System.out.println("remove by value " + mlli);
//		mlli.eliminateAll();
//		System.out.println("eliminateAll " + mlli);
//		
		BDLinkedList<Integer> mlli = new BDLinkedList<>();
		mlli.add(3);
		mlli.add(11);
		mlli.addLast(-8);
		
		mlli.addFirst(4);
		mlli.addFirst(-2);
		mlli.addFirst(6);
		mlli.add(411);
		mlli.addLast(-98);
		
		mlli.addByIndex(3, 111);
		
		System.out.println(mlli);
		System.out.println(mlli.indexOf(111));
		mlli.removeFirst();
		System.out.println("removeFirst " + mlli);
		mlli.removeLast();
		System.out.println("removeLast " + mlli);
		mlli.remove(1);
		System.out.println("remove by index " + mlli);
		mlli.remove((Integer)3);
		System.out.println("remove by value " + mlli);
		mlli.eliminateAll();
		System.out.println("eliminateAll " + mlli);
		
	}

}
