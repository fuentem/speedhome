package com.speedhome.property.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PROPERTY")
public class Property implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "ADDRESS")
	private String address;
	
	@Column(name = "POSTCODE")
	private Integer postcode;
	
	@Column(name = "NO_OF_BEDROOMS")
	private Integer noOfbedrooms;
	
	@Column(name = "NO_OF_FLOORS")
	private Integer noOfFloors;
	
	@Column(name = "NO_OF_BATHROOMS")
	private Integer noOfBathrooms;
	
	@Column(name = "SQFT_SIZE")
	private Integer sqftSize;
	
	@Column(name = "PRICE")
	private BigDecimal price;
	
	@Column(name = "STATUS")
	private String status;
	
	@Column(name = "CREATED_DATE")
	private Date createdDate;
	
	@Column(name = "APPROVED_DATE")
	private Date approvedDate;
	
	public Property() {
		super();
	}
	
	public Property(PropertyEntityWrapper propertyWrapper) {
		super();
		assignWrapperToObj(propertyWrapper);
	}
	
	public void assignWrapperToObj(PropertyEntityWrapper propertyWrapper) {
		this.setName(propertyWrapper.getName());
		this.setAddress(propertyWrapper.getAddress());
		this.setPostcode(propertyWrapper.getPostcode());
		this.setNoOfbedrooms(propertyWrapper.getNoOfbedrooms());
		this.setNoOfFloors(propertyWrapper.getNoOfFloors());
		this.setNoOfBathrooms(propertyWrapper.getNoOfBathrooms());
		this.setSqftSize(propertyWrapper.getSqftSize());
		this.setPrice(propertyWrapper.getPrice());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getApprovedDate() {
		return approvedDate;
	}

	public void setApprovedDate(Date approvedDate) {
		this.approvedDate = approvedDate;
	}
	
}
