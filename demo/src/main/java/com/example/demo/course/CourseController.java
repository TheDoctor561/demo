package com.example.demo.course;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*; 
@RestController
@RequestMapping(path = "api/v1/course")
public class CourseController {
  private final CourseService courseService;
  @Autowired
  public CourseController(CourseService courseService){
    this.courseService = courseService; 
  }

  @GetMapping
	public List<Course> getCourses() {
    return courseService.getCourses(); 
	}

  @PostMapping
  public void registerNewCourse(@RequestBody Course course){
    courseService.addNewCourse(course);
  }
  
  // Delete all grades with course attached to it 
  @DeleteMapping(path = "{courseId}")
  public void deleteCourse(@PathVariable("courseId") Long courseId) {
    courseService.deleteCourse(courseId); 
  }
  // Reinvent put to change professor 
  // @PutMapping(path = "{courseId}")
  // public void updateCourse(
  //   @PathVariable("courseId") Long courseId, 
  //   @RequestParam(required = false) String firstName, 
  //   @RequestParam(required = false) String lastName, 
  //   @RequestParam(required = false) String email) {
  //     courseService.updateCourse(courseId, firstName, lastName, email);
  //   }
}
