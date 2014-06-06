package com.hugelist.client.entities;

import java.util.List;



import flexjson.JSONException;
import net.sf.json.JSONObject;

public class WSResult<T> implements java.io.Serializable {
	
	//Return code
	public static String INVALID_JSON="INVALID_JSON";
	public static String INVALID_TOKEN="INVALID_TOKEN";
	public static String NOT_FOUND="NOT_FOUND";
	public static String OK="OK";
	public static String NG="NG";
	public static String EXITSTED="EXITSTED";
	public static String EXPIRED="EXPIRED";
	public static String INVALID_NAME="INVALID_NAME";
	public static String INVALID_PASSWORD="INVALID_PASSWORD";
	public static String NOT_MATCH="NOT_MATCH";
	public static String INVALID_CK="INVALID_CK";
	public static String INVALID_CAM="INVALID_CAM";
	
	private static final long serialVersionUID = 3L;
	private String code;
	private String value;
	private List<T> baseClass;

	public WSResult(String code, String value, List<T> baseClass) {
		super();
		this.code = code;
		this.value = value;
		this.baseClass = baseClass;
	}

	public WSResult() {
		super();
	}

	public WSResult(String code, String value) {
		super();
		this.code = code;
		this.value = value;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public List<T> getBaseClass() {
		return baseClass;
	}

	public void setBaseClass(List<T> baseClass) {
		this.baseClass = baseClass;
	}

	@Override
	public String toString() {
		try {
			JSONObject jsonObj = new JSONObject();
			jsonObj.put("code", code);
			jsonObj.put("value", value);
			jsonObj.put("baseClass", baseClass);
			return jsonObj.toString();
		} catch (JSONException e) {
			throw new RuntimeException(
					"failed to construct JSONObject for toString", e);
		}
	}
}
