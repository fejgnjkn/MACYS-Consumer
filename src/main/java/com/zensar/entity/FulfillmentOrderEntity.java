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
@Table(name= "FULLFILLMENT_ORDER")
public class FulfillmentOrderEntity { 
	
	@Id
	@GeneratedValue
	public int id;
	public int orderID;
	public String orderTypeCode;
	public String partnerOrderID;
	public String orderStatus;
	public String fulfillmentChannelCode;
	public int orderStatusCode;
	public String orderStatusDescription;
	public int sellZLDivisionNbr;
	public int sellZLLocationNbr;
	@OneToOne(cascade={CascadeType.ALL},
			fetch=FetchType.LAZY)
	@JoinColumn(name="source_id")
	public SourceEntity source;
	@OneToOne(cascade={CascadeType.ALL},
			fetch=FetchType.LAZY)
	@JoinColumn(name="order_total_id")
	public OrderTotalsEntity orderTotals;
	@OneToOne(cascade={CascadeType.ALL},
			fetch=FetchType.LAZY)
	@JoinColumn(name="billig_address_id")
	public BillingAddressEntity billingAddressEntity;
	public String ns0;
	public String text;
	
	
	
	public FulfillmentOrderEntity() {
		super();
	}



	public FulfillmentOrderEntity(int orderID, String orderTypeCode, String partnerOrderID, String orderStatus,
			String fulfillmentChannelCode, int orderStatusCode, String orderStatusDescription, int sellZLDivisionNbr,
			int sellZLLocationNbr, SourceEntity source, OrderTotalsEntity orderTotals,
			BillingAddressEntity billingAddressEntity, String ns0, String text) {
		super();
		this.orderID = orderID;
		this.orderTypeCode = orderTypeCode;
		this.partnerOrderID = partnerOrderID;
		this.orderStatus = orderStatus;
		this.fulfillmentChannelCode = fulfillmentChannelCode;
		this.orderStatusCode = orderStatusCode;
		this.orderStatusDescription = orderStatusDescription;
		this.sellZLDivisionNbr = sellZLDivisionNbr;
		this.sellZLLocationNbr = sellZLLocationNbr;
		this.source = source;
		this.orderTotals = orderTotals;
		this.billingAddressEntity = billingAddressEntity;
		this.ns0 = ns0;
		this.text = text;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public int getOrderID() {
		return orderID;
	}



	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}



	public String getOrderTypeCode() {
		return orderTypeCode;
	}



	public void setOrderTypeCode(String orderTypeCode) {
		this.orderTypeCode = orderTypeCode;
	}



	public String getPartnerOrderID() {
		return partnerOrderID;
	}



	public void setPartnerOrderID(String partnerOrderID) {
		this.partnerOrderID = partnerOrderID;
	}



	public String getOrderStatus() {
		return orderStatus;
	}



	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}



	public String getFulfillmentChannelCode() {
		return fulfillmentChannelCode;
	}



	public void setFulfillmentChannelCode(String fulfillmentChannelCode) {
		this.fulfillmentChannelCode = fulfillmentChannelCode;
	}



	public int getOrderStatusCode() {
		return orderStatusCode;
	}



	public void setOrderStatusCode(int orderStatusCode) {
		this.orderStatusCode = orderStatusCode;
	}



	public String getOrderStatusDescription() {
		return orderStatusDescription;
	}



	public void setOrderStatusDescription(String orderStatusDescription) {
		this.orderStatusDescription = orderStatusDescription;
	}



	public int getSellZLDivisionNbr() {
		return sellZLDivisionNbr;
	}



	public void setSellZLDivisionNbr(int sellZLDivisionNbr) {
		this.sellZLDivisionNbr = sellZLDivisionNbr;
	}



	public int getSellZLLocationNbr() {
		return sellZLLocationNbr;
	}



	public void setSellZLLocationNbr(int sellZLLocationNbr) {
		this.sellZLLocationNbr = sellZLLocationNbr;
	}



	public SourceEntity getSource() {
		return source;
	}



	public void setSource(SourceEntity source) {
		this.source = source;
	}



	public OrderTotalsEntity getOrderTotals() {
		return orderTotals;
	}



	public void setOrderTotals(OrderTotalsEntity orderTotals) {
		this.orderTotals = orderTotals;
	}



	public BillingAddressEntity getBillingAddressEntity() {
		return billingAddressEntity;
	}



	public void setBillingAddressEntity(BillingAddressEntity billingAddressEntity) {
		this.billingAddressEntity = billingAddressEntity;
	}



	public String getNs0() {
		return ns0;
	}



	public void setNs0(String ns0) {
		this.ns0 = ns0;
	}



	public String getText() {
		return text;
	}



	public void setText(String text) {
		this.text = text;
	}
	
	
	
}

