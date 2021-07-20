package com.academia.academiaSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.academia.academiaSpring.model.Aluno;

public interface AlunoRepository extends JpaRepository <Aluno, Integer> {

}
