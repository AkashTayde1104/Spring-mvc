package com.tech.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tech.daoi.Admin_DaoI;
import com.tech.model.Account;
import com.tech.model.Address;
import com.tech.model.Name;
import com.tech.servicei.Admin_serviceI;

@Service
public class Admin_ServiceImpl implements Admin_serviceI {
	
	@Autowired
	Admin_DaoI di;

//	@Override
//	public String addAcc(Account acc, Name n, Address a) {
//	
//		return di.addAcc(acc, n, a);
//	}
//
	@Override
	public List<Account> getAllAcc() {
	
		return di.getAllAcc();
	}

	@Override
	public void deleteAcc(int accNum) {
		di.deleteAcc(accNum);
		
	}

	@Override
	public Account editAcc(int accNum) {
		
		return di.editAcc(accNum);
	}

	@Override
	public String updateAcc(Account acc, Name n, Address a) {
		
		return di.updateAcc(acc,n,a);
	}
	
	
	
	
	
	
	
}
