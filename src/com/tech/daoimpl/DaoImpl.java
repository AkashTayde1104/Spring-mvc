package com.tech.daoimpl;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tech.daoi.DaoI;
import com.tech.model.Account;
import com.tech.model.Address;
import com.tech.model.Name;
import com.tech.model.Transaction_History;

@Repository
public class DaoImpl implements DaoI {

//	Transaction_History tc=new Transaction_History();
//	Date thisdate = new Date();
//	
	@Autowired
	SessionFactory sf;

	
	@Override
	public String addAcc(Account acc, Name n, Address a) {
		Session session = sf.openSession();
       Transaction tx=session.beginTransaction();
       acc.setA_Name(n);//set secondary refences in model class/entity class
       acc.setA_Addrs(a);// same as above
       
//       tc.setAcc_Num(acc.getA_Num());
//       tc.setAmount(acc.getA_DepositMoney());
//       tc.setAmount_Type("Deposit");
//       tc.setDate(thisdate);
   
	    session.save(acc);//save entity class
		tx.commit();//commit for parmenent changes
		session.close();
		return "Registration Done Successfully";//return msg to console/ frontend through model Interface
	}


	//get singl account info using username and password
	@Override
	public List<Account> getSingleAcc(String user, String pass) {
		Session session = sf.openSession();
		Transaction tx=session.beginTransaction();
		Query q = session.createQuery("from Account where user=:u and pass=:p");
		q.setParameter("u", user);
		q.setParameter("p", pass);
		List list = q.list();
		
		return list;
	}
	
	//get acc data using accNum
	@Override
	public Account getInfo(int accNum) {
		Session session = sf.openSession();
		Transaction tx=session.beginTransaction();
		Account acc = session.get(Account.class, accNum);// get data of account
		session.close();
		return acc; //return to controller
	}
	
	//check balance
	@Override
	public List<Account> balance_Enquiry(int accNum, int pin) {
		Session session = sf.openSession();
		Transaction tx=session.beginTransaction();
		Query q = session.createQuery("from Account where a_Num=:a and pin=:p");
		q.setParameter("a", accNum);
		q.setParameter("p", pin);
		List list = q.list(); //get data of account using acnum and pin
		return list;
	}

	
	//forget pass
	@Override
	public String changePass(int accNum,String pass) {
		Session session = sf.openSession();
		Transaction tx=session.beginTransaction();
		Account acc = session.get(Account.class, accNum);//get accNum data
		acc.setPass(pass);//set new password
		tx.commit();   //comit chnges
		
		return "Pass Change Succcessfully";// pass msg to controller
		
		
	}
	

//	 withdrawl
	@Override
	public Account withdrawMoney(int acc_Num, double user_Amount) {
		Session session = sf.openSession();
		Transaction tx=session.beginTransaction();
		Account acc = session.get(Account.class, acc_Num);//get acc using accnum
		acc.setA_DepositMoney(acc.getA_DepositMoney()-user_Amount); //set new money(get previous amt - pass new amout)
		tx.commit();//make chnages

		Session session1 = sf.openSession();
		Transaction tx1=session1.beginTransaction();
		Account acc1 = session.get(Account.class, acc_Num);//and get acc with new changes
		
		return acc1;//return to controller
	}


	@Override
	public String pinChange(int accNum, int new_pin) {
       
		Session session = sf.openSession();
		Transaction tx=session.beginTransaction();
		Account acc = session.get(Account.class, accNum);
		acc.setPin(new_pin);//set new pin
        tx.commit();
		return "PIN Change Successfully";
	}


	@Override
	public Account deposit(int accNum, double amt) {
		
		Session session = sf.openSession();
		Transaction tx=session.beginTransaction();
		Account acc = session.get(Account.class, accNum);
		acc.setA_DepositMoney(acc.getA_DepositMoney()+amt);//add amound to existing amout and set to acc data
		tx.commit();//mak chnges parmenent
		session.close();
	
		return acc;
	}


	@Override
	public Account transferMoney(int sender_AccNum, int reciver_AccNum,double receiver_amt) {
		Session session = sf.openSession();
		Transaction tx=session.beginTransaction();
		
		Account acc = session.get(Account.class, sender_AccNum);
		acc.setA_DepositMoney(acc.getA_DepositMoney()-receiver_amt);//from sender account minu eneter money and update
		tx.commit();
		session.close();
		
		
		Session session1 = sf.openSession();
		Transaction tx1=session1.beginTransaction();
		Account acc2 = session1.get(Account.class, reciver_AccNum);
		acc2.setA_DepositMoney(acc2.getA_DepositMoney()+receiver_amt);//receiver acc add entered money and set updated money
		tx1.commit();
		session1.close();
		
		Session session2 = sf.openSession();
		Transaction tx2=session2.beginTransaction();
		Account acc1 = session2.get(Account.class, sender_AccNum);//get sender acc info
	
		return acc1;
			
	}



	
	
//	---------------Admin-----------------------------
	
	@Override
	public List<Account> getAllAcc() {
		
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		Query q = session.createQuery("from Account");//get acc details
		List accList = q.getResultList();
		return accList;
	}

//	@Override
//	public void deleteAcc(int accNum) {
//		Session session = sf.openSession();
//		Transaction tx=session.beginTransaction();
//		Account acc = session.get(Account.class, accNum);
//		session.delete(acc);
//		tx.commit();
//	}
//
//
//	@Override
//	public Account editAcc(int accNum) {
//		Session session = sf.openSession();
//		Transaction tx=session.beginTransaction();
//		Account acc = session.get(Account.class, accNum);
//		
//		return acc;
//	}
//
//
//	@Override
//	public String updateAcc(Account acc) {
//		Session session = sf.openSession();
//		Transaction tx=session.beginTransaction();
//		session.update(acc);
//		tx.commit();
//		return null;
//	}


	

	
	

}
