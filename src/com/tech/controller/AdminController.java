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
import com.tech.servicei.Admin_serviceI;
import com.tech.utility.Global;


@Controller
public class AdminController {
	
	
	@Autowired
	Admin_serviceI si;
	
	@RequestMapping("/admin_log")
	public String allData(@RequestParam ("user") String user, @RequestParam ("pass") String pass, Model m)
	{
		if(user.equals("admin") && pass.equals("bn09"))      //id admin username get all customer accounts
		{
//			String cust_Name=null;
//			String address=null;
		List<Account> all = si.getAllAcc();                 //call method to get all record and display on frontend 

		m.addAttribute("data", all);
		
		Global.name="admin";                              //set global name admin
		m.addAttribute("name", Global.name);             //pass to alldata page to set hidden feild of global name
		
		return "allData";
		}
		else//else not correct user pass
		{
			String msg="Invalid Username or Password";
			
			m.addAttribute("msg", msg);
			return "admin_login";
		}
		
			
	}
	
	//delete data ...
	@RequestMapping("/delete")
	public String delete(@RequestParam("rd")int accNum, @RequestParam("name")String name, Model m)
	{
		si.deleteAcc(accNum);                      // delect selected acc num which is mention as rd
		
		List<Account> all = si.getAllAcc();       //get all data with deletion
		m.addAttribute("data", all);
		m.addAttribute("name", name);
		return "allData";                         // pass data to alData page
		
	}
	
	//for update first we need to take acc data 
	@RequestMapping("/edit")
	public String edit(@RequestParam("rd") int accNum,@RequestParam("name")String name, Model m)
	{
		Account editAcc = si.editAcc(accNum);         //take acc data using this method
		
		m.addAttribute("data", editAcc);             //pass data to update page
		m.addAttribute("name", name);
		return "update";
	}
	
	
	//after getting acc data on updat page makes changes and save tis chnges
	@RequestMapping("/update")
	public String update(@ModelAttribute Account acc,@ModelAttribute Name n, @ModelAttribute Address a,@RequestParam("name")String name, Model m)
	{
		si.updateAcc(acc,n,a);                 //save updated chnges incuding secondary refernce class
		
		List<Account> all = si.getAllAcc();   // get accnum dattta on with updation
		
		
		m.addAttribute("data", all);          //and show on allData pages 
		m.addAttribute("name", name);         //pass global name as admin also to that page
		
		return "allData";	
	}
	
	//first hidden gloabal feild get and pass to registration page at global feild and sent globl name as a "admin";
	@RequestMapping("/add_cust")
	public String add_cust(@RequestParam("name")String name,Model m)
	{
		
		m.addAttribute("name", name);
		return "registration";              //go to registration page
		
	}
	
	@RequestMapping("/logout")
	public String logout()
	{
		Global.name="welcome";            //after logoud set global name as a welcome 
		return "index";                   //return to index
		
	}
	

}
