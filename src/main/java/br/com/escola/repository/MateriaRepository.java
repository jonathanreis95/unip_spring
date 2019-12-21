package br.com.escola.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.escola.model.Materia;
import br.com.escola.model.Usuario;

public interface MateriaRepository extends JpaRepository<Materia, Long> {
	List<Materia> findByUsuario(Usuario usuario);
	public Materia findOneById(Long id);
}