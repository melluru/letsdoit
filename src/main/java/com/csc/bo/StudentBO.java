package com.csc.bo;

import com.csc.models.Student;

public interface StudentBO {

	public void insert(Student std);
	public Student findByStudentId(int id); 
	
}
