package com.example.demo.persistence;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
  @Query("SELECT s FROM Student s WHERE s.email = ?1")
  Optional<Student> findStudentByEmail(String email); 
  
  @Query("SELECT s FROM Student s WHERE s.numClasses > 4")
  List<Student> studentsFiveClasses(); 

}
