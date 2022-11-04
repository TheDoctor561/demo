package com.example.demo.grade;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.*;

@Configuration
public class GradeConfig {
  @Bean 
  CommandLineRunner commandLineRunnerGrade(GradeRepository repository){
    return args -> {
      Grade grade1 = new Grade(95.0, 1L, 1L); 
      Grade grade2 = new Grade(99.0, 1L, 2L); 
      Grade grade3 = new Grade(93.0, 1L, 3L); 
      repository.saveAll(
        List.of(grade1, grade2, grade3)
      );
    }; 
  }
  
}
