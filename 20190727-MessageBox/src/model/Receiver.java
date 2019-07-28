package model;

import java.util.concurrent.ThreadLocalRandom;

import log.MessageBoxLog;

public class Receiver implements Runnable{
	
	private String name;
	private int numberOfMessages;
	private long averageDelay;

	public Receiver(String name, int numberOfMessages, long averageDelay) {
		super();
		this.name = name;
		this.numberOfMessages = numberOfMessages;
		this.averageDelay = averageDelay;
	}

	public String getName() {
		return name;
	}

	@Override
	public void run() {
		int msgCounter = 0;
		while(msgCounter < numberOfMessages){
			
			try {
				Message msg = MessageBox.receiveMessage(this);
				MessageBoxLog.LOG.add(msg);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
			
			try {
				Thread.sleep(ThreadLocalRandom.current().nextLong(2*averageDelay));
				msgCounter ++;
			} catch (InterruptedException e) {}
						
		}
	}

}
