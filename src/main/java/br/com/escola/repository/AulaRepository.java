package br.com.escola.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.escola.model.Aula;
import br.com.escola.model.Materia;
import br.com.escola.model.MateriaAluno;


public interface AulaRepository extends JpaRepository<Aula, Long> {
	@Query( "select o from Aula o where materiaAluno in :ids" )
	List<Aula> findByMateriaAluno(@Param("ids") List<MateriaAluno> materiaAlunoRep);
	//List<Aula> findByMateriaAluno(List<MateriaAluno> materiaAlunoRep);
	
	@Modifying
	@Query("UPDATE Aula a SET a.presenca = :presenca where a.materiaAluno = :aluno_id")
	public void fazerChamada(String presenca, Long aluno_id);
	
}