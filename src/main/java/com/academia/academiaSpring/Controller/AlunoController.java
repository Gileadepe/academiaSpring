package com.academia.academiaSpring.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.academia.academiaSpring.model.Aluno;
import com.academia.academiaSpring.repository.AlunoRepository;




@RestController
@RequestMapping(value = "/aluno")
public class AlunoController {
	private List<Aluno> alunos = new ArrayList<Aluno>();
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	
	@PostMapping(value = "/post")
	public Aluno criarAluno(@RequestBody Aluno aluno) {
		return this.alunoRepository.save(aluno);
		
		//alunos.add(aluno);
	    //return "Aluno cadastrado com sucesso";
		
	}
	
	@GetMapping(value = "/get")
	public List<Aluno> exibirAlunos(){
		return this.alunoRepository.findAll();
		
		//return alunos;
	}
	
	@GetMapping(value = "/get/{id}")
	public Optional<Aluno> exibirAluno(@PathVariable ("id") int id) {
		return this.alunoRepository.findById(id);
		
	}
	
	@PutMapping("/put/{id}")
	public String attAlunos(@PathVariable("id") int id, @RequestBody Aluno newAluno) {
        Optional<Aluno> oldAluno =  this.alunoRepository.findById(id);
		
		if(oldAluno.isPresent()) {
			Aluno aluno = oldAluno.get();
			aluno.setId(newAluno.getId());
			aluno.setNome(newAluno.getNome());
			aluno.setIdade(newAluno.getIdade());
			aluno.setCpf(newAluno.getCpf());
			aluno.setNomeCurso(newAluno.getNomeCurso());
			alunoRepository.save(aluno);
			
			return "Aluno alterado com sucesso!";
		}else{
			return "Aluno inexistente no banco de dados!";
		}
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public String apagarAluno(@PathVariable("id") int id) {
		
		Optional<Aluno> alunoFind =  this.alunoRepository.findById(id);
		
		if(alunoFind.isPresent()) {
			alunoRepository.delete(alunoFind.get());
			return "Aluno excluído com sucesso!";
		}else{
			return "Aluno inexistente no banco de dados!";
		}
		
	}
	
	
	
	

}
