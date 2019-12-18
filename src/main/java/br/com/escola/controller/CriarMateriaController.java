package br.com.escola.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.data.domain.Sort;
import br.com.escola.model.Materia;
import br.com.escola.model.Usuario;
import br.com.escola.repository.MateriaRepository;
import br.com.escola.repository.UsuarioRepository;

@Controller
public class CriarMateriaController {
	@Autowired
	private MateriaRepository materiaRepo;
	@Autowired
	private UsuarioRepository usuarioRepo;
	
	@GetMapping(value = {"/criar_materia"})
	public ModelAndView criarMateria() {
		ModelAndView mv = new ModelAndView("criar_materia");
		mv.addObject(new Materia());
		List<Usuario> usuarios = usuarioRepo.findAll();
		mv.addObject("usuarios", usuarios);
		return mv;
    }
    @PostMapping("/criarMateria")
	public String criarAluno(@ModelAttribute("materia") @Validated Materia materia, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "redirect:/menu_admin";
		}else{	
			materiaRepo.save(materia);
			return "redirect:/menu_admin";
		}
	}
}