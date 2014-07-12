package com.csc.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.csc.dao.StudentDAO;
import com.csc.models.Student;

public class StudentDaoImpl extends HibernateDaoSupport implements StudentDAO  {

	public void insert(Student student){
		//getHibernateTemplate().update(student);
		getHibernateTemplate().save(student);
	}
 
	public Student findByStudentId(int stdId){
		List list = getHibernateTemplate().find(
                      "from Student where Id=?",stdId
                );
		return (Student)list.get(0);
	}
	
}
