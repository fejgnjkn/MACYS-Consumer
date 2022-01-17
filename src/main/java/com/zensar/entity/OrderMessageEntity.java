package com.zensar.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ORDER_MESSAGES")
public class OrderMessageEntity {
	
	@Id
	@GeneratedValue
	private int id;
	private String messageName;
    private String command;
    private String itemName;
    private String itemDescription;
    private double itemLength;
    private double itemWidth;
    private double itemHeight;
    private double itemWeight;
    private String imagePathname;
    private String rfidTagged;
    private int storageAttribute;
    private String pickType;
    
    
    
	public OrderMessageEntity() {
		super();
	}



	public OrderMessageEntity(String messageName, String command, String itemName, String itemDescription,
			double itemLength, double itemWidth, double itemHeight, double itemWeight, String imagePathname,
			String rfidTagged, int storageAttribute, String pickType) {
		super();
		this.messageName = messageName;
		this.command = command;
		this.itemName = itemName;
		this.itemDescription = itemDescription;
		this.itemLength = itemLength;
		this.itemWidth = itemWidth;
		this.itemHeight = itemHeight;
		this.itemWeight = itemWeight;
		this.imagePathname = imagePathname;
		this.rfidTagged = rfidTagged;
		this.storageAttribute = storageAttribute;
		this.pickType = pickType;
	}



	public OrderMessageEntity(Integer id, String messageName, String command, String itemName, String itemDescription,
			Double itemLength, Double itemWidth, Double itemHeight, Double itemWeight, String imagePathname,
			String rfidTagged, Integer storageAttribute, String pickType) {
		super();
		this.id = id;
		this.messageName = messageName;
		this.command = command;
		this.itemName = itemName;
		this.itemDescription = itemDescription;
		this.itemLength = itemLength;
		this.itemWidth = itemWidth;
		this.itemHeight = itemHeight;
		this.itemWeight = itemWeight;
		this.imagePathname = imagePathname;
		this.rfidTagged = rfidTagged;
		this.storageAttribute = storageAttribute;
		this.pickType = pickType;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getMessageName() {
		return messageName;
	}



	public void setMessageName(String messageName) {
		this.messageName = messageName;
	}



	public String getCommand() {
		return command;
	}



	public void setCommand(String command) {
		this.command = command;
	}



	public String getItemName() {
		return itemName;
	}



	public void setItemName(String itemName) {
		this.itemName = itemName;
	}



	public String getItemDescription() {
		return itemDescription;
	}



	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}



	public Double getItemLength() {
		return itemLength;
	}



	public void setItemLength(Double itemLength) {
		this.itemLength = itemLength;
	}



	public Double getItemWidth() {
		return itemWidth;
	}



	public void setItemWidth(Double itemWidth) {
		this.itemWidth = itemWidth;
	}



	public Double getItemHeight() {
		return itemHeight;
	}



	public void setItemHeight(Double itemHeight) {
		this.itemHeight = itemHeight;
	}



	public Double getItemWeight() {
		return itemWeight;
	}



	public void setItemWeight(Double itemWeight) {
		this.itemWeight = itemWeight;
	}



	public String getImagePathname() {
		return imagePathname;
	}



	public void setImagePathname(String imagePathname) {
		this.imagePathname = imagePathname;
	}



	public String getRfidTagged() {
		return rfidTagged;
	}



	public void setRfidTagged(String rfidTagged) {
		this.rfidTagged = rfidTagged;
	}



	public Integer getStorageAttribute() {
		return storageAttribute;
	}



	public void setStorageAttribute(Integer storageAttribute) {
		this.storageAttribute = storageAttribute;
	}



	public String getPickType() {
		return pickType;
	}



	public void setPickType(String pickType) {
		this.pickType = pickType;
	}



	@Override
	public String toString() {
		return "OrderMessageEntity [id=" + id + ", messageName=" + messageName + ", command=" + command + ", itemName="
				+ itemName + ", itemDescription=" + itemDescription + ", itemLength=" + itemLength + ", itemWidth="
				+ itemWidth + ", itemHeight=" + itemHeight + ", itemWeight=" + itemWeight + ", imagePathname="
				+ imagePathname + ", rfidTagged=" + rfidTagged + ", storageAttribute=" + storageAttribute
				+ ", pickType=" + pickType + "]";
	}
	
	
    
    

}
