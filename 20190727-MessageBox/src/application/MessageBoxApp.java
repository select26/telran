package application;

import config.Config;
import log.MessageBoxLog;
import model.Message;
import model.Receiver;
import model.Sender;

public class MessageBoxApp {
	
	public static void main(String[] args) throws InterruptedException {
		
	
	Thread[] senders = new Thread[Config.NUM_SENDERS];
	Thread[] receivers = new Thread[Config.NUM_RECEIVERS];
	
	for (int i=0; i < senders.length; i++) senders[i] = new Thread(new Sender("sender #"+i, Config.NUM_SENDER_MESSAGES, Config.SENDER_DELAY));
	for (int i=0; i < receivers.length; i++) receivers[i] = new Thread(new Receiver("receiver #"+i, Config.NUM_RECEIVER_MESSAGES, Config.RECEIVER_DELAY));
	
	for (int i=0; i < senders.length; i++) senders[i].start();
	for (int i=0; i < receivers.length; i++) receivers[i].start();
	
	for (int i=0; i < receivers.length; i++) receivers[i].join();
	System.out.println("Messages sent: "+(Config.NUM_SENDERS*Config.NUM_SENDER_MESSAGES) + "; "+
						"Messages logged: "+ MessageBoxLog.LOG.size());
	System.out.println("Box full: "+ MessageBoxLog.BOX_FULL);
	System.out.println("Box empty: "+ MessageBoxLog.BOX_EMPTY);
	
	System.out.println(MessageBoxLog.LOG.stream()
		.map(msg -> msg.getProcesingTimeMs())
		.reduce((accum, dt) -> accum+dt).get()/MessageBoxLog.LOG.size());
		//.forEach(System.out :: println);
	}

}
