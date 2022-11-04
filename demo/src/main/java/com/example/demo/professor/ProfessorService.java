package com.example.demo.professor;


import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ProfessorService {
  private final ProfessorRepository professorRepository; 

  @Autowired
  public ProfessorService(ProfessorRepository professorRepository){
    this.professorRepository = professorRepository; 
  }
  public List<Professor> getProfessors() {
		return professorRepository.findAll(); 
	}

  public void addNewProfessor(Professor professor){
    Optional<Professor> professorByEmail = professorRepository.findProfessorByEmail(professor.getEmail());
    // Needs to be a better way to do this <=== 
    if (professorByEmail.isPresent()){
      throw new IllegalStateException("email taken"); 
    }
    professorRepository.save(professor); 
  }

  // TO ADD When deleting professor need to delete all the classes associated with the professor
  // as it stands the classes 
  public void deleteProfessor(Long professorId){
    boolean exists = professorRepository.existsById(professorId); 
    if (!exists) {
      throw new IllegalStateException("professor with id " + professorId + " does not exist"); 
    }
    professorRepository.deleteById(professorId);
  }

  @Transactional 
  public void updateProfessor(Long professorId, String firstName, String lastName, String email){
    Professor professor = professorRepository.findById(professorId)
    .orElseThrow(() -> new IllegalStateException("professor with id " + professorId + " does not exist"));
    if (firstName != null && 
      firstName.length() > 0 && 
      !Objects.equals(professor.getFirstName(), firstName)){
        professor.setFirstName(firstName); 
    }
    if (lastName != null && 
      lastName.length() > 0 && 
      !Objects.equals(professor.getLastName(), lastName)){
        professor.setLastName(lastName); 
    }

    if (email != null && 
      email.length() > 0 && 
      !Objects.equals(professor.getEmail(), email)){
        Optional<Professor> professorOptional = professorRepository.findProfessorByEmail(email); 
        if (professorOptional.isPresent()){
          throw new IllegalStateException("email taken");
        }
        professor.setEmail(email); 
    }
  }
}
