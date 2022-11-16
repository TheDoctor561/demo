package com.example.demo.presentation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService; 
@RestController
@RequestMapping(path = "api/v1/student")
@CrossOrigin
public class StudentController {
  private final StudentService studentService;
  @Autowired
  public StudentController(StudentService studentService){
    this.studentService = studentService; 
  }

  @GetMapping
  // Used to get all students
	// public List<Student> getStudents() {
  //   return studentService.getStudents(); 
	// }
  // Get students who have at least five classes 
  public List<Student> getStudentsFive() {
    return studentService.getStudentsFive(); 
  }
  

  @PostMapping
  public void registerNewStudent(@RequestBody Student student){
    studentService.addNewStudent(student);
  }
  
  @DeleteMapping(path = "{studentId}")
  public void deleteStudent(@PathVariable("studentId") Long studentId) {
    studentService.deleteStudent(studentId); 
  }

  @PutMapping(path = "{studentId}")
  public void updateStudent(
    @PathVariable("studentId") Long studentId, 
    @RequestParam(required = false) String firstName, 
    @RequestParam(required = false) String lastName, 
    @RequestParam(required = false) String email) {
      studentService.updateStudent(studentId, firstName, lastName, email);
    }
}
