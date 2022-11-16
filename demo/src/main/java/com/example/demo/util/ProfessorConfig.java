package com.example.demo.util;

import java.time.LocalDate;
import java.time.Month;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.entity.Professor;
import com.example.demo.persistence.ProfessorRepository;

import java.util.*;

@Configuration
public class ProfessorConfig {
  @Bean 
  CommandLineRunner commandLineRunnerProf(ProfessorRepository repository){
    return args -> {
      Professor vikram = new Professor(
        1L, 
        "Vikram", 
        "Pitchai", 
        "vpitchai@gmail.com", 
        LocalDate.of(1985, Month.FEBRUARY, 12)
      );
      Professor steve = new Professor(
        "Steve", 
        "Jobs", 
        "stevejobs@gmail.com", 
        LocalDate.of(1977, Month.JULY, 20) 
      );
      Professor fauzi = new Professor(
        "Richard", 
        "fauzi", 
        "rfauzi@gmail.com", 
        LocalDate.of(1977, Month.JULY, 20) 
      );
      Professor tim = new Professor(
        "Timothy", 
        "Burton", 
        "timothyburton@gmail.com", 
        LocalDate.of(1977, Month.JULY, 20) 
      );
      Professor ralph = new Professor(
        "Wreckit", 
        "Ralph", 
        "wreckitralph@gmail.com", 
        LocalDate.of(1977, Month.JULY, 20) 
      );
      Professor cindy = new Professor(
        "Cindy", 
        "Crawford", 
        "cindycrawford@gmail.com", 
        LocalDate.of(1977, Month.JULY, 20) 
      );
      Professor mandy = new Professor(
        "Mandy", 
        "Beckwith", 
        "mandybeckwith@gmail.com", 
        LocalDate.of(1977, Month.JULY, 20) 
      );
      Professor katie = new Professor(
        "Katie", 
        "Mertime", 
        "katiemertime@gmail.com", 
        LocalDate.of(1977, Month.JULY, 20) 
      );

      repository.saveAll(
        List.of(vikram, steve, fauzi, tim, ralph, cindy, mandy, katie)
      );
    }; 

  }
}
