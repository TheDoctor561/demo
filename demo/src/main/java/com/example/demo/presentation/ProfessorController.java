package com.example.demo.presentation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Professor;
import com.example.demo.service.ProfessorService; 
@RestController
@RequestMapping(path = "api/v1/professor")
public class ProfessorController {
  private final ProfessorService professorService;
  @Autowired
  public ProfessorController(ProfessorService professorService){
    this.professorService = professorService; 
  }

  @GetMapping
	public List<Professor> getProfessors() {
    return professorService.getProfessors(); 
	}

  @PostMapping
  public void registerNewProfessor(@RequestBody Professor professor){
    professorService.addNewProfessor(professor);
  }
  
  @DeleteMapping(path = "{professorId}")
  public void deleteProfessor(@PathVariable("professorId") Long professorId) {
    professorService.deleteProfessor(professorId); 
  }

  @PutMapping(path = "{professorId}")
  public void updateProfessor(
    @PathVariable("professorId") Long professorId, 
    @RequestParam(required = false) String firstName, 
    @RequestParam(required = false) String lastName, 
    @RequestParam(required = false) String email) {
      professorService.updateProfessor(professorId, firstName, lastName, email);
    }
}
