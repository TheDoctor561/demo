package com.example.demo.util;

import java.time.LocalDate;
import java.time.Month;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.entity.Student;
import com.example.demo.persistence.StudentRepository;

import java.util.*;

@Configuration
public class StudentConfig {
  @Bean 
  CommandLineRunner commandLineRunner(StudentRepository repository){
    return args -> {
      Student john = new Student(
        1L, 
        "John", 
        "Shade", 
        "johnshade@gmail.com", 
        5,
        LocalDate.of(2000, Month.JANUARY, 5)
      );
      Student alex = new Student(
        "Alex", 
        "Bright", 
        "alexbright@gmail.com", 
        2,
        LocalDate.of(2004, Month.JANUARY, 5) 
      );

      repository.saveAll(
        List.of(john, alex)
      );
    }; 

  }
}
