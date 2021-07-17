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
import com.academia.academiaSpring.model.Aluno;

@RestController
@RequestMapping(value = "/aluno")
public class AlunoController {
	private List<Aluno> alunos = new ArrayList<Aluno>();
	
	
	@PostMapping(value = "/post")
	public String criarAluno(@RequestBody Aluno aluno) {
		alunos.add(aluno);
		return "Aluno cadastrado com sucesso";
		
	}
	
	@GetMapping(value = "/get")
	public List<Aluno> exibirAlunos(){
		return alunos;
	}
	
	@GetMapping(value = "/get/{id}")
	public Aluno exibirAluno(@PathVariable ("id") int id) {
		Aluno procurado = null;
		for(Aluno proc : alunos) {
			if(proc.getId() == id) {
				procurado = proc;
				System.out.println(procurado.toString());
			}
		}
		
		return procurado;
		
	}
	
	@PutMapping("/put/{id}")
	public void attAlunos(@PathVariable("id") int id, @RequestBody Aluno aluno) {
		for(int i = 0; i < alunos.size(); i++) {
			Aluno proc = alunos.get(i);
			if(proc.getId() == id) {
				alunos.set(i, aluno);
				System.out.println("Os dados foram ATUALIZADOS com sucesso!");
			}
		}
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public void apagarAluno(@PathVariable("id") int id) {
		int i = -1;
		Aluno procurado = null;
		for(Aluno proc : alunos) {
			if(proc.getId() == id) {
				i = alunos.indexOf(proc);
				procurado = proc;
				break;
			}
		}
		
		alunos.remove(i);
		
	}
	
	
	
	

}
