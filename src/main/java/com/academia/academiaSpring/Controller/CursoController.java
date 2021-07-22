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
import com.academia.academiaSpring.model.Curso;
import com.academia.academiaSpring.repository.CursoRepository;


@RestController
@RequestMapping(value = "/curso")
public class CursoController {
	private List<Curso> cursos = new ArrayList<Curso>();
	
	@Autowired
	private CursoRepository cursoRepository;
	
	
	@PostMapping(value = "/post")
	public Curso criarCurso(@Valid @RequestBody Curso curso) {
		return this.cursoRepository.save(curso);
		
	
		
	}
	
	@GetMapping(value = "/get")
	public List<Curso> exibirCursos(){
		return this.cursoRepository.findAll();
		
		
	}
	
	@GetMapping(value = "/get/{id}")
	public Optional<Curso> exibirCurso(@PathVariable ("id") int id) {
		return this.cursoRepository.findById(id);
		
	}
	
	@PutMapping("/put/{id}")
	public String attCursos(@PathVariable("id") int id, @RequestBody Curso newCurso) {
        Optional<Curso> oldCurso =  this.cursoRepository.findById(id);
		
		if(oldCurso.isPresent()) {
			Curso curso = oldCurso.get();
			curso.setId(newCurso.getId());
			curso.setNome(newCurso.getNome());
			
			cursoRepository.save(curso);
			
			return "Curso alterado com sucesso!";
		}else{
			return "Curso inexistente no banco de dados!";
		}
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public String apagarCurso(@PathVariable("id") int id) {
		
		Optional<Curso> cursoFind =  this.cursoRepository.findById(id);
		
		if(cursoFind.isPresent()) {
			cursoRepository.delete(cursoFind.get());
			return "Curso excluído com sucesso!";
		}else{
			return "Curso inexistente no banco de dados!";
		}
		
	}
	
	
	

}
