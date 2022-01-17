package com.zensar.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "NAME")
public class NameEntity {
	
	@Id
	@GeneratedValue
	public int id;
	public String firstName;
	public String lastName;
	public int seperatorName0;
	public int seperatorName1;
}
