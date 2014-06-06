package com.hugelist.services;

import java.util.List;

import com.hugelist.entities.Manager;


public interface ManagerService {

	void insert(Manager manager);
	void remove(Manager manager);
	void update(Manager manager);
	Manager findById(Object id);
	
	List<Manager> findAll();
	List<Manager> findByName(String accountName);
	boolean authenticate(Manager manager, String password);
}
