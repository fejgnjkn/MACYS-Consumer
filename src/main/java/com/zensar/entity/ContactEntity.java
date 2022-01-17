package com.zensar.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CONTACT")
public class ContactEntity {

	@Id
	@GeneratedValue
	public int id;
	public int custID;
	@OneToOne(cascade={CascadeType.ALL},
			fetch=FetchType.LAZY)
	@JoinColumn(name="name_id")
	public NameEntity name;
	@OneToOne(cascade={CascadeType.ALL},
			fetch=FetchType.LAZY)
	@JoinColumn(name="address_id")
	public AddressEntity addressEntity;
	public String daytimePhoneNbr;
	public String homePhoneNbr;
	public String alternatePhoneNbr;
	public boolean sendSMSMessage;
	public String emailAddress;
	public int seperatorContact0;
}
