package br.com.escola.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.escola.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {
	public Admin findOneByLoginAndSenha(String login, String senha);
}