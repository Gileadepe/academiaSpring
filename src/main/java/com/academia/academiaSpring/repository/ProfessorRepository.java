package com.academia.academiaSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.academia.academiaSpring.model.Professor;

public interface ProfessorRepository extends JpaRepository <Professor, Integer> {

}
