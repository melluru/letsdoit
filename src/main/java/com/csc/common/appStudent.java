package com.csc.common;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.csc.dao.StudentDAO;
import com.csc.models.Student;
 

public class appStudent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ApplicationContext context = 
	    		new ClassPathXmlApplicationContext("Spring-Module.xml");
	 
	        StudentDAO stdDAO = (StudentDAO) context.getBean("StudentDAO");
	        //Actor actor = new Actor(201, "Bala","Krishna");
	        //actorDAO.insert(actor);
	 
	        Student std1 = stdDAO.findByStudentId(2);
	        System.out.println(std1);
		
	       // System.out.println(std1.toString());
	}

}
