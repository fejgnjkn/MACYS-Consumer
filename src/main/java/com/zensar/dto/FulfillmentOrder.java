package com.zensar.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class FulfillmentOrder implements Serializable{ 
	public int orderID;
	public String orderTypeCode;
	public String partnerOrderID;
	public String orderStatus;
	public String fulfillmentChannelCode;
	public int orderStatusCode;
	public String orderStatusDescription;
	public int sellZLDivisionNbr;
	public int sellZLLocationNbr;
	public Source source;
	public OrderTotals orderTotals;
	public BillingAddress billingAddress;
	public String ns0;
	public String text;
}

