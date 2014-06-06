package com.hugelist.client.entities;

import java.util.List;

public class Classification2 implements java.io.Serializable {

	private int id;
	private String name;
	private int groupId;
	private int groupVer;
	private List<ClassItemWValue> items;

	public Classification2(String name, int groupId, int groupVer) {
		super();
		this.name = name;
		this.groupId = groupId;
		this.groupVer = groupVer;
	}
	
	public Classification2(String name, int groupId) {
		super();
		this.name = name;
		this.groupId = groupId;
	}
	
	public Classification2(String name, int groupId, List<ClassItemWValue> items) {
		super();
		this.name = name;
		this.groupId = groupId;
		this.items = items;
	}

	public Classification2(int id, String name, int groupId,
			List<ClassItemWValue> items) {
		super();
		this.id = id;
		this.name = name;
		this.groupId = groupId;
		this.items = items;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	public List<ClassItemWValue> getItems() {
		return items;
	}
	public void setItems(List<ClassItemWValue> items) {
		this.items = items;
	}
	
	public int getGroupVer() {
		return groupVer;
	}

	public void setGroupVer(int groupVer) {
		this.groupVer = groupVer;
	}
}
