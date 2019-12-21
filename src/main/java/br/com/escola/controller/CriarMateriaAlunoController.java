package br.com.escola.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.escola.model.Aluno;
import br.com.escola.model.Materia;
import br.com.escola.repository.AlunoRepository;
import br.com.escola.repository.MateriaAlunoRepository;
import br.com.escola.repository.MateriaRepository;
import br.com.escola.model.MateriaAluno;

@Controller
public class CriarMateriaAlunoController {

	@Autowired
	private MateriaRepository materiaRepo;
	@Autowired
    private AlunoRepository alunoRepo;
    @Autowired
	private MateriaAlunoRepository materiaAlunoRepo;

	@GetMapping("/criar_materia_aluno")
	public ModelAndView criarMateriaAluno() {
		ModelAndView mv = new ModelAndView("criar_materia_aluno");
		List<Materia> materias = materiaRepo.findAll();
		mv.addObject("materias", materias);
        List<Aluno> alunos = alunoRepo.findAll();
        mv.addObject("alunos", alunos);
        List<MateriaAluno> materiaAlunos = materiaAlunoRepo.findAll();
        mv.addObject("materiaAlunos", materiaAlunos);
        mv.addObject(new MateriaAluno());
		return mv;
    }
    @PostMapping("/criarMateriaAluno")
	public String criarMateriaAluno(@ModelAttribute("materiaAluno") @Validated MateriaAluno materiaAluno, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "redirect:/criar_materia_aluno";
		}else{	
			materiaAlunoRepo.save(materiaAluno);
			return "redirect:/criar_materia_aluno";
		}
	}
	@PostMapping("/deletarMateriaAluno")
	public String deletarMateriaAluno(@RequestParam(required = false) String idma) {
			Long num = Long.parseLong(idma);
			materiaAlunoRepo.deleteById(num);
			return "redirect:/criar_materia_aluno";	
	}
}