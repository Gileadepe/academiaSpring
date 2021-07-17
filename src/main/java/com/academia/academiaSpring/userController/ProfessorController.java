package com.academia.academiaSpring.userController;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.academia.academiaSpring.model.Professor;

@RestController
@RequestMapping(value = "professor")
public class ProfessorController {
	private List<Professor> professores = new ArrayList<Professor>();
	
	
	@PostMapping(value = "/post")
	public String criarProfessor(@RequestBody Professor professor) {
		professores.add(professor);
		return "Professor cadastrado com sucesso";
		
	}
	
	
	@GetMapping(value = "/get")
	public List<Professor> viewProfessor(){
		return professores;
	}
	
	
	@GetMapping(value = "/get/{id}")
	public Professor getProfessor(@PathVariable("id") int id) {
		Professor procurado = null;
		for(Professor proc : professores) {
			if(proc.getId() == id) {
				procurado = proc;
			}
		}
		
		return procurado;
		
	}
	
	@PutMapping("/put/{id}")
	public void attProfessor(@PathVariable("id") int id, @RequestBody Professor professor ) {
		for(int i = 0; i < professores.size(); i++) {
			Professor proc = professores.get(i);
			if(proc.getId() == id) {
				professores.set(i, professor);
				System.out.println("Os dados do professor foram ATUALIZADOS com sucesso!");
			}
		}
		
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public void apagarProfessor(@PathVariable("id") int id) {
		int i = -1;
		Professor procurado = null;
		for(Professor proc : professores) {
			if(proc.getId() == id) {
				i = professores.indexOf(proc);
				procurado = proc;
				break;
			}
		}
		
		professores.remove(i);
		
	}
	
	
	

}
