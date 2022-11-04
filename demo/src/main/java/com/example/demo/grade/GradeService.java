package com.example.demo.grade;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GradeService {
  private final GradeRepository gradeRepository; 

  @Autowired 
  public GradeService(GradeRepository gradeRepository){
    this.gradeRepository = gradeRepository;
  }

  public List<Grade> getGrades(){
    return gradeRepository.findAll(); 
  }

  public void addNewGrade(Grade grade){
    Optional<Grade> gradeById = gradeRepository.findGradeById(grade.getStudentId(), grade.getCourseId());
    // Needs to be a better way to do this <=== 
    if (gradeById.isPresent()){
      throw new IllegalStateException("grade in database"); 
    }
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
