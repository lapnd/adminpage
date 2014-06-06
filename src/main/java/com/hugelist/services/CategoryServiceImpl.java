package com.hugelist.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hugelist.dao.HugeListDao;
import com.hugelist.entities.Category;


public class CategoryServiceImpl implements CategoryService {
	private static final Logger log = LoggerFactory
			.getLogger(CategoryServiceImpl.class);

	private HugeListDao hugeListDao;

	public CategoryServiceImpl() {
	}
	
	public CategoryServiceImpl(HugeListDao dao) {
		this.hugeListDao = dao;
	}

	public HugeListDao getHugeListDao() {
		return hugeListDao;
	}

	public void setHugeListDao(HugeListDao hugeListDao) {
		this.hugeListDao = hugeListDao;
	}

	@Override
	public void insert(Category category) {
		// TODO Auto-generated method stub
		hugeListDao.insert(category);
		log.info("Category {} information successfully inserted.",
				category.getName());
	}

	@Override
	public void remove(Category category) {

		// TODO Auto-generated method stub
		hugeListDao.remove(category);
/*
		List<Ca> listCampaigns = findCampaignByAccountId(account.getAid());
		for (Campaign campaign : listCampaigns) {
			if (campaign != null) {
				dao.remove(campaign);
			}
		}

		log.info("Account successfully removed");
*/
	}

	@Override
	public void update(Category category) {
		// TODO Auto-generated method stub
		hugeListDao.update(category);
		log.info("Category {} information successfully updated.",
				category.getName());
	}

	@Override
	public Category findById(Object id) {
		// TODO Auto-generated method stub
		log.info("Finding Category by id {} .", id);
		return hugeListDao.findById(Category.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> findByName(String name) {
		// TODO Auto-generated method stub
		
		String query = "Select a from " + Category.class.getSimpleName()
				+ " a where a.name = " + name;
		List<Category> listCategory = (List<Category>) hugeListDao.findByQuery(query);
		
		return listCategory;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Category> findByManagerAID(String aid){
		
		String query = "Select a from " + Category.class.getSimpleName()
				+ " a where a.accountId = " + aid;
		List<Category> listCategory = (List<Category>) hugeListDao.findByQuery(query);
		
		return listCategory;
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> findAll() {
		// TODO Auto-generated method stub
		String query = "Select a from " + Category.class.getSimpleName() + " a";
				
		List<Category> listCategory = (List<Category>) hugeListDao.findByQuery(query);
		
		return listCategory;
	}

	

}
