package com.tech.modal;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Student {
	@Id
	private int s_Id;
	private String s_Name;
	private String addrs;
	private String user;
	private String pass;

}
