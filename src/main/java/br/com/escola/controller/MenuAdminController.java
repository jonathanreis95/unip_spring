package br.com.escola.controller;

import java.util.List;

import org.apache.maven.model.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.escola.model.Aluno;
import br.com.escola.model.Materia;
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

	@GetMapping("/menu_admin")
	public ModelAndView listaMaterias() {
		ModelAndView mv = new ModelAndView("menu_admin");
		List<Materia> materias = materiaRepo.findAll();
		mv.addObject("materias", materias);
		List<Usuario> usuarios = usuarioRepo.findAll(Sort.by(Sort.Direction.DESC, "nome"));
		mv.addObject("usuarios", usuarios);
		List<Aluno> alunos = alunoRepo.findAll();
		mv.addObject("alunos", alunos);
		return mv;
	}
}