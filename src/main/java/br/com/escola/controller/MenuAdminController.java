package br.com.escola.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.escola.model.Admin;
import br.com.escola.model.Aluno;
import br.com.escola.model.Materia;
import br.com.escola.repository.AdminRepository;
import br.com.escola.repository.AlunoRepository;
import br.com.escola.repository.MateriaRepository;
import br.com.escola.model.Usuario;
import br.com.escola.repository.UsuarioRepository;

@Controller
public class MenuAdminController {

	@Autowired
	private MateriaRepository materiaRepo;
	@Autowired
	private UsuarioRepository usuarioRepo;
	@Autowired
	private AlunoRepository alunoRepo;
	@Autowired
	private AdminRepository adminRepo;

	@GetMapping("/menu_admin")
	public ModelAndView listaMaterias(HttpServletRequest request, Object handler) {
		ModelAndView mv = new ModelAndView("menu_admin");
		List<Materia> materias = materiaRepo.findAll();
		mv.addObject("materias", materias);
		List<Usuario> usuarios = usuarioRepo.findAll(Sort.by(Sort.Direction.DESC, "nome"));
		mv.addObject("usuarios", usuarios);
		List<Aluno> alunos = alunoRepo.findAll();
		mv.addObject("alunos", alunos);
		HttpSession session = request.getSession();
		Admin admin = (Admin) session.getAttribute("adminLogado");
		Admin admin2 = adminRepo.findOneByLoginAndSenha(admin.getLogin(), admin.getSenha());
		mv.addObject("admin", admin2);
		return mv;
	}
}