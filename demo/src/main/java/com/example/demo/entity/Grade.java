package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table
public class Grade {
  @Id
  @SequenceGenerator(
    name = "grade_sequence", 
    sequenceName = "grade_sequence", 
    allocationSize = 1 
  )
  @GeneratedValue(
    strategy = GenerationType.SEQUENCE, 
    generator = "grade_sequence"
  )
  private Long id; 
  private double grade; 
  private Long studentId; 
  private Long courseId; 
  private Long professorId; 

  public Grade(){}

  public Grade(double grade, Long studentId, Long courseId, Long professorId){
    this.grade = grade;
    this.studentId = studentId; 
    this.courseId = courseId; 
    this.professorId = professorId; 
  }

  public double getGrade(){
    return grade; 
  }

  public void setGrade(double grade){
    this.grade = grade; 
  }

  public Long getStudentId(){
    return studentId; 
  }

  public Long getCourseId(){
    return courseId;
  }

  public Long getProfessorId(){
    return professorId; 
  }

  public void setProfessorId(Long professorId){
    this.professorId = professorId; 
  }

  @Override
  public String toString(){
    return "Grade{" + "grade= " + grade + " studentId= " + studentId + " courseId= " + courseId + "}"; 
  }

}
