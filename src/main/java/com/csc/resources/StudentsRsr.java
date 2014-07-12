package com.csc.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.csc.dao.StudentDAO;
import com.csc.models.Student;

@Path("/helloStudent")
@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
public class StudentsRsr {
	
	//private static Map<Integer, String> studentInfo = new HashMap<Integer, String>();

	@POST
	public Response postMsg(Student student) {

		ApplicationContext context = 
	    		new ClassPathXmlApplicationContext("Spring-Module.xml");
		
		StudentDAO stdDAO = (StudentDAO) context.getBean("StudentDAO");
        Student std = new Student(student.getId(), student.getFirstName(),student.getLastName());
        stdDAO.insert(std);
		
		return Response.status(201).entity(student).build();
	}

	@GET
	@Path("/{param}")
	public Student getMsg(@PathParam("param") Integer msg) {
	    
		ApplicationContext context = 
	    		new ClassPathXmlApplicationContext("Spring-Module.xml");
		
		StudentDAO stdDAO = (StudentDAO) context.getBean("StudentDAO");
        Student student = stdDAO.findByStudentId(msg);

		return student; 
	}
}