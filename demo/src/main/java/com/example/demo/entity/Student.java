package com.example.demo.entity;

import java.time.LocalDate;
import java.time.Period;

import javax.persistence.*;

@Entity
@Table
public class Student {
  @Id
  @SequenceGenerator(
    name = "student_sequence", 
    sequenceName = "student_sequence", 
    allocationSize = 1 
  )
  @GeneratedValue(
    strategy = GenerationType.SEQUENCE, 
    generator = "student_sequence"
  )
  private Long id; 
  private String firstName;
  private String lastName; 
  private String email; 
  private LocalDate dob; 
  private Integer numClasses; 
  @Transient
  private Integer age; 

  public Student(){
  }
  public Student(Long id, String firstName, String lastName, String email, LocalDate dob){
    this.id = id; 
    this.firstName = firstName;
    this.lastName = lastName; 
    this.email = email; 
    this.dob = dob;   
    this.numClasses = 0; 
  }
  public Student(Long id, String firstName, String lastName, String email, Integer numClasses, LocalDate dob){ 
    this.firstName = firstName; 
    this.lastName = lastName; 
    this.email = email; 
    this.dob = dob; 
    this.numClasses = numClasses; 
  } 
  public Student(String firstName, String lastName, String email, LocalDate dob){ 
    this.firstName = firstName; 
    this.lastName = lastName; 
    this.email = email; 
    this.dob = dob; 
    this.numClasses = 0; 
  } 
  public Student(String firstName, String lastName, String email, Integer numClasses, LocalDate dob){ 
    this.firstName = firstName; 
    this.lastName = lastName; 
    this.email = email; 
    this.dob = dob; 
    this.numClasses = numClasses; 
  } 
  
  public Long getId() {
    return id;
  }

  public void setId(Long id){
    this.id = id;
  }

  public String getFirstName(){
    return firstName;
  }

  public Integer getNumClasses(){
    return numClasses; 
  }

  public void setFirstName(String firstName){
    this.firstName = firstName;
  }

  public String getLastName(){
    return lastName;
  }

  public void setLastName(String lastName){
    this.lastName = lastName; 
  }

  public String getEmail(){
    return email; 
  }

  public void setEmail(String email){
    this.email = email;
  }

  public void setNumClasses(Integer num){
    this.numClasses = num;  
  }

  public void incrementNumClasses(){
    this.numClasses++; 
  }

  public void decrementNumClasses(){
    this.numClasses--; 
  }
  public LocalDate getDob(){
    return dob;
  }

  public void setDob(LocalDate dob){
    this.dob = dob; 
  }

  public Integer getAge(){
    return Period.between(this.dob, LocalDate.now()).getYears();
  }

  public void setAge(Integer age){
    this.age = age; 
  }
  @Override
  public String toString(){
    return "Student{" +
    "id=" + id +
    ", firstName='" + firstName + '\'' +
    ", lastName='" + lastName + '\'' +
    ", email='" + email + '\'' +
    ", dob=" + dob +
    ", age=" + age +
    '}';
  }
}
