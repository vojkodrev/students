package com.vojkodrev.students.data;

import org.springframework.data.annotation.Id;

import java.util.List;

public class StudentClass {

  @Id
  public String name;

  public StudentClass() {}

  public StudentClass(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return String.format("StudentClass[name='%s']", name);
  }

}