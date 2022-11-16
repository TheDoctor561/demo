

package com.example.demo.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {
  @Query("SELECT s FROM Professor s WHERE s.email = ?1")
  Optional<Professor> findProfessorByEmail(String email); 

}
