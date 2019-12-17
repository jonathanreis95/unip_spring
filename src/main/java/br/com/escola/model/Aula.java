package br.com.escola.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity @Data @Table(name = "tb_aula")
public class Aula {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	private MateriaAluno materiaAluno;
	private String descricao;
	private String presenca;	
	private String DataAula;
	private int status;	
	
}
