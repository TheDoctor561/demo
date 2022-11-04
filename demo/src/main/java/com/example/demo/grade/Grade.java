package com.example.demo.grade;

import javax.persistence.*;

@Entity
@Table
public class Grade {
  @Id
  private double grade; 
  private Long studentId; 
  private Long courseId; 

  public Grade(){}

  public Grade(double grade, Long studentId, Long courseId){
    this.grade = grade;
    this.studentId = studentId; 
    this.courseId = courseId; 
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

  @Override
  public String toString(){
    return "Grade{" + "grade= " + grade + " studentId= " + studentId + " courseId= " + courseId + "}"; 
  }

}
