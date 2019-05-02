package com.vojkodrev.students.services;

import com.vojkodrev.students.StudentsApplication;
import com.vojkodrev.students.data.Student;
import com.vojkodrev.students.data.StudentClass;
import com.vojkodrev.students.data.StudentClassRepository;
import com.vojkodrev.students.data.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

  @Autowired
  private StudentRepository studentRepository;

  @Autowired
  private StudentClassRepository studentClassRepository;

  public List<String> getClassNames() {
    return getClassNames(studentClassRepository.findAll());
  }

  public List<String> getClassNames(List<StudentClass> classes) {
    List<String> result = new ArrayList<>(classes.size());
    for (StudentClass sc : classes) {
      result.add(sc.name);
    }
    return result;
  }

  public List<String> findClass(String search) {
    return getClassNames(studentClassRepository.findByNameLikeIgnoreCase(search));
  }

  public boolean enroll(String className, String auth) {
    if (!studentClassRepository.existsById(className))
      return false;

    Optional<Student> student = studentRepository.findByAuth(auth);

    if (!student.isPresent())
      return false;

    Student s = student.get();

    if (s.enrollments.contains(className))
      return true;

    s.enrollments.add(className);
    studentRepository.save(s);

    return true;
  }

  public boolean cancelEnrollment(String className, String auth) {
    if (!studentClassRepository.existsById(className))
      return false;

    Optional<Student> student = studentRepository.findByAuth(auth);

    if (!student.isPresent())
      return false;

    Student s = student.get();

    if (!s.enrollments.contains(className))
      return true;

    s.enrollments.remove(className);
    studentRepository.save(s);

    return true;
  }
}
