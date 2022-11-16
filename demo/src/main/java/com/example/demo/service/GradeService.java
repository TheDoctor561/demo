package com.example.demo.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Course;
import com.example.demo.entity.Grade;
import com.example.demo.entity.Student;
import com.example.demo.persistence.GradeRepository;

@Service
public class GradeService {
  @Autowired 
  private final GradeRepository gradeRepository; 

  public GradeService(GradeRepository gradeRepository){
    this.gradeRepository = gradeRepository;
  }

  public List<Grade> getGrades(){
    return gradeRepository.findAll(); 
  }

  public List<Grade> getStudentGrades(Long studentId){
    List<Grade> gradeByStudentId = gradeRepository.findGradeByStudentId(studentId); 

    return gradeByStudentId;
  }

  public void addNewGrade(Grade grade){
    Optional<Grade> gradeById = gradeRepository.findGradeById(grade.getStudentId(), grade.getCourseId());
    Optional<Student> student = gradeRepository.findStudentById(grade.getStudentId()); 
    Optional<Course> course = gradeRepository.findCourseById(grade.getCourseId()); 
    // Needs to be a better way to do this <=== 
    if (gradeById.isPresent()){
      throw new IllegalStateException("grade in database"); 
    }
    if (!student.isPresent()){
      throw new IllegalStateException("There is no such student");
    }
    if (!course.isPresent()){
      throw new IllegalStateException("There is no such Course");
    }
    Course c = course.get(); 
    if (grade.getProfessorId() != c.getProfessorId()){
      throw new IllegalStateException("Course and Professor do not match");
    }
    Student s = student.get(); 
    s.incrementNumClasses(); 
    gradeRepository.save(grade);  
  }

  // TO ADD PUT change grade for particular class student combo 
  public void deleteGrade(Grade grade){
    Optional<Grade> gradeById = gradeRepository.findGradeById(grade.getStudentId(), grade.getCourseId());
    if (!gradeById.isPresent()){
      throw new IllegalStateException("Grade not present in system");
    }
    gradeRepository.delete(grade);
  }
}
