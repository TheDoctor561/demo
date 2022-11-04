package com.example.demo.professor;
import java.time.LocalDate; 
import java.time.Period; 
import javax.persistence.*;

@Entity 
@Table 
public class Professor {
  @Id
  @SequenceGenerator(
    name = "professor_sequence", 
    sequenceName = "professor_sequence", 
    allocationSize = 1 
  )
  @GeneratedValue(
    strategy = GenerationType.SEQUENCE, 
    generator = "professor_sequence"
  )
  private Long id; 
  private String firstName;
  private String lastName; 
  private String email; 
  private LocalDate dob; 
  @Transient
  private Integer age; 

  public Professor(){

  }
  public Professor(Long id, String firstName, String lastName, String email, LocalDate dob){
    this.id = id; 
    this.firstName = firstName;
    this.lastName = lastName; 
    this.email = email; 
    this.dob = dob;   

  }

  public Professor(String firstName, String lastName, String email, LocalDate dob){ 
    this.firstName = firstName; 
    this.lastName = lastName; 
    this.email = email; 
    this.dob = dob; 
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
    return "Professor{" +
    "id=" + id +
    ", firstName='" + firstName + '\'' +
    ", lastName='" + lastName + '\'' +
    ", email='" + email + '\'' +
    ", dob=" + dob +
    ", age=" + age +
    '}';
  }
}


