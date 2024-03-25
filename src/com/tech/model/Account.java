package com.tech.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Data;
@Data
@Entity
public class Account {
	
	private String acc_Type;
	
	@Id
	private int a_Num;
	
	@Autowired
	private Name a_Name;
	
	@Autowired
	private Address a_Addrs;
	
	private long adhar_Num;
	
	private String pan_Num;
	
	private String birth_Date;
	
	private String a_Mob_No;
	
	private double a_DepositMoney;
	
	private int pin;
	
	private String user;
	
	private String pass;
	
	
//	@OneToMany(cascade = CascadeType.ALL)
//	public List<Transaction_History> transaction;
//	
	

}
