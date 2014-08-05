package com.csc.common;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.csc.models.ContactInfo;
import com.csc.models.Student;

public class StudentContact {

	private static SessionFactory factory;

	public static void main(String[] args) {
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
		StudentContact SC = new StudentContact();
		/* Let us have a set of certificates for the first employee */
		HashSet<ContactInfo> set1 = new HashSet<ContactInfo>();
		set1.add(new ContactInfo("aemail", 123));
		set1.add(new ContactInfo("bemail", 124));
		set1.add(new ContactInfo("cemail", 125));

		/* Add employee records in the database */
		Integer std1 = SC.addEmployee("Manoj", "Kumar", set1);

		/* Another set of certificates for the second employee */
		HashSet<ContactInfo> set2 = new HashSet<ContactInfo>();
		set2.add(new ContactInfo("BCA", 234));
		set2.add(new ContactInfo("BA", 235));

		/* Add another employee record in the database */
		Integer std2 = SC.addEmployee("Dilip", "Kumar", set2);

		/* List down all the employees */
		SC.listEmployees();
	}

	/* Method to add an employee record in the database */
	public Integer addEmployee(String fname, String lname, Set<ContactInfo> cnt) {
		Session session = factory.openSession();
		Transaction tx = null;
		Integer studentID = null;
		try {
			tx = session.beginTransaction();
			Student std = new Student(fname, lname);
			std.setContacts(cnt);
			studentID = (Integer) session.save(std);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return studentID;
	}

	/* Method to list all the employees detail */
	public void listEmployees() {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			List<?> stds = session.createQuery("FROM Student").list();
			for (Iterator<?> iterator1 = stds.iterator(); iterator1.hasNext();) {
				Student student = (Student) iterator1.next();
				System.out.print("First Name: " + student.getFirstName());
				System.out.print("  Last Name: " + student.getLastName());
				Set<?> contacts = student.getContacts();
				for (Iterator<?> iterator2 = contacts.iterator(); iterator2
						.hasNext();) {
					ContactInfo contactInfo = (ContactInfo) iterator2.next();
					System.out.println("Contact Email: "
							+ contactInfo.getEmail());
					System.out.println("Contact PhoneNo: "
							+ contactInfo.getPhNo());
				}
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

}
