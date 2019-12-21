package br.com.escola.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.escola.model.Usuario;
import br.com.escola.repository.UsuarioRepository;

@Controller
public class CriarUsuarioController {
	@Autowired
	private UsuarioRepository usuarioRepo;
	
	@GetMapping(value = {"/criar_professor"})
	public ModelAndView criarUsuario() {
		ModelAndView mv = new ModelAndView("criar_usuario");
		mv.addObject(new Usuario());
		return mv;
    }
    @PostMapping("/criarUsuario")
	public String criarUsuario(@ModelAttribute("usuario") @Validated Usuario usuario, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "redirect:/menu_admin";
		}else{	
			usuarioRepo.save(usuario);
			return "redirect:/menu_admin";
		}
	}
}