package com.academia.academiaSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.academia.academiaSpring.model.Curso;

public interface CursoRepository extends JpaRepository<Curso, Integer> {

}
