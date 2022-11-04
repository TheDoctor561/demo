package com.example.demo.grade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*; 
@RestController
@RequestMapping(path = "api/v1/grade")

public class GradeController {
  private final GradeService gradeService;
  @Autowired
  public GradeController(GradeService gradeService){
    this.gradeService = gradeService; 
  }

  @GetMapping
	public List<Grade> getGrades() {
    return gradeService.getGrades(); 
	}

  @PostMapping
  public void registerNewGrade(@RequestBody Grade grade){
    gradeService.addNewGrade(grade);
  }
  // Need to figure out a way to delete the grade via usage of simply studentId and courseId
  @DeleteMapping
  public void deleteGrade(@RequestBody Grade grade) {
    gradeService.deleteGrade(grade); 
  }

  // @PutMapping(path = "{gradeId}")
  // public void updateGrade(
  //   @PathVariable("gradeId") Long gradeId, 
  //   @RequestParam(required = false) String firstName, 
  //   @RequestParam(required = false) String lastName, 
  //   @RequestParam(required = false) String email) {
  //     gradeService.updateGrade(gradeId, firstName, lastName, email);
  //   }
}
