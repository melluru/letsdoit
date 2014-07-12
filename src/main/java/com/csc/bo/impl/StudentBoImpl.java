package com.csc.bo.impl;

import com.csc.bo.StudentBO;
import com.csc.dao.StudentDAO;
import com.csc.models.Student;

public class StudentBoImpl implements StudentBO {

	StudentDAO stdDao;
	 
	public void setStudentDao(StudentDAO stdDao) {
		this.stdDao = stdDao;
	}

	public void insert(Student std) {
		// TODO Auto-generated method stub
		stdDao.insert(std);
	}

	public Student findByStudentId(int id) {
		// TODO Auto-generated method stub
		return stdDao.findByStudentId(id);
	}
	
}
