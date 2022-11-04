package com.example.demo.grade;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GradeRepository extends JpaRepository<Grade, Long> {
  @Query("SELECT g FROM Grade g WHERE g.studentId = ?1 AND g.courseId = ?2")
  Optional<Grade> findGradeById(Long studentId, Long courseId); 

}
