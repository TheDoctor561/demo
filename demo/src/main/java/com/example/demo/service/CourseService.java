package com.example.demo.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Course;
import com.example.demo.entity.Professor;
import com.example.demo.persistence.CourseRepository;

@Service
public class CourseService {
  
  @Autowired
  private CourseRepository courseRepository; 
  
  public CourseService(CourseRepository courseRepository){
    this.courseRepository = courseRepository;
  }
  public List<Course> getCourses(){
    return courseRepository.findAll(); 
  }

  public void addNewCourse(Course course){
    Optional<Course> courseByName = courseRepository.findCourseByName(course.getName()); 
    Optional<Course> professorById = courseRepository.findProfessorById(course.getProfessorId()); 
    if (courseByName.isPresent()){
      throw new IllegalStateException("course already exists");
    }
    if (!professorById.isPresent()){
      throw new IllegalStateException("No such professor");
    }

    courseRepository.save(course);
  }

  // TO ADD When deleting course need to delete all grades associated with course
  
  public void deleteCourse(Long courseId){
    boolean exists = courseRepository.existsById(courseId); 
    if (!exists) {
      throw new IllegalStateException("professor with id " + courseId + " does not exist"); 
    }

    courseRepository.deleteById(courseId);
  }
}
