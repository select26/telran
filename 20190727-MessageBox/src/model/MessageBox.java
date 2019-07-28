package model;

import java.time.LocalTime;
import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import config.Config;
import log.MessageBoxLog;

public class MessageBox<T> {
	
	private static LinkedList<Message> messageBox = new LinkedList<>();
	
	private static ReentrantLock lock = new ReentrantLock();
	private static Condition full = lock.newCondition();
	private static Condition empty = lock.newCondition();

	public static void sendMessage(Sender sender, Message message) throws InterruptedException {
		
		try {
			message.setSendTime(LocalTime.now());
			
			lock.lock();
			while (messageBox.size() >= Config.MAIL_BOX_SIZE) {
				MessageBoxLog.BOX_FULL++;
				full.await();
			}
			
			message.setSender(sender);
			message.setSent(true);
			
			messageBox.addLast(message);
		
			empty.signal();
		} 
		finally {
			lock.unlock();
		}
		
	}

	public static Message receiveMessage(Receiver receiver) throws InterruptedException {
		
		Message message;
		try {
			lock.lock();
			while (messageBox.size() == 0) {
				MessageBoxLog.BOX_EMPTY++;
				empty.await();
			}
			
			message = messageBox.pollFirst();
			
			message.setReceiver(receiver);
			message.setReceiveTime(LocalTime.now());
			message.setReceived(true);
			
			full.signal();
		
		}finally {
			lock.unlock();
		}
		return message;

	}

}
