package model;

import java.time.Duration;
import java.time.LocalTime;

public class Message {
	
	private boolean sent = false;
	private boolean received = false;
	
	private Sender sender;
	private LocalTime sendTime;
	
	private Receiver receiver;
	private LocalTime receiveTime;
	
	private String payload;

	public boolean isSent() {
		return sent;
	}

	public void setSent(boolean sent) {
		this.sent = sent;
	}

	public boolean isReceived() {
		return received;
	}

	public void setReceived(boolean received) {
		this.received = received;
	}

	public Sender getSender() {
		return sender;
	}

	public void setSender(Sender sender) {
		this.sender = sender;
	}

	public LocalTime getSendTime() {
		return sendTime;
	}

	public void setSendTime(LocalTime sendTime) {
		this.sendTime = sendTime;
	}

	public Receiver getReceiver() {
		return receiver;
	}

	public void setReceiver(Receiver receiver) {
		this.receiver = receiver;
	}

	public LocalTime getReceiveTime() {
		return receiveTime;
	}

	public void setReceiveTime(LocalTime receiveTime) {
		this.receiveTime = receiveTime;
	}

	public String getPayload() {
		return payload;
	}

	public void setPayload(String payload) {
		this.payload = payload;
	}

	@Override
	public String toString() {
		return payload+"; sent: " + sendTime +"; "
				           + receiver.getName() + ", received: " + receiveTime ;
	}
	
	public long getProcesingTimeMs() {
		return Duration.between(sendTime, receiveTime).toMillis();
		
	}
	
	
	

}
