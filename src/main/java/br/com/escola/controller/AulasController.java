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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
	
	import br.com.escola.model.Aula;
import br.com.escola.model.Materia;
import br.com.escola.model.MateriaAluno;
import br.com.escola.repository.AulaRepository;
import br.com.escola.repository.MateriaAlunoRepository;
import br.com.escola.repository.MateriaRepository;

	@Controller
	public class AulasController {
		
		@Autowired
		private AulaRepository aulaRepo;
		private MateriaAlunoRepository materiaAlunoRepo;
		private MateriaRepository materiaRepo;
		
		
		@GetMapping("/aulas")
		public ModelAndView listaAulas(@RequestParam Long id) {
			ModelAndView mv = new ModelAndView("lista_aulas");
			/* TODO
			 * 1 - PASSAR E PEGAR O ID DA MATERIA POR PARAMETRO
			 * 2 - LISTAR SOMENTE AS AULAS QUE POSSUEM A MATERIA PASSADA POR PARAMETRO
			 * */
			
			//Materia materia = materiaRepo.getOne(id);			
			//List<MateriaAluno> materiaAlunoRep = materiaAlunoRepo.findByMateria(materia);
			//List<Aula> aulas = aulaRepo.findByMateriaAluno(materiaAlunoRep);
			List<Aula> aulas = aulaRepo.findAll();
			mv.addObject("aulas", aulas);
			//mv.addObject("ids", id);
			return mv;
		}
		
		/* TODO:
		 * CRIAR UM API QUE RECEBA MATERIA_ALUNO_ID OU ID DA AULA E DÊ UM UPDATE NO CAMPO PRESENÇA
		 * */
		@PostMapping("/fazerChamada")
		public String fazerChamada(@ModelAttribute("aula") @Validated Aula aula, BindingResult result, Model model) {
			if (result.hasErrors()) {
				return "error";
			}else{	
				//materiaAlunoRepo.finO
				//aulaRepo.fazerChamada(aula.getPresenca(), aula.getId());
				return "success";
			}
		}
		
		
	}