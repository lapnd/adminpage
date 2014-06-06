package com.hugelist.client.entities;

public enum CampaignTypeEnum {
	SELL(1),
	BUY(2),
	SWAP(3);

	private final int id;

	private CampaignTypeEnum(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}
}