package com.csc.bo;

import com.csc.models.Student;
import com.csc.models.Students;

public interface StudentBO {

	public void insert(Student std);
	public Student findByStudentId(int id);
	public void insertMultiple(Students students); 
	
}
