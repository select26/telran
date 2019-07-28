package model;

import java.time.LocalTime;
import java.util.concurrent.ThreadLocalRandom;

public class Sender implements Runnable{
	
	private String name;
	private int numberOfMessages;
	private long averageDelay;

	public Sender(String name, int numberOfMessages, long averageDelay) {
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
				Thread.sleep(ThreadLocalRandom.current().nextLong(2*averageDelay));	
			} 
			catch (InterruptedException e) {}	
			
			Message msg = new Message();
			msg.setPayload("Message created by "+name+ " at "+LocalTime.now());
			
			try {
				MessageBox.sendMessage(this, msg);
				msgCounter++;
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		
		}
	}

}
