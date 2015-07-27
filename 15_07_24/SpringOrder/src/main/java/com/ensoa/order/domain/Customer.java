package com.ensoa.order.domain;

public class Customer {
	//필드
	private long id;
	private String name;
	private String address;
	private String email;
	
	//get set 및 메소드 작성
	public long getId() {	return id;	}
	public void setId(long id) { this.id = id;}
	public String getName() {return name;}
	public void setName(String name) {	this.name = name;	}
	public String getAddress() {	return address;	}
	public void setAddress(String address) {	this.address = address;	}
	public String getEmail() {	return email;	}
	public void setEmail(String email) {	this.email = email;	}
	
	//메소드 작성
	public String toString() {
		return "id : " + id + ", name : " + name + ", address : " + address + ", email : " + email;
	}
}
