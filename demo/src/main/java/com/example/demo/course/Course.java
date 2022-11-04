package com.example.demo.course;

import javax.persistence.*;

import com.example.demo.professor.Professor;

@Entity
@Table
public class Course {
  @Id 
  @SequenceGenerator(name = "course_sequence", 
  sequenceName = "course_sequence", 
  allocationSize = 1 )
  @GeneratedValue(
    strategy = GenerationType.SEQUENCE, 
    generator = "course_sequence"
  )
  private Long id; 
  private String name;
  private Long professorId; 


  public Course(){}

  public Course(Long id, String name, Long professorId){
    this.id = id; 
    this.name = name;
    this.professorId = professorId; 
  }

  public Course(String name, Long professorId){
    this.name = name; 
    this.professorId = professorId;
  }

  public Long getId(){
    return id; 
  }

  public void setId(Long id){
    this.id = id;
  }

  public String getName(){
    return name; 
  }

  public void setName(String name){
    this.name = name; 
  }

  public Long getProfessorId(){
    return professorId; 
  }

  public void setProfessorId(Long professorId){
    this.professorId = professorId; 
  }
  @Override
  public String toString(){
    return "Course{" + "id= " + id + " name= "+ name + " professorId=" + professorId + "}"; 
  }

}
