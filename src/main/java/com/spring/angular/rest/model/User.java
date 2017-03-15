package com.spring.angular.rest.model;

public class User {
	@Override
	public String toString() {
		return "User [fname=" + fname + ", lname=" + lname + ", email=" + email
				+ ", address=" + address + "]";
	}
	private String fname;
	private String lname;
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public User(String fname, String lname, String email, String address) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.address = address;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	private String email;
	private String address;

}
