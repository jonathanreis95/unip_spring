package br.com.escola.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;

@Entity @Data @Table(name = "tb_usuario")
@Getter
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String login;
	private String senha;
	private String nome;
	private String cpf;
	private String dataCriacao;
	private int status;	
	
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
	private List<Materia> materias;
}
