package com.zensar.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ORDER_TOTALS")
public class OrderTotalsEntity {
	
	@Id
	@GeneratedValue
	public int id;
	public double totalPurchaseAmount;
	public int seperatorOrderTotals0;
}
