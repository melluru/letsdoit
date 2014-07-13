package com.csc.dao;

import com.csc.models.Student;
import com.csc.models.Students;

public interface StudentDAO {

	public void insert(Student std);
	public Student findByStudentId(int id);
	public void insertMultiple(Students students); 
}
