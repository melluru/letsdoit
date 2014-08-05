package com.csc.resources.rest;

//import java.util.logging.Logger;

import javax.ws.rs.core.Response;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.csc.models.Student;
import com.csc.resources.rest.StudentRestResource;

@RunWith(MockitoJUnitRunner.class)
public class StudentsResourceTestMock {

	private StudentRestResource studentsRsrSprHib = new StudentRestResource();

	//@Test
	public void testPostStudent() {
		Student student = new Student();
		student.setFirstName("TestName");
		Response response = studentsRsrSprHib.postStudent(student);
		Assert.assertEquals(student.getFirstName(),
				((Student) response.getEntity()).getFirstName());
	}

	//@Test
	public void testPostStudentLastName() {
		Student student = new Student();
		student.setLastName("");
		Response response = studentsRsrSprHib.postStudent(student);
		Assert.assertEquals(student.getFirstName(),
				((Student) response.getEntity()).getFirstName());
	}
	
	//@Test(expected = IllegalArgumentException.class)
	public void testPostStudentFailure() {
		Student student = new Student();
		student.setFirstName("TestName");
		Response response = studentsRsrSprHib.postStudent(null);
		Assert.assertEquals(student.getFirstName(),
				((Student) response.getEntity()).getFirstName());
	}
}