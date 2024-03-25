package com.tech.daoi;

import java.util.List;

import com.tech.model.Account;
import com.tech.model.Address;
import com.tech.model.Name;

public interface Admin_DaoI {
	
//    public String addAcc(Account acc,Name n, Address a); 
//	
	public List<Account> getAllAcc();
	
    public void deleteAcc(int accNum);
	
    public Account editAcc(int accNum);
	
    public String updateAcc(Account acc, Name n, Address a);


}
