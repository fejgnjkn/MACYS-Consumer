package com.zensar.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SOURCE")
public class SourceEntity implements Serializable {
	
	@Id
	@GeneratedValue
	public int id;
	public String clientID;
	public String subClientID;
	public String sellingChannelCode;
	public int seperatorSource0;
	public int separatorSource1;
}
