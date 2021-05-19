package com.speedhome.property.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class PropertyEntityWrapper implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;
	private String address;
	private Integer postcode;
	private Integer noOfbedrooms;
	private Integer noOfFloors;
	private Integer noOfBathrooms;
	private Integer sqftSize;
	private BigDecimal price;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getPostcode() {
		return postcode;
	}

	public void setPostcode(Integer postcode) {
		this.postcode = postcode;
	}

	public Integer getNoOfbedrooms() {
		return noOfbedrooms;
	}

	public void setNoOfbedrooms(Integer noOfbedrooms) {
		this.noOfbedrooms = noOfbedrooms;
	}

	public Integer getNoOfFloors() {
		return noOfFloors;
	}

	public void setNoOfFloors(Integer noOfFloors) {
		this.noOfFloors = noOfFloors;
	}

	public Integer getNoOfBathrooms() {
		return noOfBathrooms;
	}

	public void setNoOfBathrooms(Integer noOfBathrooms) {
		this.noOfBathrooms = noOfBathrooms;
	}

	public Integer getSqftSize() {
		return sqftSize;
	}

	public void setSqftSize(Integer sqftSize) {
		this.sqftSize = sqftSize;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

}
