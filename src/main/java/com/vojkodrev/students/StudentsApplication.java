package com.vojkodrev.students;

import com.vojkodrev.students.data.Student;
import com.vojkodrev.students.data.StudentClass;
import com.vojkodrev.students.data.StudentClassRepository;
import com.vojkodrev.students.data.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoOperations;

import java.util.Arrays;

@SpringBootApplication
public class StudentsApplication implements CommandLineRunner {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private StudentClassRepository studentClassRepository;

	Logger logger = LoggerFactory.getLogger(StudentsApplication.class);

//	@Autowired
//	private MongoOperations mongoOperations;

	public static void main(String[] args) {
		SpringApplication.run(StudentsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		System.out.println((mongoOperations.toString());
//		studentRepository.deleteAll();
//		studentClassRepository.deleteAll();

		try {
			if (studentRepository.count() == 0) {
				logger.info("Populating students");
				studentRepository.save(new Student("GRJWLFJM7V", "Alice", "Smith", Arrays.asList("Computer Science", "Physics")));
				studentRepository.save(new Student("6MVCV8XE46", "John", "James", Arrays.asList("Math")));
			}

			if (studentClassRepository.count() == 0) {
				logger.info("Populating student classes");
				studentClassRepository.save(new StudentClass("Computer Science"));
				studentClassRepository.save(new StudentClass("Math"));
				studentClassRepository.save(new StudentClass("Physics"));
			}
		} catch (Throwable t) {
			logger.warn("Unable to populate students");
		}




//		System.out.println("Student found with findAll():");
//		System.out.println("-------------------------------");
//		for (Student student : studentRepository.findAll()) {
//			System.out.println(student);
//		}
//		System.out.println();
//
//		System.out.println("Student classes found with findAll():");
//		System.out.println("-------------------------------");
//		for (StudentClass studentClass : studentClassRepository.findAll()) {
//			System.out.println(studentClass);
//		}
//		System.out.println();
//
//
//
//		System.out.println("Student classes found by name like:");
//		System.out.println("-------------------------------");
//		for (StudentClass foundClass : studentClassRepository.findByNameLikeIgnoreCase("s1")) {
//			System.out.println(foundClass);
//		}
//		System.out.println();

//		// fetch an individual customer
//		System.out.println("Customer found with findByFirstName('Alice'):");
//		System.out.println("--------------------------------");
//		System.out.println(studentRepository.findByFirstName("Alice"));
//
//		System.out.println("Customers found with findByLastName('Smith'):");
//		System.out.println("--------------------------------");
//		for (Customer customer : studentRepository.findByLastName("Smith")) {
//			System.out.println(customer);
//		}
	}
}

