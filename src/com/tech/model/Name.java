package com.tech.model;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class Name {
	
	private String f_Name;
	
	private String m_Name;
	
	private String l_Name;
	
	

}
