package com.example.demo.persistence;

import java.util.*;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Grade;
import com.example.demo.entity.Student;
import com.example.demo.entity.Course; 

@Repository
public interface GradeRepository extends JpaRepository<Grade, Long> {
  @Query("SELECT g FROM Grade g WHERE g.studentId = ?1 AND g.courseId = ?2")
  Optional<Grade> findGradeById(Long studentId, Long courseId); 
  @Query("SELECT g FROM Grade g WHERE g.studentId = ?1")
  List<Grade> findGradeByStudentId(Long StudentId); 
  // Find student by id from grade repository
  @Query("SELECT s FROM Student s WHERE s.id = ?1")
  Optional<Student> findStudentById(Long id); 
  @Query("SELECT c FROM Course c WHERE c.id = ?1")
  Optional<Course> findCourseById(Long id); 
}
