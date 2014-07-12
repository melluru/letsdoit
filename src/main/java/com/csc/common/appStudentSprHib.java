package com.csc.common;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.csc.bo.StudentBO;
import com.csc.models.Student;

public class appStudentSprHib {
	
	public static void main( String[] args )
    {
    	ApplicationContext appContext = 
    	  new ClassPathXmlApplicationContext("spring/config/BeanLocations.xml");
 
    	StudentBO studentBo = (StudentBO)appContext.getBean("studentBo");
 
    	/** insert **/
    	Student student = new Student();
    	//student.setId(11);
    	student.setFirstName("SprHibFstName14");
    	student.setLastName("SprHibLstName14");
    	studentBo.insert(student);
 
    	/** select **/
    	Student student2 = studentBo.findByStudentId(5);
    	System.out.println(student2);
 
    	/** update **/
    	//stock2.setStockName("HAIO-1");
    	//stockBo.update(stock2);
 
    	/** delete **/
    	//stockBo.delete(stock2);
 
    	System.out.println("Done");
    }

}
