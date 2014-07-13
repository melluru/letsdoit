package com.csc.models;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "students")
public class Students {

	private List<Student> list;

	public Students() {
	}

	public Students(List<Student> list) {
		this.list = list;
	}

	@XmlElement(name = "student")
	public List<Student> getList() {
		return (list != null) ? list : new ArrayList<Student>();
	}

	public void setList(List<Student> list) {
		this.list = list;
	}

}
