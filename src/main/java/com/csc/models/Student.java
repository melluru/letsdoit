package com.csc.models;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "student")
public class Student {

	private int id;
	private String firstName;
	private String lastName;
	private List<ContactInfo> list;

	public List<ContactInfo> getList() {
		return list;
	}

	@XmlElement (name = "contactInfo")
	public void setList(List<ContactInfo> list) {
		this.list = list;
	}

	// Must have no-argument constructor
	public Student() {
	}

	@XmlElement
	public void setFirstName(String fname) {
		this.firstName = fname;
	}

	public String getFirstName() {
		return this.firstName;
	}

	@XmlElement
	public void setLastName(String lname) {
		this.lastName = lname;
	}

	public String getLastName() {
		return this.lastName;
	}

	@XmlAttribute
	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return this.id;
	}


}