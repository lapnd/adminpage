package com.hugelist.client.entities;

public class ClassItemValue2 implements java.io.Serializable {

	private int id;
	private String name;
	private String valueUnit;
	private int typeId;
	private int classId;
	private String value;
	
	public ClassItemValue2(String name, int typeId) {
		super();
		this.name = name;
		this.typeId = typeId;
	}
	public ClassItemValue2(String name, String valueUnit, int typeId) {
		super();
		this.name = name;
		this.valueUnit = valueUnit;
		this.typeId = typeId;
	}

	public ClassItemValue2(String name, int typeId, int classId) {
		super();
		this.name = name;
		this.typeId = typeId;
		this.classId = classId;
	}

	public ClassItemValue2(String name, String valueUnit, int typeId,
			int classId) {
		super();
		this.name = name;
		this.valueUnit = valueUnit;
		this.typeId = typeId;
		this.classId = classId;
	}



	public ClassItemValue2(int id, String name, String valueUnit, int typeId,
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
	public String getTypeName(){
		return ItemTypeEnum.getValue(typeId);
	}
}
