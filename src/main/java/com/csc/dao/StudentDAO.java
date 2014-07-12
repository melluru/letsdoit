package com.csc.dao;

import com.csc.models.Student;

public interface StudentDAO {

	public void insert(Student std);
	public Student findByStudentId(int id); 
}
