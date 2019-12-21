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

import br.com.escola.model.Aluno;
import br.com.escola.repository.AlunoRepository;

@Controller
public class CriarAlunoController {
	@Autowired
	private AlunoRepository alunoRepo;
	
	@GetMapping(value = {"/criar_aluno"})
	public ModelAndView criarAluno() {
		ModelAndView mv = new ModelAndView("criar_aluno");
		mv.addObject(new Aluno());
		return mv;
    }
    @PostMapping("/criarAluno")
	public String criarAluno(@ModelAttribute("aluno") @Validated Aluno aluno, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "redirect:/menu_admin";
		}else{	
			alunoRepo.save(aluno);
			return "redirect:/menu_admin";
		}
	}
}