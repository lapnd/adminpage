package com.hugelist.client.entities;

public class ClassItemWValue implements java.io.Serializable {

	private int id;
	private String name;
	private String valueUnit;
	private int typeId;
	private int classId;
	private String value;/*other search string also*/
	private int minSearch;
	private int maxSearch;
	
	public ClassItemWValue(String name, String valueUnit, int typeId) {
		super();
		this.name = name;
		this.valueUnit = valueUnit;
		this.typeId = typeId;
	}
	
	public ClassItemWValue(int id, int typeId) {
		super();
		this.id = id;
		this.typeId = typeId;
	}

	public ClassItemWValue(int id, int typeId, String value) {
		super();
		this.id = id;
		this.typeId = typeId;
		this.value = value;
	}

	public ClassItemWValue(int id, int typeId, int minSearch, int maxSearch) {
		super();
		this.id = id;
		this.typeId = typeId;
		this.minSearch = minSearch;
		this.maxSearch = maxSearch;
	}

	public ClassItemWValue(int id, String name, String valueUnit, int typeId,
			int classId, String value) {
		super();
		this.id = id;
		this.name = name;
		this.valueUnit = valueUnit;
		this.typeId = typeId;
		this.classId = classId;
		this.value = value;
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
	public String getValueUnit() {
		return valueUnit;
	}
	public void setValueUnit(String valueUnit) {
		this.valueUnit = valueUnit;
	}
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}

	public int getMinSearch() {
		return minSearch;
	}

	public void setMinSearch(int minSearch) {
		this.minSearch = minSearch;
	}

	public int getMaxSearch() {
		return maxSearch;
	}

	public void setMaxSearch(int maxSearch) {
		this.maxSearch = maxSearch;
	}
	public String getTypeName(){
		return ItemTypeEnum.getValue(typeId);
	}
}
