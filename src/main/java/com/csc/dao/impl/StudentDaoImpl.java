package com.csc.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.csc.dao.StudentDAO;
import com.csc.models.Student;
import com.csc.models.Students;
import com.csc.persistence.HibernateUtil;

public class StudentDaoImpl extends HibernateDaoSupport implements StudentDAO {

	public void insert(Student student) {
		// getHibernateTemplate().update(student);
		getHibernateTemplate().save(student);
	}

	public void insertMultiple(Students students) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		for (Student student : students.getList()) {
			session.save(student);
		}
		transaction.commit();
		session.close();
	}

	public Student findByStudentId(int stdId) {
		List list = getHibernateTemplate().find("from Student where Id=?",stdId);
		return (Student) list.get(0);
	}

}
