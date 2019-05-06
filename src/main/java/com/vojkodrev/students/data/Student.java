package com.vojkodrev.students.data;

import org.springframework.data.annotation.Id;

import java.util.List;

public class Student {

  @Id
  public String id;

  public String auth;

  public String firstName;
  public String lastName;

  public List<String> enrollments;

  public Student() {}

  public Student(String auth, String firstName, String lastName, List<String> enrollments) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.auth = auth;
    this.enrollments = enrollments;
  }

  @Override
  public String toString() {
    return String.format(
      "Student[id='%s', auth='%s', firstName='%s', lastName='%s', enrollments=%s]",
      id, auth, firstName, lastName, enrollments);
  }

}


