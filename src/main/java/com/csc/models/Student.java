package com.csc.models;

import java.util.Set;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "student")
public class Student {

	private int id;
	private String firstName;
	private String lastName;
	// private List<ContactInfo> list;
	private Set<ContactInfo> contacts;;

	// Must have no-argument constructor
	public Student() {
	}

	public Student(String fname, String lname) {
		// TODO Auto-generated constructor stub
		this.firstName = fname;
		this.lastName = lname;
	}

	public Set<ContactInfo> getContacts() {
		return contacts;
	}

	@XmlElement(name = "contactInfo")
	public void setContacts(Set<ContactInfo> contacts) {
		this.contacts = contacts;
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
