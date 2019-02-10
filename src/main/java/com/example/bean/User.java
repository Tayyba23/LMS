package com.example.bean;

public class User {
	String id;
	String name;
	String cnic;
	String mobile;
	String address;
	
	public User(String id, String name, String cnic, String mobile, String address) {
		super();
		this.id = id;
		this.name = name;
		this.cnic = cnic;
		this.mobile = mobile;
		this.address = address;
	}
	
	public User() {
		
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCnic() {
		return cnic;
	}
	public void setCnic(String cnic) {
		this.cnic = cnic;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

}
