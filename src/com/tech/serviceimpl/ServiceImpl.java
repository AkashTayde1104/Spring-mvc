package com.tech.serviceimpl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tech.daoi.DaoI;
import com.tech.model.Account;
import com.tech.model.Address;
import com.tech.model.Name;
import com.tech.servicei.ServiceI;

@Service
public class ServiceImpl implements ServiceI {
@Autowired
DaoI di;

  @Override
   public String addAcc(Account acc, Name n, Address a) {
	
	return di.addAcc(acc, n, a);
  }

	@Override
	public List<Account> getSingleAcc(String user, String pass) {
		
		return di.getSingleAcc(user, pass);
	}
	
	@Override
	public Account getInfo(int accNum) {
		
		return di.getInfo(accNum);
	}
	
	@Override
	public List<Account> balance_Enquiry(int accNum, int pin) {
		
		return di.balance_Enquiry(accNum, pin);
	}

	@Override
	public String changePass(int accNum,String pass) {
		
		return di.changePass(accNum, pass);
	}
	
	@Override
	public Account deposit(int accNum, double amt) {
	
		return di.deposit(accNum, amt);
	}

	@Override
	public Account transferMoney(int sender_AccNum, int reciver_AccNum,double receiver_amt) {
		
		
		return di.transferMoney(sender_AccNum, reciver_AccNum, receiver_amt);
		
	}

	@Override
	public Account withdrawMoney(int id, double user_Amount) {
		
		return di.withdrawMoney(id, user_Amount);
	}

	@Override
	public String pinChange(int accNum, int new_pin) {
		
		
		return di.pinChange(accNum, new_pin);
	}

	

	
//	----------Admin------------
	
	@Override
	public List<Account> getAllAcc() {
	
		return di.getAllAcc();
	}
	
//	@Override
//	public void deleteAcc(int accNum) {
//		di.deleteAcc(accNum);
//		
//	}
//
//	@Override
//	public Account editAcc(int accNum) {
//		
//		return di.editAcc(accNum);
//	}
//
//	@Override
//	public String updateAcc(Account acc) {
//		
//		return di.updateAcc(acc);
//	}

}
