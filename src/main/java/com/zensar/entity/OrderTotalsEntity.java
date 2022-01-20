package com.zensar.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ORDER_TOTALS")
public class OrderTotalsEntity implements Serializable{
	
	@Id
	@GeneratedValue
	public int id;
	public double totalPurchaseAmount;
	public int seperatorOrderTotals0;
}
