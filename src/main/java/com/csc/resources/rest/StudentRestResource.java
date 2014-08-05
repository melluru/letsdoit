package com.csc.resources.rest;

//import java.util.logging.Logsger;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.csc.bo.StudentBO;
import com.csc.models.Student;
import com.csc.models.Students;

@Path("/studentInfo")
@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
public class StudentRestResource {

	private ApplicationContext appContext;

	private static final Logger LOG = LoggerFactory
			.getLogger(StudentRestResource.class);

	public StudentRestResource() {
		appContext = new ClassPathXmlApplicationContext(
				"spring/config/applicationContext.xml");
	}

	@POST
	@Path("/student")
	public Response postStudent(Student student) {

		StudentBO studentBo = (StudentBO) appContext.getBean("studentBo");
		studentBo.insert(student);
		// System.out.println(student.getId());
		// ApplicationContext context =
		// new ClassPathXmlApplicationContext("Spring-Module.xml");

		// StudentDAO stdDAO = (StudentDAO) context.getBean("StudentDAO");
		// Student std = new Student(student.getId(),
		// student.getFirstName(),student.getLastName());
		// stdDAO.insert(std);

		return Response.status(201).entity(student).build();
	}

	@POST
	@Path("/students")
	public Response postStudents(Students students) {

		LOG.info("Entering students --------------------");
		LOG.info(students.getList().get(0).getFirstName());

		// IStudentsBO studentsBO = (IStudentsBO)
		// appContext.getBean("studentsBo");
		// studentsBO.insert(students);

		StudentBO studentBo = (StudentBO) appContext.getBean("studentBo");
		studentBo.insertMultiple(students);

		// for(Student student: students.getList())
		// {
		// studentBo.insert(student);
		// }

		return Response.status(201).entity(students).build();
	}

	@GET
	@Path("/{param}")
	public Student getMsg(@PathParam("param") Integer msg) {

		StudentBO studentBo = (StudentBO) appContext.getBean("studentBo");
		Student student2 = studentBo.findByStudentId(msg);

		return student2;
	}
}