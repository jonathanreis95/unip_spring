package br.com.escola.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.escola.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}