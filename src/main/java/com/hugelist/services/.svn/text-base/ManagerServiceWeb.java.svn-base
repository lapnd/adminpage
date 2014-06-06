package com.hugelist.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.hugelist.client.entities.WManager;
import com.hugelist.entities.Category;
import com.hugelist.entities.Manager;

public class ManagerServiceWeb {

	@SuppressWarnings("deprecation")
	XmlBeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("SpringConfig.xml"));
	ManagerService managerService = (ManagerService) beanFactory.getBean("managerService");
	CategoryService categoryService = (CategoryService)beanFactory.getBean("categoryService");
	
	private static ManagerServiceWeb serviceClient;

	private ManagerServiceWeb(){
	}

	public static ManagerServiceWeb getInstance(){
		if(serviceClient==null)
			serviceClient = new ManagerServiceWeb();
		return serviceClient;
	}
	
	public List<Category> getCategoriesByAID(String aid, String token){
		
		Manager account = managerService.findById(aid);

		if (account == null || !account.getToken().equals(token)) 
			return null;

		List<Category> categories;
		
		if(account.getIsAdmin())
			categories = categoryService.findAll();
		else
			categories = categoryService.findByManagerAID(aid);
		
		return categories;
	}
	
	public List<WManager> getManagerWithGroup(String aid, String token){
		
		Manager account = managerService.findById(aid);

		if (account == null || !account.getToken().equals(token) || !account.getIsAdmin())
			return null;
		
		List<WManager> wmanagers = new ArrayList<WManager>();
		List<Category> categories = new ArrayList<Category>();
		List<Manager> managers = managerService.findAll();
		
		for (int i = 0; i < managers.size(); i++) {
			categories = categoryService.findByManagerAID(managers.get(i).getAid());
			wmanagers.add(new WManager(managers.get(i), categories));
		}
		
		return wmanagers;
	}
}
