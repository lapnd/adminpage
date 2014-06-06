package com.viosoft.hugelist;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import com.hugelist.dao.HugeListDao;
import com.hugelist.dao.HugeListDaoImpl;
import com.hugelist.entities.Manager;
import com.hugelist.services.ManagerService;
import com.hugelist.services.ManagerServiceImpl;


public class AccountTest {
	
	public static void main( String[] args)
    {
		addManager();
    }
	
	private static void addManager(){

		HugeListDao dao = new HugeListDaoImpl();
		
		ManagerService managerService = new ManagerServiceImpl(dao);
		@SuppressWarnings("unused")
		Set<String> deviceId = new HashSet<String>();
		for(int j = 0; j < 3; j ++){
			String devId = UUID.randomUUID().toString();
			deviceId.add(devId);	
		}
		
		String uuid = UUID.randomUUID().toString();
		
		Manager acc=new Manager();
		acc.setId(uuid);
		acc.setAid(uuid);
		acc.setUserName("admin");
		acc.setPass("123");
		acc.setIsAdmin(true);
	
		managerService.insert(acc);

		Manager accountdb = managerService.findById(uuid);
		System.out.println(accountdb.getUserName());
		
		List<Manager >accountdbl = managerService.findByName("admin*");
		for(Manager accl :accountdbl){
		System.out.println(accl.getUserName());
		}
	}
}
