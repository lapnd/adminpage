package com.hugelist.client.entities;

public class AccountStatistics {
	
	private String derivaName;
	private String AID;
	private int totalUploaded;
	private int totalDownloaded;
	private int sentMessages;
	private int receivedMessages;

	public AccountStatistics(String derivaName, String aID) {
		super();
		this.derivaName = derivaName;
		AID = aID;
	}

	
	public AccountStatistics(String derivaName, String aID, int totalUploaded,
			int totalDownloaded, int sentMessages, int receivedMessages) {
		super();
		this.derivaName = derivaName;
		AID = aID;
		this.totalUploaded = totalUploaded;
		this.totalDownloaded = totalDownloaded;
		this.sentMessages = sentMessages;
		this.receivedMessages = receivedMessages;
	}
	
	public String getDerivaName() {
		return derivaName;
	}
	public void setDerivaName(String derivaName) {
		this.derivaName = derivaName;
	}
	public String getAID() {
		return AID;
	}
	public void setAID(String aID) {
		AID = aID;
	}
	public int getTotalUploaded() {
		return totalUploaded;
	}
	public void setTotalUploaded(int totalUploaded) {
		this.totalUploaded = totalUploaded;
	}
	public int getTotalDownloaded() {
		return totalDownloaded;
	}
	public void setTotalDownloaded(int totalDownloaded) {
		this.totalDownloaded = totalDownloaded;
	}
	public int getSentMessages() {
		return sentMessages;
	}
	public void setSentMessages(int sentMessages) {
		this.sentMessages = sentMessages;
	}
	public int getReceivedMessages() {
		return receivedMessages;
	}
	public void setReceivedMessages(int receivedMessages) {
		this.receivedMessages = receivedMessages;
	}
}