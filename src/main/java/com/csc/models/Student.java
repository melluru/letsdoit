package com.csc.models;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "student")
public class Student {

// Edited from github
	private Integer id;
	private String firstName;
	private String lastName;

	// Must have no-argument constructor
	public Student() {
	}

	public Student(int id, String fname, String lname) {
		this.firstName = fname;
		this.lastName = lname;
		this.id = id;
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
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return this.id;
	}

	@Override
	public String toString() {
		return new StringBuffer(" First Name : ").append(this.firstName)
				.append(" Last Name : ").append(this.lastName)
				.append(" ID : ")
				.append(this.id).toString();
	}

}
