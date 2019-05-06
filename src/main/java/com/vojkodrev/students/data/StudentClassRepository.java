package com.vojkodrev.students.data;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface StudentClassRepository extends MongoRepository<StudentClass, String> {

  public List<StudentClass> findByNameLikeIgnoreCase(String name);

}
