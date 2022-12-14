package com.example.demo.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
  @Query("SELECT c FROM Course c WHERE c.name = ?1")
  Optional<Course> findCourseByName(String name); 
  @Query("SELECT c FROM Professor c WHERE c.id = ?1")
  Optional<Course> findProfessorById(Long id); 
}