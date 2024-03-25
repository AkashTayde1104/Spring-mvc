package com.tech.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Transaction_History{
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int index;
	
	private int acc_Num;
	
	private String amount_Type;
	
	private double amount;
	
	private Date date;
	
	
	
	
	
	
	

}
