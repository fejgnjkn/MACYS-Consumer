package com.zensar.dto;

import java.io.Serializable;

public class Contact  implements Serializable{

	public int custID;
	public Name name;
	public Address address;
	public String daytimePhoneNbr;
	public String homePhoneNbr;
	public String alternatePhoneNbr;
	public boolean sendSMSMessage;
	public String emailAddress;
	public int seperatorContact0;
}
