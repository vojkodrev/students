package com.vojkodrev.students.rest;

import java.util.List;

import com.vojkodrev.students.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

  @Autowired
  StudentService studentService;

  @GetMapping("/classes")
  public List<String> getClasses() {
    return studentService.getClassNames();
  }

  @GetMapping("/findClass/{search}")
  public List<String> findClass(@PathVariable String search) {
    return studentService.findClass(search);
  }

  @PostMapping("/enroll")
  public boolean enroll(@RequestParam(name = "class") String className, @RequestParam String auth) {
    return studentService.enroll(className, auth);
  }

  @PostMapping("/cancelEnrollment")
  public boolean cancelEnrollment(@RequestParam(name = "class") String className, @RequestParam String auth) {
    return studentService.cancelEnrollment(className, auth);
  }
}
