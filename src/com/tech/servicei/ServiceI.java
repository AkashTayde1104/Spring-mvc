package com.tech.servicei;

import java.util.List;

import com.tech.model.Account;
import com.tech.model.Address;
import com.tech.model.Name;

public interface ServiceI {
	
	public String addAcc(Account acc,Name n, Address a); 
	
	public List<Account> getSingleAcc(String user, String pass);
	
	public Account getInfo(int accNum);
	
	public List<Account> balance_Enquiry(int accNum, int pin);
	
	public String changePass(int accNum,String pass);
	
	public Account deposit(int accNum, double amt);
	
	public Account transferMoney(int sender_AccNum, int reciver_AccNum,double receiver_amt);
	
	public Account withdrawMoney(int id, double user_Amount);
	
	public String pinChange(int accNum, int new_pin);
	

//	-----------Admin-----------
	
	public List<Account> getAllAcc();
	
//	public void deleteAcc(int accNum);
//	
//  public Account editAcc(int accNum);
//
//	public String updateAcc(Account acc);

	
}
