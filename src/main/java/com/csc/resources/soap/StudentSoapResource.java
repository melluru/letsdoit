package com.csc.resources.soap;

//import java.util.logging.Logger;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.ws.rs.PathParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.csc.bo.StudentBO;
import com.csc.models.Student;
import com.csc.models.Students;

@WebService
public class StudentSoapResource {

	private ApplicationContext appContext;

	private static final Logger LOG = LoggerFactory
			.getLogger(StudentSoapResource.class);

	public StudentSoapResource() {
		appContext = new ClassPathXmlApplicationContext(
				"spring/config/springContext.xml");
	}
	
	StudentBO studentBo;

	@WebMethod(exclude=true)
	public void setStudentBo(StudentBO studentBo) {
		this.studentBo = studentBo;
		//StudentBO studentBo = (StudentBO) appContext.getBean("studentBo");
		//studentBo.insert(student);

		//return "HelloWorldStudent";
	}

	@WebMethod(operationName="postStudents")
	public String postStudents(Students students) {

		LOG.info("Entering students --------------------");
		LOG.info(students.getList().get(0).getFirstName());

		StudentBO studentBo = (StudentBO) appContext.getBean("studentBo");
		studentBo.insertMultiple(students);

		return  "HelloWorldStudents";
	}

	@WebMethod(operationName="getStudent")
	public Student getMsg(@PathParam("param") Integer msg) {

		//StudentBO studentBo = (StudentBO) appContext.getBean("studentBo");
		//Student student2 = studentBo.findByStudentId(msg);

		return studentBo.findByStudentId(msg);
	}
}

