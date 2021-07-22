package com.academia.academiaSpring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.GroupSequence;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
@GroupSequence({Aluno.class})
public class Aluno{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column
	@NotBlank(message = "O campo NOME é obrigatório, por favor, informe um nome!")
	@Length(min = 3, max = 35, message = "O nome deverá ter no mínimo {min} e no máximo {max} carcteres!")
	private String nome;
	
	@Column
	@Min(18)
	private int idade;
	
	@Column
	@NotBlank(message = "O CPF é obrigatório!")
	@Length(min = 11, max = 14, message = "O CPF deverá ter entre {min} e {max} carcteres!")
	private String cpf;
	
	@ManyToOne
	@JoinColumn(name = "curso_id",nullable=false)
	private Curso curso;

}
