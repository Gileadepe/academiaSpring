package com.academia.academiaSpring.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.academia.academiaSpring.model.Professor;
import com.academia.academiaSpring.repository.ProfessorRepository;

@RestController
@RequestMapping(value = "professor")
public class ProfessorController {
	private List<Professor> professores = new ArrayList<Professor>();
	
	@Autowired
	private ProfessorRepository professorRepository;
	
	
	@PostMapping(value = "/post")
	public Professor criarProfessor(@Valid @RequestBody Professor professor) {
		return this.professorRepository.save(professor);
		
		//professores.add(professor);
		//return "Professor cadastrado com sucesso";
		
	}
	
	
	@GetMapping(value = "/get")
	public List<Professor> viewProfessor(){
		return professorRepository.findAll();
	}
	
	
	@GetMapping(value = "/get/{id}")
	public Optional<Professor> getProfessor(@PathVariable("id") int id) {
		return professorRepository.findById(id);
		
	}
	
	@PutMapping("/put/{id}")
	public String attProfessor(@PathVariable("id") int id, @RequestBody Professor newProfessor ) {
		Optional<Professor> oldProfessor = this.professorRepository.findById(id);
		
		if(oldProfessor.isPresent()) {
			Professor professor = oldProfessor.get();
			professor.setId(newProfessor.getId());
			professor.setNome(newProfessor.getNome());
			professor.setIdade(newProfessor.getIdade());
			professor.setCpf(newProfessor.getCpf());
			professor.setSalario(newProfessor.getSalario());
			professorRepository.save(professor);
			
			return "Os dados do professor foram ATUALIZADOS com sucesso!";
		}else {
			return "Os dados do professor NÂO foram ATUALIZADOS com sucesso!";
		}
		
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public String apagarProfessor(@PathVariable("id") int id) {
		
		Optional<Professor> professorFind = this.professorRepository.findById(id);
		
		if(professorFind.isPresent()) {
			professorRepository.delete(professorFind.get());
			return "Professor excluído com sucesso!";
		}else {
			return "Professor inexistente no banco de dados!";
		}
		
	}
	
	
	

}
