package com.hugelist.services;

import java.util.List;

import com.hugelist.entities.Category;
import com.hugelist.entities.Classification;


public interface ClassificationService {
	
	void insert(Classification classification);
	void remove(Classification classification);
	void update(Classification classification);
	Classification findById(Object id);
	List<Classification> findByName(String name);
	List<Classification> findAll();


}
