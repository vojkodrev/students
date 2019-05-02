package com.vojkodrev.students.data;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface StudentRepository extends MongoRepository<Student, String> {

  public Optional<Student> findByAuth(String auth);

}
