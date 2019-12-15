package br.com.escola.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.escola.model.Materia;

public interface MateriaRepository extends JpaRepository<Materia, Long> {
	List<Materia> findByUsuario(Long usuarioID);
}