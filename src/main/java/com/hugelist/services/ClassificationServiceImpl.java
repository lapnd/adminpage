package com.hugelist.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hugelist.dao.HugeListDao;
import com.hugelist.entities.Category;
import com.hugelist.entities.Classification;

public class ClassificationServiceImpl implements ClassificationService {
	
	private static final Logger log = LoggerFactory
			.getLogger(ClassificationServiceImpl.class);

	private HugeListDao hugeListDao;

	public ClassificationServiceImpl() {
	}
	
	public ClassificationServiceImpl(HugeListDao dao) {
		this.hugeListDao = dao;
	}

	public HugeListDao getHugeListDao() {
		return hugeListDao;
	}

	public void setHugeListDao(HugeListDao hugeListDao) {
		this.hugeListDao = hugeListDao;
	}

	@Override
	public void insert(Classification classification) {
		// TODO Auto-generated method stub
		hugeListDao.insert(classification);
		log.info("Classification {} information successfully inserted.",
				classification.getName());
		
	}

	@Override
	public void remove(Classification classification) {
		// TODO Auto-generated method stub
		hugeListDao.remove(classification);
		
	}

	@Override
	public void update(Classification classification) {
		// TODO Auto-generated method stub
		hugeListDao.update(classification);
	}

	@Override
	public Classification findById(Object id) {
		// TODO Auto-generated method stub
		return hugeListDao.findById(Classification.class, id);
	
	}

	@Override
	public List<Classification> findByName(String name) {
		String query = "Select a from " + Classification.class.getSimpleName()
				+ " a where a.name = " + name;
		List<Classification> listClassification = (List<Classification>) hugeListDao.findByQuery(query);
		
		return listClassification;
	}

	@Override
	public List<Classification> findAll() {
		String query = "Select a from " + Classification.class.getSimpleName()
				+ " a ";
		List<Classification> listClassification = (List<Classification>) hugeListDao.findByQuery(query);
		
		return listClassification;
	}

	
}
