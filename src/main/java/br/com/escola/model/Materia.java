package br.com.escola.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @Data @AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "tb_materia")
public class Materia {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	private Usuario usuario;
	private String nome;
	private String descricao;
	private String qtd_aulas;	
	private int status;	

}
