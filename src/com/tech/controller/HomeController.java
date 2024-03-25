package com.tech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tech.model.Account;
import com.tech.model.Address;
import com.tech.model.Name;
import com.tech.servicei.ServiceI;
import com.tech.utility.Global;

import sun.awt.ModalExclude;

@Controller
public class HomeController {
	@Autowired
	ServiceI si;

	//Registation method
	//Request param- read particular field from url
	//modelAttribut-read all field of model class through url\
	//model interface- transfer backend data to frontend view page uding addAttribute method
	
	@RequestMapping("/reg")
	public String SaveAcc(@RequestParam("name") String name,@ModelAttribute Account acc, @ModelAttribute Name n , @ModelAttribute Address a ,Model m)
	{
		
		String msg = si.addAcc(acc, n, a);//call add acc metod from serviceI and pass parameter in it and implements in serviceIml
		                                  //thorugh serviceImpl call daoi method and implements it in daoImpl to store data to db.
		System.out.println(msg);          // after store data method return somethig as per requirement i.e from daoImpl to ServiceImpl To Controller method
		                                  // and return to print to console or frontend through model I
		                                  // and goes to login paage
//		System.out.println(name);
//		return "login";
		
		if(name.equals("admin"))// if global name is admin execute this if condition to reg account through admin
		{
			List<Account> all = si.getAllAcc();   //call getallaccount detail method and all accounts  returned/stored in all reference
			
			m.addAttribute("data", all);          //all account details return to frontend using 'data' keyword..(this is user defined name/keyword) from "all"
			
			m.addAttribute("name", name);         //global name admin goes to fronteend using "name" i.e "${name}" and set global name hidden field of allData page
			return "allData";                     // return all data of accounts to "allData" page 	
		}
		
		else                                     //otherwise if global name is different from admin execute else part return to login page
		{
		m.addAttribute("name", Global.name);      //all backend data goes to front end using model Inteface method m.addattribute
		                                          // by default global name set welcome this name goes to fronteend using "name"
		return "login";                           // and goes to login page
		}
//		
		
		
	}
	
//	@RequestMapping("/admin_reg")
//	public String SaveAcc_Admin(@RequestParam("name") String name,@ModelAttribute Account acc, @ModelAttribute Name n , @ModelAttribute Address a ,Model m)
//	{
//		
//		String msg = si.addAcc(acc, n, a);
//		System.out.println(msg);
//		
//		List<Account> allAcc = si.getAllAcc();
//		
//		m.addAttribute("data", allAcc);
//		
//		
//		return "allData";
//	}

	//forget password
@RequestMapping("/forget")
public String forgetPass(@RequestParam("accNum")int accNum, @RequestParam("pass")String new_Pass,@RequestParam("new_pass")String confirm, Model m)
{
		String Msg=null;
		Account cust = si.getInfo(accNum);          //first get account data
		if(cust!=null)                              // if account data found i.e not null.. enter in loop
		{
			if(new_Pass.equals(confirm))            // check 2nd cond i.e check both password are equals which is entered if true enter in loop
			{
			Msg = si.changePass(accNum, new_Pass);  //call method changePass and pass accNum and new password in parameter and to serviceImpl and 
			                                        //call daoi method and through it pass to daaimpl and store changes in db and return msg in msg
			
			m.addAttribute("msg", Msg);             //pass this Msg to frontend i.e login using "msg" keyword as expression lang "${msg}"
			                                        // i.e pass keyword in expression "${......}" to access data frontend
			
			return "login";                         //return to login page for login with new password
			}
			else                                    // else if both passwot not equal then show msg to reenter password
			{
				
				Msg="Confirm Entered Password";
				m.addAttribute("msg", Msg);          //pass msg to return page i.e login
				
				return "login";                      
			}
		}
		else                                        // if account not found then execute this condition
		{
			Msg="Invalid Account";
			m.addAttribute("msg", Msg);
			
			return "login";
			
		}

		
}

//login method
@RequestMapping("/log")
public String allData(@RequestParam ("user") String user, @RequestParam ("pass") String pass, Model m)
{
//	if(user.equals("admin") && pass.equals("bn09"))
//	{
//	List<Account> AccList = si.getAllAcc();
//
//	m.addAttribute("data", AccList);
//	
//	return "allData";
//	}
//	
//	else 
		if(user.equals(user) && pass.equals(pass))
	{
		int a_Num=0;
		String a_Name=null;
		String acc_Type=null;
		double amount=0;
		
		
		
		List<Account> single = si.getSingleAcc(user, pass);//after enetering user and pass get account data using user and pass
		                                                   // and return acc data in single refernce
		
		for(Account s:single)                             // iterate data one by one  i.e set single ref data to s
		{
			a_Num=s.getA_Num();                      // and get particular fields and pass in local variable which is set null above
			a_Name=s.getA_Name().getF_Name();
			acc_Type=s.getAcc_Type();
			amount=s.getA_DepositMoney();
		}
		
//		m.addAttribute("data", single);
		
		if(single.isEmpty())                           //if list is emptyi.e no account foundthen  show error  msg
		{
			String msg="Invalid Username or Password";
			m.addAttribute("msg", msg);
			
			return "login";
		}
		else                                         // if account found all set fields goes to operation page i.e to frontend
		{
			m.addAttribute("a_Num", a_Num);          //"${a_Num}"
			m.addAttribute("a_Name", a_Name);        //${a_Name}"
			m.addAttribute("acc_Type", acc_Type);    //${acc_Type}"
			m.addAttribute("amount", amount);        //${amount}"  data set front end using this expression "${......."}"
			return "operation";
		}
		
//		return "operation";
	}
	return pass;
		
}

//get single account information
@RequestMapping("/info")
public String details(@RequestParam("a_Num")int accNum, Model m)
{
	Account info = si.getInfo(accNum);// call method to get singl acc info
	
	String a_Name=info.getA_Name().getF_Name()+" "+info.getA_Name().getM_Name()+" "+info.getA_Name().getL_Name();//store particular field in string
	String a_Addrs=info.getA_Addrs().getCity()+", "+info.getA_Addrs().getDistrict()+" - "+info.getA_Addrs().getPincode();
//	String name=info.getA_Name().getF_Name();
//	double amount=info.getA_DepositMoney();
	
	m.addAttribute("data", info); //data goes to frontend
	m.addAttribute("a_Name", a_Name);
	m.addAttribute("a_Addrs", a_Addrs);
//	m.addAttribute("name", name);
//	m.addAttribute("amount", amount);
	
	
	
	return "singleRecord";
	
	
}

//before balance enquiry all hiddenfields data get using url and pass to balance page
@RequestMapping("/before_balance")
public String Balance(@RequestParam("a_Num") int accNum,@RequestParam("a_Name")String a_Name, @RequestParam("a_DepositMoney")double amount, Model m)
{
//	Account info = si.getInfo(accNum);
//	
//	int a_Num=info.getA_Num();
//	String a_Name=info.getA_Name();
//	double amount = info.getA_DepositMoney();
	
	m.addAttribute("a_Num", accNum);
	m.addAttribute("a_Name", a_Name);
	m.addAttribute("amount", amount);
	
//	m.addAttribute("data", checkBal);
	
	return "balance";	
}

//check balance
@RequestMapping("/balance")
public String checkBalance(@RequestParam("a_Num") int accNum,@RequestParam("a_Name")String a_Name, @RequestParam("a_DepositMoney")double amount,@RequestParam("pin")int pin, Model m)
{
	String ope_Msg=null;
	double bal=0;
    List<Account> acc = si.balance_Enquiry(accNum, pin);// get accnum using hidden fields and pass accnum and pin in parameter in this method
    
	if(acc.isEmpty())                          // if acc not found
	{
		ope_Msg="Invalid password";          //show msg on operation page   
		m.addAttribute("ope_msg", ope_Msg);  // pass msg to frontend
		m.addAttribute("a_Num", accNum);     // pass acc num and amound to hidden field in frontend
		m.addAttribute("amount", amount);
		
		return "operation";
	}
	else
	{
		for(Account a:acc)    //if acc found iterate data and get amount  by calling method
		{
			bal = a.getA_DepositMoney();
		}
			ope_Msg = "Your account balance is "+bal;
			m.addAttribute("ope_msg", ope_Msg);
			m.addAttribute("a_Num", accNum);
			m.addAttribute("amount", bal);
			
			return "operation";
		
		
	}

}


//before withdraw  all hiddenfields data get using url and pass to withdraw page
@RequestMapping("/before_withdraw")
public String beforeWithdraw(@RequestParam("a_Num") int accNum,@RequestParam("a_Name")String a_Name ,@RequestParam("acc_Type")String acc_Type, @RequestParam("a_DepositMoney")double amount, Model m)
{
	m.addAttribute("a_Num", accNum);
	m.addAttribute("a_Name", a_Name);
	m.addAttribute("amount", amount);
	m.addAttribute("acc_Type", acc_Type);
	
	return "withdraw";
	
}

//withdrwa
@RequestMapping("/withdraw")
public String operWithdraw(@RequestParam("a_Num") int accNum,@RequestParam("a_Name")String a_Name, @RequestParam("amt")double old_Amount,@RequestParam("acc_Type")String acc_Type, @RequestParam("a_DepositMoney")double user_Amount ,@RequestParam("pin")int pin, Model m)
{
	String ope_Msg=null;
	
	if(acc_Type.equals("Savings"))// if saving account
	{
		if((old_Amount-user_Amount)>1000)// withdrwa money but min bal is 1000
		{
//			Account receiver = si.getInfo(reciver_AccNum);
//			if(receiver!=null)
//			{
				List<Account> cust = si.balance_Enquiry(accNum, pin); //first get acc
				if(cust.isEmpty())                                    //if not found acc
				{
					ope_Msg="Invalid Pin";
					m.addAttribute("a_Num", accNum);
					m.addAttribute("amount", old_Amount);
					m.addAttribute("acc_Type", acc_Type);
					m.addAttribute("ope_msg",ope_Msg);
					
					return "operation";
					
				}
				else                // if account found
				{
					Account acc = si.withdrawMoney(accNum, user_Amount); //call withdraw method add new amount
					
					double newAmount = acc.getA_DepositMoney();// get new amount with addition for set to hiddden fields
					
					ope_Msg= user_Amount+" Amount Debited Successfully";
					m.addAttribute("ope_msg", ope_Msg);
					m.addAttribute("a_Num", accNum);
					m.addAttribute("acc_type", acc_Type);
					m.addAttribute("amount", newAmount);
					
					return "operation";
					
				}
		}
		else
		{
			ope_Msg="You have reached your saving account limit"; // withdrwa maney with min bal giv msg
			m.addAttribute("a_Num", accNum);
			m.addAttribute("ope_msg", ope_Msg);
			m.addAttribute("amount", old_Amount);
			m.addAttribute("acc_Type", acc_Type);
			return "operation";
		}
	}
	else
	{
		if((old_Amount-user_Amount)>0)//if custom account with 0 balance
		{
//			Account receiver = si.getInfo(reciver_AccNum);
//			if(receiver!=null)
//			{
				List<Account> cust = si.balance_Enquiry(accNum, pin);
				if(cust.isEmpty())
				{
					ope_Msg="Invalid Pin";
					m.addAttribute("a_Num", accNum);
					m.addAttribute("amount", old_Amount);
					m.addAttribute("acc_Type", acc_Type);
					m.addAttribute("ope_msg",ope_Msg);
					
					return "operation";
					
				}
				else
				{
					Account acc = si.withdrawMoney(accNum, user_Amount);
					double newAmount = acc.getA_DepositMoney();
					
					ope_Msg= user_Amount+" Amount Debited Successfully";
					m.addAttribute("ope_msg", ope_Msg);
					m.addAttribute("a_Num", accNum);
					m.addAttribute("acc_type", acc_Type);
					m.addAttribute("amount", newAmount);
					
					return "operation";
					
				}
		}
		else
		{
			ope_Msg="You have reached your saving account limit";
			m.addAttribute("a_Num", accNum);
			m.addAttribute("ope_msg", ope_Msg);
			m.addAttribute("amount", old_Amount);
			m.addAttribute("acc_Type", acc_Type);
			return "operation";
		}
	}
}
			
//		}
//			
//		}
	
//	double dd=amount-1000;
//	
//	if(d>=dd)
//	{
//		ope_msg="You have reached your limit";
//		
//		m.addAttribute("ope_msg", ope_msg);
//		m.addAttribute("a_Num", accNum);
//		m.addAttribute("amount", amount);
//		
//		return "operation";
//	}
//	else if(d>=1 && d<=dd)
//	{
//		Account money = si.withdrawMoney(accNum, d);
//		double new_d = money.getA_DepositMoney();
//		
//		ope_msg= d +" Amount Debited Successfully /n Your Total Balance is " + new_d;
//		
//		m.addAttribute("ope_msg", ope_msg);
//		
//		return "operation";
//		
//		
//	}

//before deposit all hidden data get from operation page through url and pass to deposit page
@RequestMapping("/before_deposit")
public String beforeDeposit(@RequestParam("a_Num")int accNum, Model m)
{
	Account info = si.getInfo(accNum);
	int acc=info.getA_Num();
	double amount=info.getA_DepositMoney();
	String acc_Type = info.getAcc_Type();
	
	m.addAttribute("a_Num", acc);
	m.addAttribute("amount", amount);
	m.addAttribute("acc_Type", acc_Type);
	
	return "deposit";

}

//deposit money
@RequestMapping("/deposit")
public String deposit(@RequestParam("account_No")int accNum, @RequestParam("a_DepositMoney")double amt, @RequestParam("pin")int pin, Model m)
{
	String ope_Msg=null;
	List<Account> cust = si.balance_Enquiry(accNum, pin);//first get acc daya
	if(cust.isEmpty()) //if acc not found
	{
		ope_Msg="Invalid Pin";
		m.addAttribute("a_Num", accNum);
		m.addAttribute("amount", amt);
//		m.addAttribute("acc_Type", acc_Type);
		m.addAttribute("ope_msg",ope_Msg);
		
		return "operation";
	}
	else              // if acc found
	{
		Account deposit = si.deposit(accNum, amt);//call deposit method
		double added = deposit.getA_DepositMoney();
		String f_Name = deposit.getA_Name().getF_Name();
		String acc_Type = deposit.getAcc_Type();
		
		ope_Msg= amt+ " amount Credited in your account";
		m.addAttribute("ope_msg", ope_Msg);
		m.addAttribute("a_Num", accNum);
		m.addAttribute("a_Name", f_Name);
		m.addAttribute("acc_type", acc_Type);
		m.addAttribute("amount", added);
		
		return "operation";
		
	}
//	return "operation";
	
}

// before transaction 
@RequestMapping("before_transfer")
public String beforeTransfer(@RequestParam("a_Num")int accNum, Model m)
{
	Account info = si.getInfo(accNum);//get acc info
	
	int acc=info.getA_Num();//set  hidden feilds to transaction page
	double amount=info.getA_DepositMoney();
	String acc_Type = info.getAcc_Type();
	String f_Name = info.getA_Name().getF_Name();
	
	m.addAttribute("a_Num", acc);
	m.addAttribute("a_Name", f_Name);
	m.addAttribute("amount", amount);
	m.addAttribute("acc_Type", acc_Type);
	
	return "transaction";
}

//transaction
@RequestMapping("/transfer")
public String operTransaction(@RequestParam("account_No") int sender_AccNum,@RequestParam("a_Num")int reciver_AccNum,@RequestParam("acc_Type")String acc_Type, @RequestParam("amt")double sender_amt, @RequestParam("a_DepositMoney")double receiver_amt,@RequestParam("pin")int pin, Model m)
//public String operDeposit(@ModelAttribute Account accNum, @RequestParam("a_Num")int receiver_AccNum, @RequestParam("a_DepositMoney")double receiver_amt,@RequestParam("pin")int pin,Model m)
{
//	Account info = si.getInfo(sender_AccNum);
//	String type = info.getAcc_Type();
	String ope_Msg=null;
	
	if(acc_Type.equals(acc_Type))//if acctype=savimgns
	{
//		if(receiver_amt<(sender_amt-1000))
		if((sender_amt-receiver_amt)>1000)
		{
			Account receiver = si.getInfo(reciver_AccNum);//get reciever acc 
			if(receiver!=null)//if acc found
			{
				List<Account> sender = si.balance_Enquiry(sender_AccNum, pin);//get sender acc num
				if(sender.isEmpty())//if not found pin
				{
					ope_Msg="Invalid Pin";
					m.addAttribute("a_Num", sender_AccNum);
					m.addAttribute("amount", sender_amt);
					m.addAttribute("acc_Type", acc_Type);
					m.addAttribute("ope_msg",ope_Msg);
					
					return "operation";
					
				}
				else       //if pin is correct
				{
					Account acc = si.transferMoney(sender_AccNum, reciver_AccNum,receiver_amt);//call transfer method and return updated info in ref variable
					
					double newAmount = acc.getA_DepositMoney();//using ref get new set amount
					
					ope_Msg= receiver_amt+" Amount Transferred in  "+reciver_AccNum +" Account";
					m.addAttribute("ope_msg", ope_Msg);
					m.addAttribute("a_Num", sender_AccNum);
					m.addAttribute("acc_type", acc_Type);
					m.addAttribute("amount", newAmount);
					
					return "operation";
					
				}
			}
			else// if receiver acc not found
			{
				ope_Msg="Reciever account number not found";
				
				m.addAttribute("a_Num", sender_AccNum);
				m.addAttribute("amount", sender_amt);
				m.addAttribute("acc_Type", acc_Type);
				m.addAttribute("ope_msg",ope_Msg);
				
				return "operation";
				
			}
		}
		else//if reached greater han min bal=1000
		{
			ope_Msg="You have reached your saving account limit";
			
			m.addAttribute("a_Num", sender_AccNum);
			m.addAttribute("amount", sender_amt);
			m.addAttribute("acc_Type", acc_Type);
			m.addAttribute("ope_msg",ope_Msg);
			
			return "operation";
		}
	}
	else//if custom account
	{
//		if(receiver_amt>0)
		if((sender_amt-receiver_amt)>0)
		{
			Account receiver = si.getInfo(reciver_AccNum);
			if(receiver!=null)
			{
				List<Account> sender = si.balance_Enquiry(sender_AccNum, pin);
				if(sender.isEmpty())
				{
					ope_Msg="Invalid Pin";
					m.addAttribute("a_Num", sender_AccNum);
					m.addAttribute("amount", sender_amt);
					m.addAttribute("acc_Type", acc_Type);
					m.addAttribute("ope_msg",ope_Msg);
					
					return "operation";
					
				}
				else
				{
					Account acc = si.transferMoney(sender_AccNum, reciver_AccNum,receiver_amt);
					double newAmount = acc.getA_DepositMoney();
					
					ope_Msg= receiver_amt+" Amount Transferred in  "+reciver_AccNum +" Account";
					m.addAttribute("ope_msg", ope_Msg);
					m.addAttribute("a_Num", sender_AccNum);
					m.addAttribute("acc_type", acc_Type);
					m.addAttribute("amount", newAmount);
					
					return "operation";
					
				}
			}
			else
			{
				ope_Msg="Reciever account number not found";
				
				m.addAttribute("a_Num", sender_AccNum);
				m.addAttribute("amount", sender_amt);
				m.addAttribute("acc_Type", acc_Type);
				m.addAttribute("ope_msg",ope_Msg);
				
				return "operation";
			}
	}
		else
		{
			ope_Msg="You have reached your account limit";
			
			m.addAttribute("a_Num", sender_AccNum);
			m.addAttribute("amount", sender_amt);
			m.addAttribute("acc_Type", acc_Type);
			m.addAttribute("ope_msg",ope_Msg);
			
			return "operation";
		}
	}
			
}

//before pin change
@RequestMapping("/before_pin")
public String beforePinchange(@RequestParam("a_Num")int accNum,@RequestParam("a_DepositMoney")double amt,@RequestParam("acc_Type")String acc_Type, Model m)
{
	m.addAttribute("a_Num", accNum);
	m.addAttribute("amount", amt);
	m.addAttribute("acc_Type", acc_Type);
	
	return "pin_change";
	
}

@RequestMapping("/pin")
public String pinChange(@RequestParam("a_Num")int accNum, @RequestParam("old")int old_pin, @RequestParam("new")int new_pin, @RequestParam("confirm")int confirm_pin,@RequestParam("acc_Type")String acc_Type, @RequestParam("a_DepositMoney")double amt,Model m)
{
	String ope_Msg=null;
	
	List<Account> pin = si.balance_Enquiry(accNum, old_pin);//get acc info nd check pin
	if(pin.isEmpty()) //if ppin not found
	{
		ope_Msg="Invalid old PIN";
		m.addAttribute("a_Num", accNum);
		m.addAttribute("amount", amt);
		m.addAttribute("acc_Type", acc_Type);
		m.addAttribute("ope_msg",ope_Msg);
		
		return "operation";
	}
	else//if found old pin
	{
		if(new_pin==confirm_pin)//set new ppin
		{
			ope_Msg= si.pinChange(accNum, new_pin);
			m.addAttribute("a_Num", accNum);
			m.addAttribute("amount", amt);
			m.addAttribute("acc_Type", acc_Type);
			m.addAttribute("ope_msg",ope_Msg);

			return "operation";
		}
		else
		{
			ope_Msg=" Confirm entered PIN";//if new pin and confirm pin not equal
			m.addAttribute("a_Num", accNum);
			m.addAttribute("amount", amt);
			m.addAttribute("acc_Type", acc_Type);
			m.addAttribute("ope_msg",ope_Msg);
			
			return "operation";
		}
	}
	
}

//-------------------Admin-----------------------

//@RequestMapping("/delete")
//public String delete(@RequestParam("rd")int accNum, Model m)
//{
//	si.deleteAcc(accNum);
//	
//	List<Account> all = si.getAllAcc();
//	m.addAttribute("data", all);
//	return "allData";
//	
//}
//
//@RequestMapping("/edit")
//public String edit(@RequestParam("rd") int accNum, Model m)
//{
//	Account editAcc = si.editAcc(accNum);
//	
//	m.addAttribute("data", editAcc);
//	return "update";
//}
//
//@RequestMapping("/update")
//public String update(@ModelAttribute Account acc, Model m)
//{
//	si.updateAcc(acc);
//	
//	List<Account> all = si.getAllAcc();
//	
//	m.addAttribute("data", all);
//	return "allData";	
//}




}
