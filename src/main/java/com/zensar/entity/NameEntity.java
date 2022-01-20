package com.zensar.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "NAME")
public class NameEntity implements Serializable{
	
	@Id
	@GeneratedValue
	public int id;
	public String firstName;
	public String lastName;
	public int seperatorName0;
	public int seperatorName1;
}
