package app;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Colhoz implements Runnable{
	
	private static final int NUM = 1_000_000;
	public static int zakroma;
	public static Lock lock = new ReentrantLock();
	
	@Override
	public void run() {
		
		lock.lock();
		try {
			for (int i = 0; i < NUM; i++) zakroma++;
		} finally {
			lock.unlock();
		}
		
	}

}
