
package com.zensar.dto;

import java.io.Serializable;
import java.util.List;

public class OrderMessage implements Serializable{

    private String messageName;
    private String command;
    private String itemName;
    private String itemDescription;
    private Double itemLength;
    private Double itemWidth;
    private Double itemHeight;
    private Double itemWeight;
    private String imagePathname;
    private String rfidTagged;
    private Integer storageAttribute;
    private String pickType;
    private List<String> upcList;
    
    

    public OrderMessage() {
		super();
	}

	public OrderMessage(String messageName, String command, String itemName, String itemDescription, Double itemLength,
			Double itemWidth, Double itemHeight, Double itemWeight, String imagePathname, String rfidTagged,
			Integer storageAttribute, String pickType, List<String> upcList) {
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
		this.upcList = upcList;
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

    public List<String> getUpcList() {
        return upcList;
    }

    public void setUpcList(List<String> upcList) {
        this.upcList = upcList;
    }

	@Override
	public String toString() {
		return "OrderMessage [messageName=" + messageName + ", command=" + command + ", itemName=" + itemName
				+ ", itemDescription=" + itemDescription + ", itemLength=" + itemLength + ", itemWidth=" + itemWidth
				+ ", itemHeight=" + itemHeight + ", itemWeight=" + itemWeight + ", imagePathname=" + imagePathname
				+ ", rfidTagged=" + rfidTagged + ", storageAttribute=" + storageAttribute + ", pickType=" + pickType
				+ ", upcList=" + upcList + "]";
	}

    
    
}
