package com.csc.models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "contactInfo")
public class ContactInfo {

	private int id;
	private String email;
	private Integer phNo;

	public ContactInfo() {
	}

	public ContactInfo(String email, Integer phno) {
		// TODO Auto-generated constructor stub
		this.email = email;
		this.phNo = phno;
	}

	public int getId() {
		return id;
	}

	@XmlElement
	public void setId(int id) {
		this.id = id;
	}

	public int getPhNo() {
		return this.phNo;
	}

	@XmlElement
	public void setPhNo(int phNo) {
		this.phNo = phNo;
	}

	public String getEmail() {
		return this.email;
	}

	@XmlElement
	public void setEmail(String email) {
		this.email = email;
	}

}
