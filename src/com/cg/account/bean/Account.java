package com.cg.account.bean;

import java.sql.Date;

public class Account {
	private String name;
	private String mobileNo; 
	private String email;
    private double balance;
    Date date;
  //Getters & Setters 
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public Account(String mobileNo, String name, String email, double balance,
			Date date) {
		super();
		this.mobileNo = mobileNo;
		this.name = name;
		this.email = email;
		this.balance = balance;
		this.date = date;
	}
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
}	
		
	
	
	
	

