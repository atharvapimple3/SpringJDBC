package com.javajdbc.javajdbc;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.javajdbc.javajdbc.model.Student;
import com.javajdbc.javajdbc.service.StudentService;

@SpringBootApplication
public class JavajdbcApplication {

	public static void main(String[] args) {
		ApplicationContext context =  SpringApplication.run(JavajdbcApplication.class, args);
		Student s = context.getBean(Student.class);

		// s.setRoll(2);
		// s.setName("Anuj");
		// s.setMarks(76);

		StudentService service = context.getBean(StudentService.class);
		service.addStudent(s);

		List <Student> students = service.getStudents();
		System.out.println(students);

	}

}
