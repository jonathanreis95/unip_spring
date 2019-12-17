package br.com.escola.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.escola.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	public Usuario findOneByLoginAndSenha(String login, String senha);
	@Override
	public Usuario save(Usuario usuario );
}
