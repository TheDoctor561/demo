package com.example.demo.service;
import java.util.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Student;
import com.example.demo.persistence.StudentRepository;


@Service
public class StudentService {
  @Autowired
  private final StudentRepository studentRepository; 

  public StudentService(StudentRepository studentRepository){
    this.studentRepository = studentRepository; 
  }
  public List<Student> getStudents() {
		return studentRepository.findAll(); 
	}
  public List<Student> getStudentsFive() {
    return studentRepository.studentsFiveClasses(); 
  }

  public void addNewStudent(Student student){
    Optional<Student> studentByEmail = studentRepository.findStudentByEmail(student.getEmail());
    // Needs to be a better way to do this <=== 
    if (studentByEmail.isPresent()){
      throw new IllegalStateException("email taken"); 
    }
    studentRepository.save(student); 
  }

  public void deleteStudent(Long studentId){
    boolean exists = studentRepository.existsById(studentId); 
    if (!exists) {
      throw new IllegalStateException("student with id " + studentId + " does not exist"); 
    }
    studentRepository.deleteById(studentId);
  }

  @Transactional 
  public void updateStudent(Long studentId, String firstName, String lastName, String email){
    Student student = studentRepository.findById(studentId)
    .orElseThrow(() -> new IllegalStateException("student with id " + studentId + " does not exist"));
    if (firstName != null && 
      firstName.length() > 0 && 
      !Objects.equals(student.getFirstName(), firstName)){
        student.setFirstName(firstName); 
    }
    if (lastName != null && 
      lastName.length() > 0 && 
      !Objects.equals(student.getLastName(), lastName)){
        student.setLastName(lastName); 
    }

    if (email != null && 
      email.length() > 0 && 
      !Objects.equals(student.getEmail(), email)){
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(email); 
        if (studentOptional.isPresent()){
          throw new IllegalStateException("email taken");
        }
        student.setEmail(email); 
    }
  }
}
