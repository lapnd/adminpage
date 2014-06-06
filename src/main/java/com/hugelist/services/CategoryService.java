package com.hugelist.services;

import java.util.List;

import com.hugelist.entities.Category;


public interface CategoryService {
	/*Services for Account*/
	void insert(Category category);
	void remove(Category category);
	void update(Category category);
	Category findById(Object id);
	List<Category> findByName(String name);
	List<Category> findAll();
	List<Category> findByManagerAID(String aid);

}
