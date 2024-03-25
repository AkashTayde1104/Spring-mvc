package com.tech.model;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class Address {
	
	private String city;
	
	private String district;
	
	private long pincode;

}
