package br.com.escola.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.escola.model.MateriaAluno;
import br.com.escola.model.Materia;

public interface MateriaAlunoRepository extends JpaRepository<MateriaAluno, Long> {

    public MateriaAluno findById(String string);
	//@Query( "select m from MateriaAluno m where materia = :materia" )
	List<MateriaAluno> findByMateria(Materia materia);
	//List<MateriaAluno> findByMateria(Materia materia);
}