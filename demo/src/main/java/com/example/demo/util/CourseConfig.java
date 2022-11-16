package com.example.demo.util;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.entity.Course;
import com.example.demo.persistence.CourseRepository;

import java.util.*;

@Configuration 
public class CourseConfig {
  @Bean 
  CommandLineRunner commandLineRunnerCourse(CourseRepository repository){
    return args -> {
      Course CMSC131 = new Course(
        1L, 
        "CMSC131", 
        1L
      );
      Course CMSC132 = new Course(
        "CMSC132",
        1L
      );
      Course CMSC251 = new Course(
        "CMSC251",
        3L
      );
      Course CMSC351 = new Course(
        "CMSC351",
        4L
      );
      Course CMSC451 = new Course(
        "CMSC451",
        5L
      );
      Course CMSC420 = new Course(
        "CMSC420",
        6L
      );
      Course CMSC414 = new Course(
        "CMSC414",
        7L
      );

      repository.saveAll(
        List.of(CMSC131, CMSC132, CMSC251, CMSC351, CMSC451, CMSC420, CMSC414)
      );
    };
  }
}
