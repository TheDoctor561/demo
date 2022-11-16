package com.example.demo.util;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.entity.Grade;
import com.example.demo.persistence.GradeRepository;

import java.util.*;

@Configuration
public class GradeConfig {
  @Bean 
  CommandLineRunner commandLineRunnerGrade(GradeRepository repository){
    return args -> {
      Grade grade1 = new Grade(95.0, 1L, 1L,1L); 
      Grade grade2 = new Grade(99.0, 1L, 2L, 1L); 
      Grade grade3 = new Grade(93.0, 1L, 3L, 3L); 
      Grade grade4 = new Grade(20.0, 2L, 4L, 4L); 
      Grade grade5 = new Grade(50.0, 2L, 3L, 3L); 
      Grade grade6 = new Grade(90.0, 1L, 5L, 5L); 
      Grade grade7 = new Grade(91.0, 1L, 6L, 6L); 
      repository.saveAll(
        List.of(grade1, grade2, grade3, grade4, grade5, grade6, grade7)
      );
    }; 
  }
  
}
