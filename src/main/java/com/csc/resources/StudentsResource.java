package com.csc.resources;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.csc.models.Student;

@Path("/hello")
@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
public class StudentsResource {
	
	private static Map<Integer, String> studentInfo = new HashMap<Integer, String>();

	@POST
	public Response postMsg(Student student) {
	
	   Integer nextKey = studentInfo.keySet().size()+1;

		//studentInfo.put("1", "Manjunath Elluru");
		studentInfo.put(nextKey, student.getFirstName()+"-"+student.getLastName());
		return Response.status(201).entity(student).build();
	}

	@GET
	@Path("/{param}")
	public Student getMsg(@PathParam("param") Integer msg) {
	    	    
		//String output = "Jersey say : " + studentInfo.get(msg);
		Student student = new Student();
		student.setId(msg);
		student.setFirstName(studentInfo.get(msg).split("-")[0]);
		student.setLastName(studentInfo.get(msg).split("-")[1]);
 
		return student; 
	}
}