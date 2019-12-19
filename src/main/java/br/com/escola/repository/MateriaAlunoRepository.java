package br.com.escola.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.escola.model.MateriaAluno;

public interface MateriaAlunoRepository extends JpaRepository<MateriaAluno, Long> {
    public MateriaAluno findById(String string);
}