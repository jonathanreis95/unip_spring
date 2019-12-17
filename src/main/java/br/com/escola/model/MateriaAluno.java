package br.com.escola.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity @Data @Table(name = "tb_materia_aluno")
public class MateriaAluno {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	private Materia materia;
	@ManyToOne
	private Aluno aluno;
	private String nota1;	
	private String nota2;
	private String total_falta;	
	private int status;	
	
}
