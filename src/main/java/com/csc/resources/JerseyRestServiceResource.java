package com.csc.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.csc.models.Student;

@Path("/xmlServices")
public class JerseyRestServiceResource {

	@GET
	@Path("/print/{name}")
	@Produces(MediaType.APPLICATION_XML)
	public Student responseMsg( @PathParam("name") String name ) {
		
		Student st = new Student(1, "test", "Diaz");

		return st;

	}
	
	@POST
	@Path("/send")
	@Consumes(MediaType.APPLICATION_XML)
	public Response consumeXML( Student student ) {
		
		String output = student.toString();

		return Response.status(200).entity(output).build();
	}


}
