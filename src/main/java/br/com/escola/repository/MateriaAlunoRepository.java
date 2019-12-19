package br.com.escola.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.escola.model.MateriaAluno;
import br.com.escola.model.Aula;
import br.com.escola.model.Materia;

public interface MateriaAlunoRepository extends JpaRepository<MateriaAluno, Long> {
	//@Query( "select m from MateriaAluno m where materia = :materia" )
	List<MateriaAluno> findByMateria(Materia materia);
	
	//List<MateriaAluno> findByMateria(Materia materia);
}