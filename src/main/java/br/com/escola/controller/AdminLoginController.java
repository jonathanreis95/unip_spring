package br.com.escola.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.escola.model.Admin;
import br.com.escola.service.LoginService;

@Controller
public class AdminLoginController {
	@Autowired
	private LoginService loginService;
	
	@GetMapping(value = {"/admin"})
	public ModelAndView loginAdmin() {
		ModelAndView mv = new ModelAndView("login_admin");
		mv.addObject(new Admin());
		return mv;
	}
	
	@PostMapping("/fazerLoginAdmin")
	public String fazerLoginAdmin(HttpServletRequest request, Admin admin) {
		if (loginService.logarAdmin(admin)) {
			request.getSession().setAttribute("adminLogado", admin);
			return "redirect:/menu_admin";
		}
		return "redirect:/admin";
	}
}