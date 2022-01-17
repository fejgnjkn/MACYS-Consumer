package com.zensar.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ADDRESS")
public class AddressEntity {

	@Id
	@GeneratedValue
	public int id;
	public String line1;
	public String line2;
	public String line3;
	public String city;
	public String state;
	public int zipCode;
	public String countryCode;
	public int seperatorAddress0;
	
}
