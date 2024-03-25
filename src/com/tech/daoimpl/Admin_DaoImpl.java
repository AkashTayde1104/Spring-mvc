package com.tech.daoimpl;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tech.daoi.Admin_DaoI;
import com.tech.model.Account;
import com.tech.model.Address;
import com.tech.model.Name;

@Repository
public class Admin_DaoImpl implements Admin_DaoI {
	
	@Autowired
	SessionFactory sf;
	
	@Override
	public List<Account> getAllAcc() {
		
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		Query q = session.createQuery("from Account");
		List accList = q.getResultList();
		return accList;
	}

	@Override
	public void deleteAcc(int accNum) {
		Session session = sf.openSession();
		Transaction tx=session.beginTransaction();
		Account acc = session.get(Account.class, accNum);
		session.delete(acc);
		tx.commit();
	}


	@Override
	public Account editAcc(int accNum) {
		Session session = sf.openSession();
		Transaction tx=session.beginTransaction();
		Account acc = session.get(Account.class, accNum);
		
		return acc;
	}


	@Override
	public String updateAcc(Account acc, Name n, Address a) {
		Session session = sf.openSession();
		Transaction tx=session.beginTransaction();
		acc.setA_Name(n);
		acc.setA_Addrs(a);
		session.update(acc);
		tx.commit();
		return null;
	}

	


}
