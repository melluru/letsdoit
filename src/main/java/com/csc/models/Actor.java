package com.csc.models;

public class Actor {
	
	private int id;
	private String firstName;
	private String lastName;
	
	// Must have no-argument constructor
	public Actor() {

	}

	public Actor(int id, String fname, String lname) {
		this.firstName = fname;
		this.lastName = lname;
		this.id = id;
	}
	
	public void setFirstName(String fname) {
		this.firstName = fname;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setLastName(String lname) {
		this.lastName = lname;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return this.id;
	}

	@Override
	public String toString() {
		return new StringBuffer(" First Name : ").append(this.firstName)
				.append(", Last Name : ").append(this.lastName)
				.append(", ID : ")
				.append(this.id).toString();
	}
	
	
}
