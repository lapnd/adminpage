package com.hugelist.utils;

import java.util.Collection;
import java.util.List;
import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;

/**
 * 
 * Functions relative with json data
 *
 * @param <T>
 */
public class JSonUtil<T> {
	
	private Class<T> baseClass;
	
	public JSonUtil() {
	}

	public String toJson(Object obj) {
        return new JSONSerializer()
        .exclude("*.class").serialize(obj);
    }
    
    public String toJson(String[] fields, Object obj) {
        return new JSONSerializer()
        .include(fields).exclude("*.class").serialize(obj);
    }
    
    public T fromJsonToObject(String json) {
        return new JSONDeserializer<T>()
        .use(null, baseClass.getClass()).deserialize(json);
    }
    
    public String toJsonArray(Collection<T> collection) {
        return new JSONSerializer()
        .exclude("*.class").serialize(collection);
    }
    
    public String toJsonArray(Collection<T> collection, String[] fields) {
        return new JSONSerializer()
        .include(fields).exclude("*.class").serialize(collection);
    }
    
    public Collection<T> fromJsonArrayToObjects(String json) {
        return new JSONDeserializer<List<T>>()
        .use("values", baseClass.getClass()).deserialize(json);
    }
}
