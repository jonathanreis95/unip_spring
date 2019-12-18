package br.com.escola.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.escola.model.Usuario;
import br.com.escola.service.LoginService;
import java.util.Optional;

@Controller
public class LoginController {
	@Autowired
	private LoginService loginService;
	
	@GetMapping(value = {"/login", "/"})
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView("login");
		mv.addObject(new Usuario());
		return mv;
	}
	
	@PostMapping("/fazerLogin")
	public String fazerLogin(HttpServletRequest request, Usuario usuario) {
		Optional<Usuario> opUsuario = loginService.logar(usuario);
				if (opUsuario.isPresent()) {
					request.getSession().setAttribute("usuarioLogado", opUsuario.get());
		 			return "redirect:/materias";
		 		}
		return "/login";
	}
}
