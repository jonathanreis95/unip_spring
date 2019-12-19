package br.com.escola.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import br.com.escola.model.Usuario;
import br.com.escola.repository.UsuarioRepository;
import br.com.escola.model.Admin;
import br.com.escola.repository.AdminRepository;

@Service
public class LoginService {
	@Autowired
	UsuarioRepository usuarioRepo;
	@Autowired
	AdminRepository adminRepo;
	
	public Optional<Usuario> logar(Usuario usuario) {
		return Optional.ofNullable(usuarioRepo.findOneByLoginAndSenha(usuario.getLogin(), usuario.getSenha()));
	}
	public boolean logarAdmin(Admin admin) {
		return adminRepo.findOneByLoginAndSenha(admin.getLogin(), admin.getSenha()) != null;
	}
}
