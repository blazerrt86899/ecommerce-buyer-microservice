package com.ecommerce.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "buyer_info")
public class Buyer implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "buyer_id")
	private Integer buyerId;
	@Column
	private String username;
	@Column
	private String password;
	@Column
	private String emailId;
	@Column
	private String mobileNumber;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate createdOn;
	@OneToOne
	@JoinColumn(name = "address_id_fk")
	private Address address;
	
	//No Arg Constructor
	public Buyer() {
		// TODO Auto-generated constructor stub
	}

	//Arg Constructor
	public Buyer(Integer buyerId, String username, String password, String emailId, String mobileNumber,
			LocalDate createdOn,Address address) {
		this.buyerId = buyerId;
		this.username = username;
		this.password = password;
		this.emailId = emailId;
		this.mobileNumber = mobileNumber;
		this.createdOn = createdOn;
		this.address = address;
	}

	//Getters and Setters
	public Integer getBuyerId() {
		return buyerId;
	}


	public void setBuyerId(Integer buyerId) {
		this.buyerId = buyerId;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmailId() {
		return emailId;
	}


	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}


	public String getMobileNumber() {
		return mobileNumber;
	}


	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}


	public LocalDate getCreatedOn() {
		return createdOn;
	}


	public void setCreatedOn(LocalDate createdOn) {
		this.createdOn = createdOn;
	}
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}


	
}
