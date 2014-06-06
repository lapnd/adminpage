package com.hugelist.client.entities;

public enum ItemTypeEnum {
	CHECKBOX(1, "Check box"),
	RADIO(2, "Radio"),
	VALUE(3, "Value"),
	OTHER(4, "Other"),
	DESCRIPTION(5, "Description");

	private final int id;
	private final String value;

	private ItemTypeEnum(int id, String value){
		this.id = id;
		this.value = value;
	}

	public int getId(){
		return id;
	}

	public String getValue() {
		return value;
	}
	public static String getValue(int id){
		for (ItemTypeEnum i : values()){
			if (i.getId() == id)
				return i.getValue();
		}
		return null;
	}
}