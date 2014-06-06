package com.hugelist.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.hugelist.dao.HugeListDao;
import com.hugelist.entities.Account;

@Service("accountService")
public class AccountServiceImpl implements AccountService {
	private static final Logger log = LoggerFactory
			.getLogger(AccountServiceImpl.class);

	HugeListDao hugeListDao;

	public HugeListDao getHugeListDao() {
		return hugeListDao;
	}

	public void setHugeListDao(HugeListDao hugeListDao) {
		this.hugeListDao = hugeListDao;
	}

	public AccountServiceImpl() {
	}

	public AccountServiceImpl(HugeListDao dao) {
		this.hugeListDao = dao;
	}

	@Override
	public void insert(Account account) {
		hugeListDao.insert(account);
		log.info("Account {} information successfully inserted.",
				account.getUserName());
	}

	@Override
	public void remove(Account account) {
		hugeListDao.remove(account);
		log.info("Account successfully removed");
	}

	@Override
	public void update(Account account) {
		hugeListDao.update(account);
		log.info("Account {} information successfully updated.",
				account.getUserName());
	}

	@Override
	public List<Account> findByName(String accountName) {
		String query = "Select a from " + Account.class.getSimpleName()
				+ " a where a.userName = " + accountName;
		List<Account> listAccount = (List<Account>) hugeListDao
				.findByQuery(query);

		return listAccount;
	}

	@Override
	public boolean authenticate(Account account, String password) {
		boolean success = false;
		if (account != null && (account.getPass().equals(password))) {
			log.info("Account {} successfully authenticated.",
					account.getUserName());
			success = true;
		} else {
			log.info("Account not authenticated, caused by either wrong userName or wrong password.");
		}
		return success;
	}

	@Override
	public Account findById(Object id) {
		log.info("Finding Account by id {} .", id);
		return hugeListDao.findById(Account.class, id);
	}

}
