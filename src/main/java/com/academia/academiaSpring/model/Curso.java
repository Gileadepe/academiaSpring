package com.academia.academiaSpring.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Curso {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@NotBlank(message = "O campo NOME é obrigatório, por favor, informe um nome!")
	@Length(min = 3, max = 35, message = "O nome deverá ter no mínimo {min} e no máximo {max} carcteres!")
	private String nome;
	
	@JsonIgnore
	@OneToMany(mappedBy = "curso")
	private List<Aluno> aluno;

}
