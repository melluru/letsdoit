package com.csc.common;

import org.hibernate.Session;

import com.csc.models.Student;
import com.csc.persistence.HibernateUtil;
 
public class appStudentHibernate {

    public static void main( String[] args )
    {
        System.out.println("Maven + Hibernate + MySQL");
        Session session = HibernateUtil.getSessionFactory().openSession();
 
        System.out.println("Maven + Hibernate + MySQL"+":Before Begin Transaction");
        session.beginTransaction();
        Student std = new Student();
 
        System.out.println("Maven + Hibernate + MySQL"+":Setting Values");
        std.setId(12);
        std.setFirstName("HFirstName12");
        std.setLastName("HLastName12");
        
        System.out.println("Maven + Hibernate + MySQL"+":Before Commit");
        session.save(std);
        session.getTransaction().commit();
        System.out.println("Maven + Hibernate + MySQL"+":After Commit");
    }
}